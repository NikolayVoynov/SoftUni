package E06PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputTrainerPokemonInfo = scanner.nextLine();

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (!inputTrainerPokemonInfo.equals("Tournament")) {
            String[] token = inputTrainerPokemonInfo.split("\\s+");
            String trainerName = token[0];
            String pokemonName = token[1];
            String pokemonElement = token[2];
            int pokemonHealth = Integer.parseInt(token[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainers.putIfAbsent(trainerName, new Trainer(trainerName, 0, new ArrayList<>()));
            trainers.get(trainerName).addPokemon(pokemon);

            inputTrainerPokemonInfo = scanner.nextLine();
        }

        String checkElement = scanner.nextLine();

        while (!checkElement.equals("End")) {

            for (Map.Entry<String, Trainer> trainer : trainers.entrySet()) {
                int matchedPokemon = 0;
                int currentNumberBadges = 0;

                if (trainer.getValue().getCollectionOfPokemon().size() > 0) {
                    for (Pokemon pokemon : trainer.getValue().getCollectionOfPokemon()) {
                        if (pokemon.getPokemonElement().equals(checkElement)) {
                            matchedPokemon++;
                        }
                    }

                    if (matchedPokemon > 0) {
                        currentNumberBadges = trainer.getValue().getNumberBadges();
                        trainer.getValue().setNumberBadges(currentNumberBadges + 1);
                    } else {
                        for (Pokemon pokemon : trainer.getValue().getCollectionOfPokemon()) {
                            int currentPokemonHealth = pokemon.getPokemonHealth();
                            pokemon.setPokemonHealth(currentPokemonHealth - 10);
                        }

                        trainer.getValue().getCollectionOfPokemon().removeIf(pokemon -> pokemon.getPokemonHealth() <= 0);
                    }
                }
            }

            checkElement = scanner.nextLine();
        }


        trainers.entrySet().stream()
                .sorted((t1, t2) -> Integer.compare(t2.getValue().getNumberBadges(), t1.getValue().getNumberBadges()))
                .forEach(trainer -> System.out.println(String.format("%s %s %s",
                        trainer.getKey(), trainer.getValue().getNumberBadges(), trainer.getValue().getCollectionOfPokemon().size())));

    }
}
