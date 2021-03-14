package P06GreedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(capacity);

        for (int i = 0; i < input.length; i += 2) {
            String item = input[i];
            long quantity = Long.parseLong(input[i + 1]);

            if (item.length() == 3) {
                // add cash to bag
                bag.addCash(item, quantity);

            } else if (item.toLowerCase().endsWith("gem")) {
                // add gems to bag
                bag.addGems(item, quantity);

            } else if (item.toLowerCase().equals("gold")) {
                // add gold to bag
                bag.addGold(quantity);
            }

        }
        bag.printContent();
    }
}