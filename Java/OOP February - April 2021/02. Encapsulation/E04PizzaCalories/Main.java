package E04PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaInfo = scanner.nextLine().split("\\s+");
        String[] doughInfo = scanner.nextLine().split("\\s+");

        Pizza pizza;

        try {
            pizza = new Pizza(pizzaInfo[1], Integer.parseInt(pizzaInfo[2]));
            Dough dough = new Dough(doughInfo[1], doughInfo[2], Double.parseDouble(doughInfo[3]));
            pizza.setDough(dough);

            for (int i = 0; i < Integer.parseInt(pizzaInfo[2]); i++) {
                String[] toppingInfo = scanner.nextLine().split("\\s+");
                Topping topping = new Topping(toppingInfo[1], Double.parseDouble(toppingInfo[2]));

                pizza.addTopping(topping);
            }

//            String input = scanner.nextLine();
//
//            while (!input.equals("END")) {
//                String[] toppingInfo = input.split("\\s+");
//                Topping topping = new Topping(toppingInfo[1], Double.parseDouble(toppingInfo[2]));
//
//                pizza.addTopping(topping);
//
//                input = scanner.nextLine();
//            }

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return;
        }

        System.out.println(String.format("%s - %.2f", pizza.getName(), pizza.getOverallCalories()));

    }
}
