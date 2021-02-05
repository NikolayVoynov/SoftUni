import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FER03NeedForSpeed3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, int[]> carInfo = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String car = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);

            int[] carMileageFuel = new int[]{mileage, fuel};

            carInfo.put(car, carMileageFuel);
        }

        String commands = scanner.nextLine();

        while (!commands.equals("Stop")) {
            String[] tokens = commands.split(" : ");
            String command = tokens[0];
            String car = tokens[1];

            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int fuelDrive = Integer.parseInt(tokens[3]);

                    if (fuelDrive > carInfo.get(car)[1]) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        carInfo.get(car)[0] += distance;
                        carInfo.get(car)[1] -= fuelDrive;
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n"
                                , car, distance, fuelDrive);
                        if (carInfo.get(car)[0] >= 100000) {
                            carInfo.remove(car);
                            System.out.printf("Time to sell the %s!%n", car);
                        }
                    }
                    break;

                case "Refuel":
                    int fuelRefuel = Integer.parseInt(tokens[2]);
                    int currentCarFuel = carInfo.get(car)[1];
                    carInfo.get(car)[1] += fuelRefuel;

                    if (carInfo.get(car)[1] > 75) {
                        carInfo.get(car)[1] = 75;
                        fuelRefuel = 75 - currentCarFuel;
                    }
                    System.out.printf("%s refueled with %d liters%n", car, fuelRefuel);
                    break;

                case "Revert":
                    int kilometers = Integer.parseInt(tokens[2]);
                    carInfo.get(car)[0] -= kilometers;

                    if (carInfo.get(car)[0] < 10000) {
                        carInfo.get(car)[0] = 10000;
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                    }
                    break;
            }

            commands = scanner.nextLine();
        }

        carInfo.entrySet().stream()
                .sorted((a, b) -> {
                    int result = b.getValue()[0] - a.getValue()[0];

                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }

                    return result;
                })
                .forEach(e -> {
                    System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n"
                            , e.getKey(), e.getValue()[0], e.getValue()[1]);
                });
    }
}
