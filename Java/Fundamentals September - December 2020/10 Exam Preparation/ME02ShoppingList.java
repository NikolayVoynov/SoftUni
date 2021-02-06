import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME02ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> groceries = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Urgent":
                    String urgentItem = tokens[1];
                    if (!groceries.contains(urgentItem)) {
                        groceries.add(0, urgentItem);
                    }
                    break;

                case "Unnecessary":
                    String unnecessaryItem = tokens[1];
                    if (groceries.contains(unnecessaryItem)) {
                        groceries.remove(unnecessaryItem);
                    }
                    break;

                case "Correct":
                    String oldItem = tokens[1];
                    String newItem = tokens[2];
                    if (groceries.contains(oldItem)) {
                        for (int i = 0; i < groceries.size(); i++) {
                            String current = groceries.get(i);
                            if (current.equals(oldItem)) {
                                groceries.remove(groceries.get(i));
                                groceries.add(i, newItem);
                            }
                        }
                    }
                    break;

                case "Rearrange":
                    String rearrangeItem = tokens[1];
                    if (groceries.contains(rearrangeItem)) {
                        for (int i = 0; i < groceries.size(); i++) {
                            String current = groceries.get(i);
                            if (current.equals(rearrangeItem)) {
                                groceries.remove(groceries.get(i));
                                groceries.add(rearrangeItem);
                            }
                        }
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(groceries.toString().replaceAll("[\\[\\]]", ""));

    }
}
