import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME03Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> journal = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Craft!")) {
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String item = tokens[1];

            switch (command) {
                case "Collect":
                    if (!journal.contains(item)) {
                        journal.add(item);
                    }
                    break;

                case "Drop":
                    if (journal.contains(item)) {
                        journal.remove(item);
                    }
                    break;

                case "Combine Items":
                    String[] combine = item.split("\\:");
                    String oldItem = combine[0];
                    String newItem = combine[1];

                    if (journal.contains(oldItem)) {
                        int index = journal.indexOf(oldItem);
                        journal.add(index + 1, newItem);

                    }
                    break;

                case "Renew":
                    if (journal.contains(item)) {
                        journal.remove(item);
                        journal.add(item);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.print(journal.toString().replaceAll("[\\[\\]]", ""));
    }
}
