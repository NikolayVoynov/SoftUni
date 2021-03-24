package E01Vehicles;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        String[] truckInfo = scanner.nextLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] token = scanner.nextLine().split("\\s+");

            switch (token[0]) {
                case "Drive":
                    if (token[1].equals("Car")) {
                        System.out.println(car.drive(Double.parseDouble(token[2])));
                    } else {
                        System.out.println(truck.drive(Double.parseDouble(token[2])));
                    }
                    break;
                case "Refuel":
                    if (token[1].equals("Car")) {
                        car.refuel(Double.parseDouble(token[2]));
                    } else {
                        truck.refuel(Double.parseDouble(token[2]));
                    }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}
