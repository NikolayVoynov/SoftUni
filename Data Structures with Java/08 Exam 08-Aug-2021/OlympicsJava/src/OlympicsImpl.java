import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OlympicsImpl implements Olympics {
    private Map<Integer, Competitor> competitorsMap;
    private Map<Integer, Competition> competitionsMap;

    public OlympicsImpl() {
        this.competitorsMap = new HashMap<>();
        this.competitionsMap = new HashMap<>();
    }

    @Override
    public void addCompetitor(int id, String name) {
        if (this.competitorsMap.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        Competitor newCompetitor = new Competitor(id, name);
        this.competitorsMap.put(id, newCompetitor);
    }

    @Override
    public void addCompetition(int id, String name, int score) {
        if (this.competitionsMap.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        Competition newCompetition = new Competition(name, id, score);
        this.competitionsMap.put(id, newCompetition);
    }

    @Override
    public void compete(int competitorId, int competitionId) {
        if (!this.competitorsMap.containsKey(competitorId) || !this.competitionsMap.containsKey(competitionId)) {
            throw new IllegalArgumentException();
        }

        int addScore = this.competitionsMap.get(competitionId).getScore();

        Competitor competitor = this.competitorsMap.get(competitorId);
        long currentCompetitorScore = competitor.getTotalScore();
        competitor.setTotalScore(currentCompetitorScore + addScore);

        this.competitionsMap.get(competitionId).getCompetitors().add(competitor);
    }

    @Override
    public void disqualify(int competitionId, int competitorId) {
        if (!this.competitorsMap.containsKey(competitorId) || !this.competitionsMap.containsKey(competitionId)) {
            throw new IllegalArgumentException();
        }

        Competitor competitor = this.competitorsMap.get(competitorId);
        Competition competition = this.competitionsMap.get(competitionId);
        boolean containsCompetitor = competition.getCompetitors().contains(competitor);

        if (!containsCompetitor) {
            throw new IllegalArgumentException();
        } else {
            long totalScore = competitor.getTotalScore();
            competitor.setTotalScore(totalScore - competition.getScore());
            competition.getCompetitors().remove(competitor);
        }
    }

    @Override
    public Iterable<Competitor> findCompetitorsInRange(long min, long max) {
        return this.competitorsMap
                .values()
                .stream()
                .filter(c -> c.getTotalScore() > min && c.getTotalScore() <= max)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Competitor> getByName(String name) {
        List<Competitor> collection = this.competitorsMap
                .values()
                .stream()
                .filter(c -> c.getName().equals(name))
                .sorted(Comparator.comparingInt(Competitor::getId))
                .collect(Collectors.toList());

        if (collection.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return collection;
    }

    @Override
    public Iterable<Competitor> searchWithNameLength(int minLength, int maxLength) {

        return this.competitorsMap
                .values()
                .stream()
                .filter(c -> c.getName().length() >= minLength && c.getName().length() <= maxLength)
                .sorted((c1,c2)-> Integer.compare(c1.getId(), c2.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean contains(int competitionId, Competitor comp) {
        if (!this.competitionsMap.containsKey(competitionId)) {
            throw new IllegalArgumentException();
        }
        return this.competitionsMap.get(competitionId).getCompetitors().contains(comp);
    }

    @Override
    public int competitionsCount() {
        return this.competitionsMap.size();
    }

    @Override
    public int competitorsCount() {
        return this.competitorsMap.size();
    }

    @Override
    public Competition getCompetition(int id) {
        Competition competition = this.competitionsMap.get(id);
        if (competition == null) {
            throw new IllegalArgumentException();
        }

        return competition;
    }
}
