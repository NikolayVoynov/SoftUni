import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("end")) {
            String[] command = inputLine.split(" ");

            switch (command[0]) {
                case "Contains":
                    if (numbersList.contains(Integer.parseInt(command[1]))) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    switch (command[1]) {
                        case "even":
                            for (int i = 0; i < numbersList.size(); i++) {
                                if (numbersList.get(i) % 2 == 0) {
                                    System.out.printf("%d" + " ", numbersList.get(i));
                                }
                            }
                            System.out.println();
                            break;
                        case "odd":
                            for (int i = 0; i < numbersList.size(); i++) {
                                if (numbersList.get(i) % 2 != 0) {
                                    System.out.printf("%d" + " ", numbersList.get(i));
                                }
                            }
                            System.out.println();
                            break;
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (int i = 0; i < numbersList.size(); i++) {
                        int currentNumber = numbersList.get(i);
                        sum += currentNumber;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    switch (command[1]) {
                        case ">=":
                            for (int i = 0; i < numbersList.size(); i++) {
                                int compareNumber = Integer.parseInt(command[2]);
                                int currentNumber = numbersList.get(i);
                                if (currentNumber >= compareNumber) {
                                    System.out.printf("%d" + " ", currentNumber);
                                }
                            }
                            System.out.println();
                            break;
                        case "<=":
                            for (int i = 0; i < numbersList.size(); i++) {
                                int compareNumber = Integer.parseInt(command[2]);
                                int currentNumber = numbersList.get(i);
                                if (currentNumber <= compareNumber) {
                                    System.out.printf("%d" + " ", currentNumber);
                                }
                            }
                            System.out.println();
                            break;
                        case ">":
                            for (int i = 0; i < numbersList.size(); i++) {
                                int compareNumber = Integer.parseInt(command[2]);
                                int currentNumber = numbersList.get(i);
                                if (currentNumber > compareNumber) {
                                    System.out.printf("%d" + " ", currentNumber);
                                }
                            }
                            System.out.println();
                            break;
                        case "<":
                            for (int i = 0; i < numbersList.size(); i++) {
                                int compareNumber = Integer.parseInt(command[2]);
                                int currentNumber = numbersList.get(i);
                                if (currentNumber < compareNumber) {
                                    System.out.printf("%d" + " ", currentNumber);
                                }
                            }
                            System.out.println();
                            break;
                    }
                    break;
            }


            inputLine = scanner.nextLine();
        }
    }
}
