package CounterStriker.repositories;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;

public class PlayerRepository implements Repository<Player>{
    private Collection<Player> models;

    public PlayerRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Player> getModels() {
        return null;
    }

    @Override
    public void add(Player player) {

    }

    @Override
    public boolean remove(Player player) {
        return false;
    }

    @Override
    public Player findByName(String name) {
        return null;
    }
}
