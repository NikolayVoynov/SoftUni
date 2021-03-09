package dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    public List<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        return this.data.removeIf(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model));
    }

    public Car getLatestCar() {
        Car latestCar = null;

        for (Car car : data) {
            if (latestCar == null || latestCar.getYear() < car.getYear()) {
                latestCar = car;
            }
        }

        return latestCar;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder(String.format("The cars are in a car dealership %s:", this.name));
        for (Car car : data) {
            sb.append(System.lineSeparator())
                    .append(car);
        }

        return sb.toString();
    }


}
