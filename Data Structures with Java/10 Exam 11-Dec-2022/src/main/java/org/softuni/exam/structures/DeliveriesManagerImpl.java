package org.softuni.exam.structures;

import org.softuni.exam.entities.Deliverer;
import org.softuni.exam.entities.Package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DeliveriesManagerImpl implements DeliveriesManager {

    private Map<Deliverer, List<Package>> delivererWithPackages;
    private Map<Package, Deliverer> packagesMap;

    public DeliveriesManagerImpl() {
        this.delivererWithPackages = new HashMap<>();
        this.packagesMap = new HashMap<>();
    }

    @Override
    public void addDeliverer(Deliverer deliverer) {

        this.delivererWithPackages.put(deliverer, new ArrayList<>());
    }

    @Override
    public void addPackage(Package _package) {

        this.packagesMap.put(_package, null);
    }

    @Override
    public boolean contains(Deliverer deliverer) {
        return this.delivererWithPackages.containsKey(deliverer);
    }

    @Override
    public boolean contains(Package _package) {
        return this.packagesMap.containsKey(_package);
    }

    @Override
    public Iterable<Deliverer> getDeliverers() {
        return this.delivererWithPackages.keySet();
    }

    @Override
    public Iterable<Package> getPackages() {
        return this.packagesMap.keySet();
    }

    @Override
    public void assignPackage(Deliverer deliverer, Package _package) throws IllegalArgumentException {
        if (!contains(deliverer) || !contains(_package)) {
            throw new IllegalArgumentException();
        }

        this.delivererWithPackages.get(deliverer).add(_package);
        this.packagesMap.put(_package, deliverer);

    }

    @Override
    public Iterable<Package> getUnassignedPackages() {
        return this.packagesMap
                .entrySet()
                .stream()
                .filter(p -> p.getValue() == null)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Package> getPackagesOrderedByWeightThenByReceiver() {
        return this.packagesMap
                .entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = Double.compare(s.getKey().getWeight(), f.getKey().getWeight());

                    if (result == 0) {
                        result = f.getValue().getName().compareTo(s.getValue().getName());
                    }
                    return result;
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Deliverer> getDeliverersOrderedByCountOfPackagesThenByName() {
        return this.delivererWithPackages
                .entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = Integer.compare(s.getValue().size(), f.getValue().size());

                    if (result == 0) {
                        result = f.getKey().getName().compareTo(s.getKey().getName());
                    }

                    return result;
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
