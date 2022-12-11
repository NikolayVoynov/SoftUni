package org.softuni.exam.structures;

import org.softuni.exam.entities.Airline;
import org.softuni.exam.entities.Flight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AirlinesManagerImpl implements AirlinesManager {

    private Map<Airline, List<Flight>> airlineFlightsMap;
    private List<Flight> flightList;

    public AirlinesManagerImpl() {
        this.airlineFlightsMap = new HashMap<>();
        this.flightList = new ArrayList<>();
    }

    @Override
    public void addAirline(Airline airline) {
        this.airlineFlightsMap.put(airline, new ArrayList<>());
    }

    @Override
    public void addFlight(Airline airline, Flight flight) {
        if (!contains(airline)) {
            throw new IllegalStateException();
        }

        this.airlineFlightsMap.get(airline).add(flight);
        this.flightList.add(flight);
    }

    @Override
    public boolean contains(Airline airline) {
        return this.airlineFlightsMap.containsKey(airline);
    }

    @Override
    public boolean contains(Flight flight) {
        return this.flightList.contains(flight);
    }

    @Override
    public void deleteAirline(Airline airline) throws IllegalArgumentException {
        if (!contains(airline)) {
            throw new IllegalArgumentException();
        }

        List<Flight> flightsOfAirline = this.airlineFlightsMap.get(airline);
        this.airlineFlightsMap.remove(airline);

        this.flightList.removeIf(flightsOfAirline::contains);
    }

    @Override
    public Iterable<Flight> getAllFlights() {
        return this.flightList;
    }

    @Override
    public Flight performFlight(Airline airline, Flight flight) throws IllegalArgumentException {
        if (!contains(airline) || !contains(flight)) {
            throw new IllegalArgumentException();
        }

        int indexOfFlight = this.flightList.indexOf(flight);

        Flight currentFlight = this.flightList.get(indexOfFlight);
        currentFlight.setCompleted(true);

        return currentFlight;
    }

    @Override
    public Iterable<Flight> getCompletedFlights() {
        return this.flightList.stream().filter(f -> f.isCompleted()).collect(Collectors.toList());
    }

    @Override
    public Iterable<Flight> getFlightsOrderedByNumberThenByCompletion() {
        return this.flightList
                .stream()
                .sorted((f, s) -> {
                    int result = Boolean.compare(f.isCompleted(), s.isCompleted());

                    if (result == 0) {
                        result = f.getNumber().compareTo(s.getNumber());
                    }

                    return result;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Airline> getAirlinesOrderedByRatingThenByCountOfFlightsThenByName() {
        return this.airlineFlightsMap
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int result = Double.compare(e2.getKey().getRating(), e1.getKey().getRating());

                    if (result == 0) {
                        result = Integer.compare(e2.getValue().size(), e1.getValue().size());

                        if (result == 0) {
                            result = e1.getKey().getName().compareTo(e2.getKey().getName());
                        }
                    }

                    return result;
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Airline> getAirlinesWithFlightsFromOriginToDestination(String origin, String destination) {
        List<Flight> flightsNotCompletedWithCorrectOriginDestination =
                this.flightList
                        .stream()
                        .filter(f -> f.isCompleted() == false &&
                                f.getOrigin().equals(origin) &&
                                f.getDestination().equals(destination))
                        .collect(Collectors.toList());


        List<Airline> returnThisListOfAirlines = new ArrayList<>();

        for (Flight flightLookingFor : flightsNotCompletedWithCorrectOriginDestination) {

            for (Map.Entry<Airline, List<Flight>> entry : this.airlineFlightsMap.entrySet()) {
                if (entry.getValue().contains(flightLookingFor)) {
                    if (!returnThisListOfAirlines.contains(entry.getKey())) {
                        returnThisListOfAirlines.add(entry.getKey());
                    }
                }
            }
        }

        return returnThisListOfAirlines;
    }

}


