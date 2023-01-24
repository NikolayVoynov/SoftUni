package core;

import models.Route;

import java.util.*;
import java.util.stream.Collectors;

public class MoovItImpl implements MoovIt {
    private Map<String, Route> routesById;
    private Set<Route> routeSet;

    public MoovItImpl() {
        this.routesById = new LinkedHashMap<>();
        this.routeSet = new HashSet<>();
    }

    @Override
    public void addRoute(Route route) {
        if (contains(route)) {
            throw new IllegalArgumentException();
        }
        this.routesById.put(route.getId(), route);
        this.routeSet.add(route);
    }

    @Override
    public void removeRoute(String routeId) {
        if (!this.routesById.containsKey(routeId)) {
            throw new IllegalArgumentException();
        }
        Route removedRoute = this.routesById.remove(routeId);
        this.routeSet.remove(removedRoute);
    }

    @Override
    public boolean contains(Route route) {
        return this.routeSet.contains(route);
    }

    @Override
    public int size() {
        return this.routesById.size();
    }

    @Override
    public Route getRoute(String routeId) {
        Route route = this.routesById.get(routeId);

        if (route == null) {
            throw new IllegalArgumentException();
        }

        return route;
    }

    @Override
    public void chooseRoute(String routeId) {
        Route route = this.routesById.get(routeId);

        if (route == null) {
            throw new IllegalArgumentException();
        }

        Integer popularity = route.getPopularity();
        route.setPopularity(popularity + 1);
    }

    @Override
    public Iterable<Route> searchRoutes(String startPoint, String endPoint) {
        return this.routesById
                .values()
                .stream()
                .filter(route -> {
                    List<String> locationPoints = route.getLocationPoints();

                    int startIndex = locationPoints.indexOf(startPoint);
                    int endIndex = locationPoints.indexOf(endPoint);

                    return startIndex > -1 && endIndex > -1 && startIndex < endIndex;
                })
                .sorted((f, s) -> {
                    if (f.getIsFavorite() && !s.getIsFavorite()) {
                        return -1;
                    }

                    if (s.getIsFavorite() && !f.getIsFavorite()) {
                        return 1;
                    }

                    int fDistance = f.getLocationPoints().indexOf(endPoint) - f.getLocationPoints().indexOf(startPoint);
                    int sDistance = s.getLocationPoints().indexOf(endPoint) - s.getLocationPoints().indexOf(startPoint);

                    if (fDistance != sDistance) {
                        return Double.compare(fDistance, sDistance);
                    }

                    return Integer.compare(s.getPopularity(), f.getPopularity());
                })
                .collect(Collectors.toList());

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
                    if (!f.getDistance().equals(s.getDistance())) {
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
                    if (!f.getPopularity().equals(s.getPopularity())) {
                        return Integer.compare(s.getPopularity(), f.getPopularity());
                    }

                    if (!f.getDistance().equals(s.getDistance())) {
                        return Double.compare(f.getDistance(), s.getDistance());
                    }

                    return Integer.compare(f.getLocationPoints().size(), s.getLocationPoints().size());
                })
                .limit(5)
                .collect(Collectors.toList());
    }
}
