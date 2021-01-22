import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String commands = scanner.nextLine();

        while (!commands.equals("End")) {
            String[] tokens = commands.split("\\s+");

            switch (tokens[0]) {
                case "Add":
                    listNumbers.add(Integer.parseInt(tokens[1]));
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if (index < 0 || index >= listNumbers.size()) {
                        System.out.println("Invalid index");
                    } else {
                        listNumbers.add(index, Integer.parseInt(tokens[1]));
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(tokens[1]);
                    if (index < 0 || index >= listNumbers.size()) {
                        System.out.println("Invalid index");
                    } else {
                        listNumbers.remove(index);
                    }
                    break;
                case "Shift":
                    int counter = Integer.parseInt(tokens[2]);
                    if (tokens[1].equals("left")) {
                        for (int i = 0; i < counter; i++) {
                            int currentNumber = listNumbers.get(0);
                            listNumbers.add(currentNumber);
                            listNumbers.remove(0);
                        }

                    } else {
                        for (int i = 0; i < counter; i++) {
                            int currentNumber = listNumbers.get(listNumbers.size() - 1);
                            listNumbers.add(0, currentNumber);
                            listNumbers.remove(listNumbers.size() - 1);
                        }

                    }
                    break;
            }

            commands = scanner.nextLine();
        }

        System.out.print(listNumbers.toString().replaceAll("[\\[\\]\\,]", ""));

    }
}
