package core;

import models.Route;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MoovItImpl implements MoovIt {
    private Map<String, Route> routesById;

    public MoovItImpl() {
        this.routesById = new LinkedHashMap<>();
    }

    @Override
    public void addRoute(Route route) {
        if (contains(route)) {
            throw new IllegalArgumentException();
        }
        this.routesById.put(route.getId(), route);
    }

    @Override
    public void removeRoute(String routeId) {
        if (!this.routesById.containsKey(routeId)) {
            throw new IllegalArgumentException();
        }
        this.routesById.remove(routeId);
    }

    @Override
    public boolean contains(Route route) {
        return this.routesById.containsKey(route.getId());
    }

    @Override
    public int size() {
        return this.routesById.size();
    }

    @Override
    public Route getRoute(String routeId) {
        if (!this.routesById.containsKey(routeId)) {
            throw new IllegalArgumentException();
        }

        return this.routesById.get(routeId);
    }

    @Override
    public void chooseRoute(String routeId) {
        if (!this.routesById.containsKey(routeId)) {
            throw new IllegalArgumentException();
        }

        this.routesById.get(routeId).setPopularity(this.routesById.get(routeId).getPopularity() + 1);
    }

    @Override
    public Iterable<Route> searchRoutes(String startPoint, String endPoint) {
//        return this.routesById
//                .values()
//                .stream()
//                .filter(route -> route.getLocationPoints().contains(startPoint) & route.getLocationPoints().contains(endPoint))
//                .sorted();
        return null;
    }

    @Override
    public Iterable<Route> getFavoriteRoutes(String destinationPoint) {
        return this.routesById
                .values()
                .stream()
                .filter(r -> r.getIsFavorite()
                        && r.getLocationPoints().contains(destinationPoint)
                        && r.getLocationPoints().indexOf(destinationPoint) != 0)
                .sorted((f, s) -> {
                    if (f.getDistance() != s.getDistance()) {
                        return Double.compare(f.getDistance(), s.getDistance());
                    }

                    return Integer.compare(s.getPopularity(), f.getPopularity());
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Route> getTop5RoutesByPopularityThenByDistanceThenByCountOfLocationPoints() {
        return this.routesById
                .values()
                .stream()
                .sorted((f, s) -> {
                    if (f.getPopularity() != s.getPopularity()) {
                        return Integer.compare(s.getPopularity(), f.getPopularity());
                    }

                    if (f.getDistance() != s.getDistance()) {
                        return Double.compare(f.getDistance(), s.getDistance());
                    }

                    return Integer.compare(f.getLocationPoints().size(), s.getLocationPoints().size());
                })
                .collect(Collectors.toList());
    }
}
