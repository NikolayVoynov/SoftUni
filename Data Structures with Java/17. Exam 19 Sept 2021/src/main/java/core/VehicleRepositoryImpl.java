package core;

import models.Vehicle;

import java.util.*;
import java.util.stream.Collectors;

public class VehicleRepositoryImpl implements VehicleRepository {
    private Map<String, List<Vehicle>> sellerWithListVehicles;
    private List<Vehicle> allVehicles;

    public VehicleRepositoryImpl() {
        this.sellerWithListVehicles = new TreeMap<>();
        this.allVehicles = new ArrayList<>();
    }

    @Override
    public void addVehicleForSale(Vehicle vehicle, String sellerName) {
        if (!this.sellerWithListVehicles.containsKey(sellerName)) {
            this.sellerWithListVehicles.put(sellerName, new LinkedList<>());
        }

        this.sellerWithListVehicles.get(sellerName).add(vehicle);
        this.allVehicles.add(vehicle);
    }

    @Override
    public void removeVehicle(String vehicleId) {
        Vehicle lookingForVehicle = null;

        for (Vehicle vehicle : allVehicles) {
            if (vehicle.getId().equals(vehicleId)) {
                lookingForVehicle = vehicle;
            }
        }

        if (lookingForVehicle == null) {
            throw new IllegalArgumentException();
        }

        this.allVehicles.remove(lookingForVehicle);

        for (List<Vehicle> value : this.sellerWithListVehicles.values()) {
            value.remove(lookingForVehicle);
        }
    }

    @Override
    public int size() {
        return this.allVehicles.size();
    }

    @Override
    public boolean contains(Vehicle vehicle) {
        return this.allVehicles.contains(vehicle);
    }

    @Override
    public Iterable<Vehicle> getVehicles(List<String> keywords) {
        return this.allVehicles
                .stream()
                .filter(v -> keywords.contains(v.getBrand()) || keywords.contains(v.getColor())
                        || keywords.contains(v.getModel()) || keywords.contains(v.getLocation()))
                .sorted((v1, v2) -> {

//                    POSSIBLE SWITCH!!!!!

                    if (v1.getIsVIP() != v2.getIsVIP()) {
                        return Boolean.compare(v1.getIsVIP(), v2.getIsVIP());
                    }

                    return Double.compare(v1.getPrice(), v2.getPrice());
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Vehicle> getVehiclesBySeller(String sellerName) {
        List<Vehicle> vehicles = this.sellerWithListVehicles.get(sellerName);
        if (vehicles.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return vehicles;
    }

    @Override
    public Iterable<Vehicle> getVehiclesInPriceRange(double lowerBound, double upperBound) {
        return this.allVehicles
                .stream()
                .filter(vehicle -> vehicle.getPrice() >= lowerBound & vehicle.getPrice() <= upperBound)
                .sorted((v1, v2) -> Integer.compare(v2.getHorsepower(), v1.getHorsepower()))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Vehicle>> getAllVehiclesGroupedByBrand() {
        if (this.allVehicles.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Map<String, List<Vehicle>> workMap = new HashMap<>();
        Map<String, List<Vehicle>> resultMap = new HashMap<>();

        for (Vehicle vehicle : allVehicles) {
            if (!workMap.containsKey(vehicle.getBrand())) {
                workMap.put(vehicle.getBrand(), new ArrayList<>());
            }
            workMap.get(vehicle.getBrand()).add(vehicle);
        }

        for (Map.Entry<String, List<Vehicle>> entry : workMap.entrySet()) {
            String brand = entry.getKey();
            List<Vehicle> vehicles = entry.getValue().stream().sorted((v1, v2) -> Double.compare(v1.getPrice(), v2.getPrice())).collect(Collectors.toList());
            resultMap.put(brand, vehicles);
        }

        return resultMap;
    }

    @Override
    public Iterable<Vehicle> getAllVehiclesOrderedByHorsepowerDescendingThenByPriceThenBySellerName() {
        Collection<List<Vehicle>> values = this.sellerWithListVehicles.values();
        List<Vehicle> collectionAllVehicles = new ArrayList<>();
        for (List<Vehicle> value : values) {
            collectionAllVehicles.addAll(value);
        }

        return collectionAllVehicles
                .stream()
                .sorted((v1, v2) -> {
                    if (v1.getHorsepower() != v2.getHorsepower()) {
                        return Integer.compare(v2.getHorsepower(), v1.getHorsepower());
                    }

                    return Double.compare(v1.getPrice(),v2.getPrice());
                })
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle buyCheapestFromSeller(String sellerName) {
        if (!this.sellerWithListVehicles.containsKey(sellerName)) {
            throw new IllegalArgumentException();
        }

        List<Vehicle> vehicles = this.sellerWithListVehicles.get(sellerName);

        if (vehicles.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Vehicle resultVehicle = null;
        double minPrice = Double.MAX_VALUE;

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPrice() < minPrice) {
                resultVehicle = vehicle;
                minPrice = vehicle.getPrice();
            }
        }

        this.sellerWithListVehicles.get(sellerName).remove(resultVehicle);
        this.allVehicles.remove(resultVehicle);

        return resultVehicle;
    }
}
