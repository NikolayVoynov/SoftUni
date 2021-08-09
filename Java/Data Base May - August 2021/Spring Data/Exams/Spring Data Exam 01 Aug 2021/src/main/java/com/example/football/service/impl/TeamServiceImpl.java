package com.example.football.service.impl;

import com.example.football.models.dto.TeamSeedDto;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class TeamServiceImpl implements TeamService {
    private static final String TEAMS_FILE_PATH = "src/main/resources/files/json/teams.json";

    private final TeamRepository teamRepository;
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public TeamServiceImpl(TeamRepository teamRepository, TownRepository townRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public String importTeams() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readTeamsFileContent(), TeamSeedDto[].class))
                .filter(teamSeedDto -> {
                    boolean isValid = validationUtil.isValid(teamSeedDto)
                            && !isEntityExists(teamSeedDto.getName());

                    sb.append(isValid ? String.format("Successfully imported Team %s - %d",
                                    teamSeedDto.getName(), teamSeedDto.getFanBase()) :
                                    "Invalid Team")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(teamSeedDto -> {
                    Team team = modelMapper.map(teamSeedDto, Team.class);
                    team.setTown(townRepository.getTownByName(teamSeedDto.getTownName()));

                    return team;
                })
                .forEach(teamRepository::save);

        return sb.toString();
    }

    @Override
    public boolean isEntityExists(String name) {
        return teamRepository.existsTeamByName(name);
    }

    @Override
    public Team findTeamByName(String name) {
        return teamRepository.getTeamByName(name);
    }


}
