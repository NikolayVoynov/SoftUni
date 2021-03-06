package HealthyHeaven.src.healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {

    private List<Vegetable> products;
    private String name;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getTotalCalories() {
        int totalCalories = 0;
        for (Vegetable product : this.products) {
            totalCalories += product.getCalories();
        }

        return totalCalories;
    }

    public int getProductCount() {
        return this.products.size();
    }

    public void add(Vegetable product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("* Salad %s is %d calories and have %d products:"
                , this.name, getTotalCalories(), getProductCount()));

        for (Vegetable product : products) {
            sb.append(System.lineSeparator())
                    .append(product);
        }
        return sb.toString();
    }
}
