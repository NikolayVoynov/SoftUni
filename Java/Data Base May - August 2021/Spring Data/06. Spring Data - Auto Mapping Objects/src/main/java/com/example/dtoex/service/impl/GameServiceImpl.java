package com.example.dtoex.service.impl;

import com.example.dtoex.modul.dto.GameAddDto;
import com.example.dtoex.modul.entity.Game;
import com.example.dtoex.repository.GameRepository;
import com.example.dtoex.service.GameService;
import com.example.dtoex.service.UserService;
import com.example.dtoex.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public GameServiceImpl(GameRepository gameRepository, UserService userService, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public void addGame(GameAddDto gameAddDto) {

        Set<ConstraintViolation<GameAddDto>> violations = validationUtil.getViolations(gameAddDto);

        if (!violations.isEmpty()) {
            violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            return;
        }

        Game game = modelMapper.map(gameAddDto, Game.class);
//        game.setReleaseDate(LocalDate.parse(gameAddDto.getReleaseDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        gameRepository.save(game);

        System.out.println("Added game " + gameAddDto.getTitle());
    }

    @Override
    public void editGame(Long gameId, BigDecimal price, Double size) {
        Game game = gameRepository.findById(gameId).orElse(null);

        if (game == null) {
            System.out.println("Entered Id is no correct");
            return;
        }

        game.setPrice(price);
        game.setSize(size);

        gameRepository.save(game);

        System.out.println("Edited game " + game.getTitle());
    }

    @Override
    public void deleteGame(Long gameId) {
        Game game = gameRepository.findById(gameId).orElse(null);

        if (game == null) {
            System.out.println("Entered Id is not valid");
            return;
        }

        System.out.println("Deleted game " + game.getTitle());
        gameRepository.delete(game);
    }

    @Override
    public void printAllGamesTitlesAndPrices() {
        List<Game> allGames = new ArrayList<>(gameRepository.findAll());

        allGames.forEach(game -> System.out.printf("%s %.2f%n", game.getTitle(), game.getPrice()));
    }

    @Override
    public void printDetailGame(String gameTitle) {
        List<Game> gameList = gameRepository
                .findAll()
                .stream()
                .filter(currentGame -> currentGame.getTitle().equals(gameTitle))
                .limit(1)
                .collect(Collectors.toList());

        System.out.printf("Title: %s%n", gameList.get(0).getTitle());
        System.out.printf("Price: %.2f%n", gameList.get(0).getPrice());
        System.out.printf("Description: %s%n", gameList.get(0).getDescription());
        System.out.printf("Release date: %s%n", gameList.get(0).getReleaseDate().toString());
    }

//    @Override
//    public void purchaseGameByLoggedUser(String purchasedGameTitle) {
//
//    }
//
//    @Override
//    public void printGamesBoughtByLoggedUser() {
//
//    }
}
