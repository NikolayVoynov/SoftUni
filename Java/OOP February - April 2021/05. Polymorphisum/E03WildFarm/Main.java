package E03WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String input = "";

        while (!"End".equals(input = scanner.nextLine())) {
            String[] animalInfo = input.split("\\s+");
            String animalType = animalInfo[0];
            String animalName = animalInfo[1];
            Double animalWeight = Double.parseDouble(animalInfo[2]);
            String livingRegion = animalInfo[3];

            Animal animal = null;

            switch (animalType) {
                case "Mouse":
                    animal = new Mouse(animalType, animalName, animalWeight, livingRegion);
                    break;
                case "Cat":
                    String breed = animalInfo[4];
                    animal = new Cat(animalType, animalName, animalWeight, livingRegion, breed);
                    break;
                case "Tiger":
                    animal = new Tiger(animalType, animalName, animalWeight, livingRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(animalType, animalName, animalWeight, livingRegion);
                    break;
            }

            animal.makeSound();

            String[] foodInfo = scanner.nextLine().split("\\s+");
            String typeFood = foodInfo[0];
            Integer quantity = Integer.parseInt(foodInfo[1]);
            Food food = null;

            if (typeFood.equals("Vegetable")) {
                food = new Vegetable(quantity);
            } else {
                food = new Meat(quantity);
            }

            try {
                animal.eat(food);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }

            animals.add(animal);
        }
        animals.forEach(System.out::println);
    }
}
