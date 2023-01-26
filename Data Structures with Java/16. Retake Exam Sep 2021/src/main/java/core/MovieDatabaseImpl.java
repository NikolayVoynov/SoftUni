package core;

import models.Movie;

import java.util.*;
import java.util.stream.Collectors;

public class MovieDatabaseImpl implements MovieDatabase {
    private Map<String, Movie> moviesById;
    private Map<String, List<Movie>> actorAndHisMovies;

    public MovieDatabaseImpl() {
        this.moviesById = new LinkedHashMap<>();
        this.actorAndHisMovies = new HashMap<>();
    }

    @Override
    public void addMovie(Movie movie) {
        this.moviesById.put(movie.getId(), movie);

        for (String actor : movie.getActors()) {
            if (!this.actorAndHisMovies.containsKey(actor)) {
                this.actorAndHisMovies.put(actor, new ArrayList<>());
            }

            this.actorAndHisMovies.get(actor).add(movie);
        }
    }

    @Override
    public void removeMovie(String movieId) {
        if (!this.moviesById.containsKey(movieId)) {
            throw new IllegalArgumentException();
        }

        Movie movieRemoved = this.moviesById.remove(movieId);

        List<String> actors = movieRemoved.getActors();

        for (String actor : actors) {
            this.actorAndHisMovies.get(actor).remove(movieRemoved);

            if (this.actorAndHisMovies.get(actor).isEmpty()) {
                this.actorAndHisMovies.remove(actor);
            }
        }
    }

    @Override
    public int size() {
        return this.moviesById.size();
    }

    @Override
    public boolean contains(Movie movie) {
        return this.moviesById.containsKey(movie.getId());
    }

    @Override
    public Iterable<Movie> getMoviesByActor(String actorName) {
        List<Movie> moviesCollection = this.moviesById
                .values()
                .stream()
                .filter(m -> m.getActors().contains(actorName))
                .sorted((m1, m2) -> {
                    if (m1.getRating() != m2.getRating()) {
                        return Double.compare(m2.getRating(), m1.getRating());
                    }

                    return Integer.compare(m2.getReleaseYear(), m1.getReleaseYear());
                })
                .collect(Collectors.toList());

        if (moviesCollection.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return moviesCollection;
    }

    @Override
    public Iterable<Movie> getMoviesByActors(List<String> actors) {
        List<Movie> moviesCollection = this.moviesById
                .values()
                .stream()
                .filter(m -> m.getActors().containsAll(actors))
                .sorted((m1, m2) -> {
                    if (m1.getRating() != m2.getRating()) {
                        return Double.compare(m2.getRating(), m1.getRating());
                    }

                    return Integer.compare(m2.getReleaseYear(), m1.getReleaseYear());
                })
                .collect(Collectors.toList());

        if (moviesCollection.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return moviesCollection;
    }

    @Override
    public Iterable<Movie> getMoviesByYear(Integer releaseYear) {
        return this.moviesById
                .values()
                .stream()
                .filter(m -> m.getReleaseYear() == releaseYear)
                .sorted((m1, m2) -> Double.compare(m2.getRating(), m1.getRating()))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Movie> getMoviesInRatingRange(double lowerBound, double upperBound) {
        return this.moviesById
                .values()
                .stream()
                .filter(m -> m.getRating() >= lowerBound && m.getRating() <= upperBound)
                .sorted((m1, m2) -> Double.compare(m2.getRating(), m1.getRating()))
                .collect(Collectors.toList());

    }

    @Override
    public Iterable<Movie> getAllMoviesOrderedByActorPopularityThenByRatingThenByYear() {
        return this.moviesById
                .values()
                .stream()
                .sorted((m1, m2) -> {

                    List<String> actorsM1 = m1.getActors();
                    List<String> actorsM2 = m2.getActors();

                    int m1ActorsPopularity = 0;
                    int m2ActorsPopularity = 0;

                    for (String a : actorsM1) {
                        m1ActorsPopularity += this.actorAndHisMovies.get(a).size();
                    }

                    for (String a : actorsM2) {
                        m2ActorsPopularity += this.actorAndHisMovies.get(a).size();
                    }

                    if (m1ActorsPopularity != m2ActorsPopularity) {
                        return Integer.compare(m2ActorsPopularity, m1ActorsPopularity);
                    }

                    if (m1.getRating() != m2.getRating()) {
                        return Double.compare(m2.getRating(),m1.getRating());
                    }

                    return Integer.compare(m2.getReleaseYear(),m1.getReleaseYear());

                })
                .collect(Collectors.toList());
    }
}
