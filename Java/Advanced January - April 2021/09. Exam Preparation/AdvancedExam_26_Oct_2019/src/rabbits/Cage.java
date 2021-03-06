package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {

    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < this.capacity) {
            this.data.add(rabbit);
        }
    }

    public int count() {
        return this.data.size();
    }

    public boolean removeRabbit(String rabbit_name) {

        return this.data.removeIf(rabbit -> rabbit.getName().equals(rabbit_name));
    }

    public void removeSpecies(String species) {
        this.data.removeIf(rabbit -> rabbit.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbitToReturn = null;
        for (Rabbit rabbit : this.data) {
            if (rabbit.getName().equals(name)) {
                rabbitToReturn = rabbit;
                rabbit.setAvailable(false);
            }
        }
        return rabbitToReturn;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> soldRabbits = this.data.stream()
                .filter(rabbit -> rabbit.getSpecies().equals(species)).collect(Collectors.toList());

        this.data.removeIf(rabbit -> rabbit.getSpecies().equals(species));

        return soldRabbits;
    }

    public String report() {
        StringBuilder sb = new StringBuilder(String.format("Rabbits available at %s:", this.name));
        for (Rabbit rabbit : data) {

            if (rabbit.isAvailable()) {
                sb.append(System.lineSeparator())
                        .append(rabbit);
            }
        }


        return sb.toString();
    }
}
