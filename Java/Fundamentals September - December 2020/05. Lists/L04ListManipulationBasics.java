import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("end")) {
            String[] commands = inputLine.split(" ");

            switch (commands[0]) {
                case "Add":
                    numbersList.add(Integer.parseInt(commands[1]));
                    break;
                case "Remove":
                    numbersList.remove(Integer.valueOf(Integer.parseInt(commands[1])));
                    break;
                case "RemoveAt":
                    numbersList.remove(Integer.parseInt(commands[1]));
                    break;
                case "Insert":
                    numbersList.add(Integer.parseInt(commands[2]), Integer.parseInt(commands[1]));
                    break;
            }

            inputLine = scanner.nextLine();
        }

        System.out.println(numbersList.toString().replaceAll("[\\[\\]\\,]", ""));
    }
}
