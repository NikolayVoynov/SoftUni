package core;

import models.Doodle;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DoodleSearchImpl implements DoodleSearch {
    private Map<String, Doodle> doodlesById;
    private Map<String, Doodle> doodlesByTitle;

    public DoodleSearchImpl() {
        this.doodlesById = new LinkedHashMap<>();
        this.doodlesByTitle = new LinkedHashMap<>();
    }

    @Override
    public void addDoodle(Doodle doodle) {
        this.doodlesById.put(doodle.getId(), doodle);
        this.doodlesByTitle.put(doodle.getTitle(), doodle);
    }

    @Override
    public void removeDoodle(String doodleId) {
        if (this.doodlesById.containsKey(doodleId)) {
            throw new IllegalArgumentException();
        }

        Doodle removedDoodle = this.doodlesById.remove(doodleId);
        this.doodlesByTitle.remove(removedDoodle.getTitle());
    }

    @Override
    public int size() {
        return this.doodlesById.size();
    }

    @Override
    public boolean contains(Doodle doodle) {
        return this.doodlesById.containsKey(doodle.getId());
    }

    @Override
    public Doodle getDoodle(String id) {
        Doodle doodle = this.doodlesById.get(id);

        if (doodle == null) {
            throw new IllegalArgumentException();
        }

        return doodle;
    }

    @Override
    public double getTotalRevenueFromDoodleAds() {
        double result = 0;

        List<Doodle> doodleList = this.doodlesById
                .values()
                .stream()
                .filter(Doodle::getIsAd)
                .collect(Collectors.toList());

        for (Doodle doodle : doodleList) {
            result += doodle.getRevenue() * doodle.getVisits();
        }

        return result;
    }

    @Override
    public void visitDoodle(String title) {
        Doodle doodle = this.doodlesByTitle.get(title);

        if (doodle == null) {
            throw new IllegalArgumentException();
        }

        int visits = doodle.getVisits();
        String id = doodle.getId();

        this.doodlesByTitle.get(title).setVisits(visits + 1);
        this.doodlesById.get(id).setVisits(visits + 1);
    }

    @Override
    public Iterable<Doodle> searchDoodles(String searchQuery) {
        return null;
    }

    @Override
    public Iterable<Doodle> getDoodleAds() {
        return this.doodlesById
                .values()
                .stream()
                .filter(doodle -> doodle.getIsAd())
                .sorted((d1, d2) -> {
                    if (d1.getRevenue() != d2.getRevenue()) {
                        return Double.compare(d2.getRevenue(), d1.getRevenue());
                    }

                    return Integer.compare(d2.getVisits(), d1.getVisits());
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Doodle> getTop3DoodlesByRevenueThenByVisits() {
        return this.doodlesById
                .values()
                .stream()
                .sorted((d1, d2) -> {
                    if (d1.getRevenue() != d2.getRevenue()) {
                        return Double.compare(d2.getRevenue(), d1.getRevenue());
                    }

                    return Integer.compare(d2.getVisits(), d1.getVisits());
                })
                .limit(3)
                .collect(Collectors.toList());
    }
}
