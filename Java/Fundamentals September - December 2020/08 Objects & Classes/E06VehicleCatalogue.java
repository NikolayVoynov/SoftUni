import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E06VehicleCatalogue {
    static class Vehicle {
        String type;
        String model;
        String color;
        int horsePower;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getHorsePower() {
            return horsePower;
        }

        public void setHorsePower(int horsePower) {
            this.horsePower = horsePower;
        }

        public Vehicle(String type, String model, String color, int horsePower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        public String toString() {
            return String.format
                    ("Type: %s%n" + "Model: %s%n" + "Color: %s%n" + "Horsepower: %d"
                            , getType().toUpperCase().charAt(0) + getType().substring(1)
                            , getModel(), getColor(), getHorsePower());
        }
    }

    public static double averageHorsepower(List<Vehicle> allVehicles) {
        if (allVehicles.size() == 0) {
            return 0.0;
        }
        return allVehicles.stream().mapToDouble(Vehicle::getHorsePower).sum() / allVehicles.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Vehicle> allVehicles = new ArrayList<>();

        while (!input.equals("End")) {

            String[] data = input.split(" ");
            String type = data[0];
            String model = data[1];
            String color = data[2];
            int horsePower = Integer.parseInt(data[3]);

            Vehicle vehicle = new Vehicle(type, model, color, horsePower);

            allVehicles.add(vehicle);

            input = scanner.nextLine();
        }

        String filterModel = scanner.nextLine();

        while (!filterModel.equals("Close the Catalogue")) {
            String model = filterModel;

            allVehicles
                    .stream()
                    .filter(vehicle -> vehicle.getModel().equals(model))
                    .forEach(vehicle -> System.out.println(vehicle.toString()));

            filterModel = scanner.nextLine();
        }

        List<Vehicle> cars = allVehicles
                .stream()
                .filter(vehicle -> vehicle.getType().equals("car"))
                .collect(Collectors.toList());

        List<Vehicle> trucks = allVehicles
                .stream()
                .filter(vehicle -> vehicle.getType().equals("truck"))
                .collect(Collectors.toList());

        System.out.printf("Cars have average horsepower of: %.2f.%n", averageHorsepower(cars));
        System.out.printf("Trucks have average horsepower of: %.2f.", averageHorsepower(trucks));

    }
}
