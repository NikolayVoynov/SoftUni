package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.PlayerSeedDto;
import softuni.exam.domain.entities.Player;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.service.PictureService;
import softuni.exam.service.PlayerService;
import softuni.exam.service.TeamService;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class PlayerServiceImpl implements PlayerService {
    private static final String PLAYERS_FILE_PATH = "src/main/resources/files/json/players.json";

    private final PlayerRepository playerRepository;
    private final PictureService pictureService;
    private final TeamService teamService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;
    private final Gson gson;

    public PlayerServiceImpl(PlayerRepository playerRepository, PictureService pictureService, TeamService teamService, ModelMapper modelMapper, ValidationUtil validationUtil, FileUtil fileUtil, Gson gson) {
        this.playerRepository = playerRepository;
        this.pictureService = pictureService;
        this.teamService = teamService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
        this.gson = gson;
    }

    @Override
    public String importPlayers() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readPlayersJsonFile(), PlayerSeedDto[].class))
                .filter(playerSeedDto -> {
                    boolean isValid = validationUtil.isValid(playerSeedDto)
                            && pictureService.isEntityExist(playerSeedDto.getPicture().getUrl())
                            && teamService.isEntityExist(playerSeedDto.getTeam().getName())
                            && pictureService.isEntityExist(playerSeedDto.getTeam().getPicture().getUrl());

                    sb.append(isValid ? String.format("Successfully imported player: %s %s",
                                    playerSeedDto.getFirstName(), playerSeedDto.getLastName()) : "Invalid player")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(playerSeedDto -> {
                    Player player = modelMapper.map(playerSeedDto, Player.class);

                    player
                            .setPicture(pictureService
                                    .findPictureByGivenUrl(playerSeedDto.getPicture().getUrl()));

                    player.setTeam(teamService.findTeamByGivenNameAndPicUrl(playerSeedDto.getTeam().getName(),
                            playerSeedDto.getTeam().getPicture().getUrl()));

                    return player;
                })
                .forEach(playerRepository::save);

        return sb.toString();
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return fileUtil.readFile(PLAYERS_FILE_PATH);
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        BigDecimal salary = BigDecimal.valueOf(100000);
        StringBuilder sb = new StringBuilder();

        playerRepository
                .findAllBySalaryGreaterThanOrderBySalaryDesc(salary)
                .forEach(player -> {
                    sb.append(String.format("Player name: %s %s", player.getFirstName(), player.getLastName()))
                            .append(System.lineSeparator())
                            .append(String.format("\tNumber: %d", player.getNumber()))
                            .append(System.lineSeparator())
                            .append(String.format("\tSalary: %s", player.getSalary()))
                            .append(System.lineSeparator())
                            .append(String.format("\tTeam: %s", player.getTeam().getName()))
                            .append(System.lineSeparator());
                });
        return sb.toString().trim();
    }

    @Override
    public String exportPlayersInATeam() {
        String teamName = "North Hub";
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Team: %s", teamName))
                .append(System.lineSeparator());

        playerRepository
                .findPlayerByTeamNameOrderById(teamName)
                .forEach(player -> {
                    sb.append(String.format("Player name: %s %s - %s",
                                    player.getFirstName(), player.getLastName(), player.getPosition()))
                            .append(System.lineSeparator())
                            .append(String.format("Number: %d", player.getNumber()))
                            .append(System.lineSeparator());
                });

        return sb.toString().trim();
    }
}
