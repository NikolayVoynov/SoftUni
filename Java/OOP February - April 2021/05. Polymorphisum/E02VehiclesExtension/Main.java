package E02VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        String[] truckInfo = scanner.nextLine().split("\\s+");
        String[] busInfo = scanner.nextLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));
        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3]));
        Vehicle bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] token = scanner.nextLine().split("\\s+");
            try {

                switch (token[0]) {
                    case "Drive":
                        if (token[1].equals("Car")) {
                            System.out.println(car.drive(Double.parseDouble(token[2])));
                        } else if (token[1].equals("Truck")) {
                            System.out.println(truck.drive(Double.parseDouble(token[2])));
                        } else {
                            System.out.println(bus.drive(Double.parseDouble(token[2])));
                        }
                        break;
                    case "Refuel":
                        if (token[1].equals("Car")) {
                            car.refuel(Double.parseDouble(token[2]));
                        } else if (token[1].equals("Truck")) {
                            truck.refuel(Double.parseDouble(token[2]));
                        } else {
                            bus.refuel(Double.parseDouble(token[2]));
                        }
                        break;
                    case "DriveEmpty":
                        System.out.println(bus.drive(Double.parseDouble(token[2])));
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
