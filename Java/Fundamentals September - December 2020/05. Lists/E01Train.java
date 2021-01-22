import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagon = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int maxCapacityWagon = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");

            if (tokens[0].equals("Add")) {
                int addPassengers = Integer.parseInt(tokens[1]);
                wagon.add(addPassengers);

            } else {
                for (int i = 0; i < wagon.size(); i++) {
                    int addPassengers = Integer.parseInt(tokens[0]);
                    int currentCapacityWagon = wagon.get(i) + addPassengers;
                    if (currentCapacityWagon <= maxCapacityWagon) {
                        wagon.set(i,currentCapacityWagon);
                        break;
                    }
                }

            }

            input = scanner.nextLine();
        }

        System.out.print(wagon.toString().replaceAll("[\\[\\]\\,]", ""));
    }
}
