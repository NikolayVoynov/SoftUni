package com.example.football.service.impl;

import com.example.football.models.dto.PlayerSeedRootDto;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.time.LocalDate;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static final String PLAYERS_FILE_PATH = "src/main/resources/files/xml/players.xml";

    private final PlayerRepository playerRepository;
    private final StatRepository statRepository;
    private final TownServiceImpl townServiceImpl;
    private final StatServiceImpl statServiceImpl;
    private final TeamServiceImpl teamServiceImpl;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public PlayerServiceImpl(PlayerRepository playerRepository, StatRepository statRepository, TownService townService, StatService statService, TeamService teamService, TownServiceImpl townServiceImpl, StatServiceImpl statServiceImpl, TeamServiceImpl teamServiceImpl, ValidationUtil validationUtil, ModelMapper modelMapper, XmlParser xmlParser) {
        this.playerRepository = playerRepository;
        this.statRepository = statRepository;
        this.townServiceImpl = townServiceImpl;
        this.statServiceImpl = statServiceImpl;
        this.teamServiceImpl = teamServiceImpl;

        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }


    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        xmlParser
                .fromFile(PLAYERS_FILE_PATH, PlayerSeedRootDto.class)
                .getPlayers()
                .stream()
                .filter(playerSeedDto -> {
                    boolean isValid = validationUtil.isValid(playerSeedDto)
                            && !isEntityExists(playerSeedDto.getEmail())
                            && isStatIdExists(playerSeedDto.getStat().getIg());

                    sb.append(isValid ? String.format("Successfully imported Player %s %s - %s",
                                    playerSeedDto.getFirstName(), playerSeedDto.getLastName(), playerSeedDto.getPosition()) :
                                    "Invalid Player")
                            .append(System.lineSeparator());

                    return isValid;

                })
                .map(playerSeedDto -> {
                    Player player = modelMapper.map(playerSeedDto, Player.class);

                    player.setTown(townServiceImpl.getTownByName(playerSeedDto.getTown().getName()));
                    player.setTeam(teamServiceImpl.findTeamByName(playerSeedDto.getTeam().getName()));
                    player.setStat(statServiceImpl.findStatById(playerSeedDto.getStat().getIg()));

                    return player;
                })
                .forEach(playerRepository::save);

        return sb.toString();
    }

    @Override
    public String exportBestPlayers() {

        StringBuilder sb = new StringBuilder();

        playerRepository
                .findPlayersWithBdBetweenOrderBYShootPassEndLastName()
                .forEach(player -> {
                    sb.append(String.format("Player - %s %s", player.getFirstName(), player.getLastName()))
                            .append(System.lineSeparator())
                            .append(String.format("\tPosition - %s", player.getPosition()))
                            .append(System.lineSeparator())
                            .append(String.format("\tTeam - %s", player.getTeam().getName()))
                            .append(System.lineSeparator())
                            .append(String.format("\tStadium - %s",player.getTeam().getStadiumName()))
                            .append(System.lineSeparator());

                });

        return sb.toString();
    }

    @Override
    public boolean isEntityExists(String email) {
        return playerRepository.existsPlayerByEmail(email);
    }

    private boolean isStatIdExists(Long id) {
        return statRepository.existsById(id);
    }
}
