package CounterStriker.repositories;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;

public class GunRepository implements Repository<Gun> {
    private Collection<Gun> guns;

    public GunRepository() {
        this.guns = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getGuns() {
        return this.guns;
    }

    @Override
    public void add(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_GUN_REPOSITORY);
        }
        this.guns.add(gun);
    }

    @Override
    public boolean remove(Gun gun) {
        return this.guns.remove(gun);
    }

    @Override
    public Gun findByName(String name) {
        return this.guns.stream().filter(g->g.getName().equals(name)).findFirst().orElse(null);
    }
}
