package aquarium.entities.aquariums;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity; // number of Fish аn Aquarium can have
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public int calculateComfort() {
        return this.decorations.stream().mapToInt(d -> d.getComfort()).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.fish.size() == this.capacity) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }

        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        for (Fish entity : fish) {
            entity.eat();
        }

    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):", this.name, this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append("Fish:");
        if (this.fish.isEmpty()) {
            sb.append(" none");
        } else {
            for (Fish entity : fish) {
                sb.append(String.format(" %s", entity.getName()));
            }
        }

        sb.append(System.lineSeparator())
                .append(String.format("Decorations: %d", this.decorations.size()));
        sb.append(System.lineSeparator())
                .append(String.format("Comfort: %d", this.calculateComfort()));

        return sb.toString().trim();
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
}
