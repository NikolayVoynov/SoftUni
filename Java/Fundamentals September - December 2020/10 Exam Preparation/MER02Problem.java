import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MER02Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] collection = scanner.nextLine().split("[|]");
        double budget = Double.parseDouble(scanner.nextLine());

        double clothesMaxPrice = 50.00;
        double shoesMaxPrice = 35.00;
        double accessoriesMaxPrice = 20.50;

        List<Double> newPricesList = new ArrayList<>();
        double spentMoney = 0;
        double sumNewPrices = 0;

        for (int i = 0; i < collection.length; i++) {
            String currentElement = collection[i];
            String[] token = currentElement.split("->");
            String type = token[0];
            double price = Double.parseDouble(token[1]);

            switch (type) {
                case "Clothes":
                    if (price <= clothesMaxPrice) {
                        if (price <= budget) {
                            budget -= price;
                            spentMoney += price;
                            double newPrice = price * 1.4;
                            sumNewPrices += newPrice;
                            newPricesList.add(newPrice);
                        }
                    }
                    break;

                case "Shoes":
                    if (price <= shoesMaxPrice) {
                        if (price <= budget) {
                            budget -= price;
                            spentMoney += price;
                            double newPrice = price * 1.4;
                            sumNewPrices += newPrice;
                            newPricesList.add(newPrice);
                        }
                    }
                    break;

                case "Accessories":
                    if (price <= accessoriesMaxPrice) {
                        if (price <= budget) {
                            budget -= price;
                            spentMoney += price;
                            double newPrice = price * 1.4;
                            sumNewPrices += newPrice;
                            newPricesList.add(newPrice);
                        }
                    }
                    break;
            }

        }

        List<String> newStringPricesList = new ArrayList<>();

        for (int i = 0; i < newPricesList.size(); i++) {

           String item = String.format("%.2f", newPricesList.get(i));
           newStringPricesList.add(item);

        }

        System.out.println(String.join(" ", newStringPricesList));

        double profit = sumNewPrices - spentMoney;

        System.out.printf("Profit: %.2f%n", profit);

        double newBudget = budget + sumNewPrices;

        if (newBudget >= 150) {
            System.out.println("Hello, France!");
        } else {
            System.out.println("Time to go.");
        }


    }
}
