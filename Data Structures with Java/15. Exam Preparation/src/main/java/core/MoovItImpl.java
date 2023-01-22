package core;

import models.Route;

import java.util.HashMap;
import java.util.Map;

public class MoovItImpl implements MoovIt {
    private Map<String, Route> routesById;

    public MoovItImpl() {
        this.routesById = new HashMap<>();
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
        return null;
    }

    @Override
    public Iterable<Route> getFavoriteRoutes(String destinationPoint) {
        return null;
    }

    @Override
    public Iterable<Route> getTop5RoutesByPopularityThenByDistanceThenByCountOfLocationPoints() {
        return null;
    }
}
