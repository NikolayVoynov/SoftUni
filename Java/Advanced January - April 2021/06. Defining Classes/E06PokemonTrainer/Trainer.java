package E06PokemonTrainer;

import java.util.List;
import java.util.Map;

public class Trainer {

    private String trainerName;
    private int numberBadges;
    private List<Pokemon> collectionOfPokemon;

    public Trainer(String trainerName, int numberBadges, List<Pokemon> collectionOfPokemon) {
        this.trainerName = trainerName;
        this.numberBadges = numberBadges;
        this.collectionOfPokemon = collectionOfPokemon;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public int getNumberBadges() {
        return numberBadges;
    }

    public void setNumberBadges(int numberBadges) {
        this.numberBadges = numberBadges;
    }

    public List<Pokemon> getCollectionOfPokemon() {
        return collectionOfPokemon;
    }

    public void addPokemon(Pokemon pokemon) {
        this.collectionOfPokemon.add(pokemon);
    }

}

