package tripadministratorjava;

import java.util.*;
import java.util.stream.Collectors;

public class TripAdministratorImpl implements TripAdministrator {
    private Map<String, Company> companiesByNames;
    private Map<String, Trip> tripsById;
    private Map<String, List<Trip>> companiesWithTrips;

    public TripAdministratorImpl() {
        this.companiesByNames = new LinkedHashMap<>();
        this.tripsById = new LinkedHashMap<>();
        this.companiesWithTrips = new LinkedHashMap<>();
    }

    @Override
    public void addCompany(Company c) {
        if (exist(c)) {
            throw new IllegalArgumentException();
        }
        this.companiesWithTrips.put(c.name, new ArrayList<>());
        this.companiesByNames.put(c.name, c);
    }

    @Override
    public void addTrip(Company c, Trip t) {
        if (!exist(c) || exist(t)) {
            throw new IllegalArgumentException();
        }

        tripsById.put(t.id, t);

        if (c.tripOrganizationLimit == companiesWithTrips.get(c.name).size()) {
            throw new IllegalArgumentException();
        }

        companiesWithTrips.get(c.name).add(t);
    }

    @Override
    public boolean exist(Company c) {
        return this.companiesByNames.containsKey(c.name);
    }

    @Override
    public boolean exist(Trip t) {
        return this.tripsById.containsKey(t.id);
    }

    @Override
    public void removeCompany(Company c) {
        if (!exist(c)) {
            throw new IllegalArgumentException();
        }

        companiesByNames.remove(c.name);
        List<Trip> tripsOfRemovedCompany = companiesWithTrips.remove(c.name);
        tripsOfRemovedCompany.forEach(t -> tripsById.remove(t.id));
    }

    @Override
    public Collection<Company> getCompanies() {
        return this.companiesByNames.values();
    }

    @Override
    public Collection<Trip> getTrips() {
        return this.tripsById.values();
    }

    @Override
    public void executeTrip(Company c, Trip t) {
        if (!exist(c) || !exist(t)) {
            throw new IllegalArgumentException();
        }

        List<Trip> companyTrips = companiesWithTrips.get(c.name);
        boolean removed = companyTrips.removeIf(tr -> tr.id.equals(t.id));

        if (!removed) {
            throw new IllegalArgumentException();
        }

        tripsById.remove(t.id);
    }

    @Override
    public Collection<Company> getCompaniesWithMoreThatNTrips(int n) {
        return this.getCompanies()
                .stream()
                .filter(c -> companiesWithTrips.get(c.name).size() > n)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Trip> getTripsWithTransportationType(Transportation t) {
        return this.getTrips()
                .stream()
                .filter(tr -> tr.transportation == t)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Trip> getAllTripsInPriceRange(int lo, int hi) {
        return this.getTrips()
                .stream()
                .filter(t -> t.price >= lo && t.price <= hi)
                .collect(Collectors.toList());
    }


}
