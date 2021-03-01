package E04RawData;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Car> cars = new LinkedHashMap<>();

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            String[] inputCar = scanner.nextLine().split("\\s+");
            String model = inputCar[0];

            int speed = Integer.parseInt(inputCar[1]);
            int power = Integer.parseInt(inputCar[2]);
            Engine engine = new Engine(speed, power);

            Tier[] tiers = new Tier[4];
            int count = 0;
            for (int j = 5; j < inputCar.length; j += 2) {
                double pressure = Double.parseDouble(inputCar[j]);
                int age = Integer.parseInt(inputCar[j + 1]);
                tiers[count] = new Tier(pressure, age);
                count++;
            }

            int weight = Integer.parseInt(inputCar[3]);
            String type = inputCar[4];
            Cargo cargo = new Cargo(weight, type);

            Car car = new Car(model, engine, cargo, tiers);
            cars.putIfAbsent(model, car);
        }

        String cargoFilter = scanner.nextLine();

        for (Car car : cars.values()) {
            if (cargoFilter.equals("flamable")
                    && car.getCargo().getType().equals("flamable")
                    && car.getEngine().getPower() > 250) {

                System.out.println(car.getModel());

            } else if (cargoFilter.equals("fragile")
                    && car.getCargo().getType().equals("fragile")
                    && car.hasTireUnderPressureOne()) {

                System.out.println(car.getModel());
            }
        }
    }
}
