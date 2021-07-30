package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.TeamSeedRootDto;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.TeamRepository;
import softuni.exam.service.PictureService;
import softuni.exam.service.TeamService;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class TeamServiceImpl implements TeamService {
    private static final String TEAM_FILE_PATH = "src/main/resources/files/xml/teams.xml";

    private final TeamRepository teamRepository;
    private final PictureService pictureService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final FileUtil fileUtil;

    public TeamServiceImpl(TeamRepository teamRepository, PictureRepository pictureRepository, PictureService pictureService, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, FileUtil fileUtil) {
        this.teamRepository = teamRepository;
        this.pictureService = pictureService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.fileUtil = fileUtil;
    }

    @Override
    public String importTeams() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        xmlParser
                .fromFile(TEAM_FILE_PATH, TeamSeedRootDto.class)
                .getTeams()
                .stream()
                .filter(teamSeedDto -> {
                    boolean isValid = validationUtil.isValid(teamSeedDto)
                            && pictureService.isEntityExist(teamSeedDto.getTeamPictureDto().getUrl());

                    sb.append(isValid ? String.format("Successfully imported - %s", teamSeedDto.getName()) :
                                    "Invalid team")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(teamSeedDto -> {
                    Team team = modelMapper.map(teamSeedDto, Team.class);
                    team.setPicture(pictureService.findPictureByGivenUrl(teamSeedDto.getTeamPictureDto().getUrl()));

                    return team;
                })
                .forEach(teamRepository::save);


        return sb.toString();
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return fileUtil.readFile(TEAM_FILE_PATH);
    }

    @Override
    public Team findTeamByGivenNameAndPicUrl(String name, String pic_url) {
        return teamRepository.getTeamByNameAndPictureUrl(name, pic_url);
    }

    @Override
    public boolean isEntityExist(String teamName) {
        return teamRepository.existsTeamByName(teamName);
    }
}
