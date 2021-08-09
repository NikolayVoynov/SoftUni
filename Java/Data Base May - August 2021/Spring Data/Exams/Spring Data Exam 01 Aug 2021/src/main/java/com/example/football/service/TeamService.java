package com.example.football.service;

import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;

import java.io.IOException;

//ToDo - Implement all methods
public interface TeamService {
    boolean areImported();

    String readTeamsFileContent() throws IOException;

    String importTeams() throws IOException;

    boolean isEntityExists(String name);

    Team findTeamByName(String name);

}
