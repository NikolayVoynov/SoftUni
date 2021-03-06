package HealthyHeaven.src.healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Salad> data;
    private String name;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public void add(Salad salad) {
        this.data.add(salad);
    }

    public boolean buy(String name) {
        return this.data.removeIf(salad -> salad.getName().equals(name));
    }

    public String getHealthiestSalad() {
        String healthiestSalad = null;
        int lowestCal = Integer.MAX_VALUE;
        for (Salad salad : this.data) {
            if (salad.getTotalCalories() < lowestCal) {
                lowestCal = salad.getTotalCalories();
                healthiestSalad = salad.getName();
            }
        }

        return healthiestSalad;
    }

    public String generateMenu() {
        StringBuilder sb = new StringBuilder(String.format("%s have %d salads:", this.name, this.data.size()));

        for (Salad salad : this.data) {
            sb.append(System.lineSeparator())
                    .append(salad);
        }

        return sb.toString();
    }
}
