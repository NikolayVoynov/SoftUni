import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "Delete":
                    int removeNumber = Integer.parseInt(tokens[1]);
                    for (int i = 0; i < numbersList.size(); i++) {
                        if (removeNumber == numbersList.get(i)) {
                            if (numbersList.size() > i + 1) {
                                numbersList.set(i, numbersList.get(i + 1));
                                numbersList.remove(i + 1);
                                i = 0;
                            } else {
                                numbersList.remove(i);
                            }
                        }
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    int number = Integer.parseInt(tokens[1]);
                    numbersList.add(index, number);
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.print(numbersList.toString().replaceAll("[\\[\\]\\,]", ""));
    }
}
