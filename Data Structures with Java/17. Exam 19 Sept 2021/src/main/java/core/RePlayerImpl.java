package core;

import models.Track;

import java.util.*;
import java.util.stream.Collectors;

public class RePlayerImpl implements RePlayer {
    private Map<String, List<Track>> albumWithTrackList;
    private List<Track> allTracks;
    private Queue<Track> listeningQueue;

    public RePlayerImpl() {
        this.albumWithTrackList = new TreeMap<>();
        this.allTracks = new ArrayList<>();
        this.listeningQueue = new ArrayDeque<>();
    }

    @Override
    public void addTrack(Track track, String album) {
        if (!this.albumWithTrackList.containsKey(album)) {
            this.albumWithTrackList.put(album, new ArrayList<>());
        }

        if (!this.albumWithTrackList.get(album).contains(track)) {
            this.albumWithTrackList.get(album).add(track);
            this.allTracks.add(track);
        }
    }

    @Override
    public void removeTrack(String trackTitle, String albumName) {
        boolean albumExist = this.albumWithTrackList.containsKey(albumName);

        if (!albumExist) {
            throw new IllegalArgumentException();
        }

        List<Track> tracks = this.albumWithTrackList.get(albumName);
        Track track = null;

        for (Track tr : tracks) {
            if (tr.getTitle().equals(trackTitle)) {
                track = tr;
            }
        }

        if (track == null) {
            throw new IllegalArgumentException();
        }

        this.albumWithTrackList.get(albumName).remove(track);
        this.allTracks.remove(track);
        this.listeningQueue.remove(track);


    }

    @Override
    public boolean contains(Track track) {
        return this.allTracks.contains(track);
    }

    @Override
    public int size() {
        return this.allTracks.size();
    }

    @Override
    public Track getTrack(String title, String albumName) {
        boolean albumExist = this.albumWithTrackList.containsKey(albumName);

        if (!albumExist) {
            throw new IllegalArgumentException();
        }

        List<Track> tracks = this.albumWithTrackList.get(albumName);
        Track track = null;

        for (Track tr : tracks) {
            if (tr.getTitle().equals(title)) {
                track = tr;
            }
        }

        if (track == null) {
            throw new IllegalArgumentException();
        }

        return track;
    }

    @Override
    public Iterable<Track> getAlbum(String albumName) {
        if (!this.albumWithTrackList.containsKey(albumName)) {
            throw new IllegalArgumentException();
        }

        return this.albumWithTrackList
                .get(albumName)
                .stream()
                .sorted((tr1, tr2) -> Integer.compare(tr2.getPlays(), tr1.getPlays()))
                .collect(Collectors.toList());
    }

    @Override
    public void addToQueue(String trackName, String albumName) {
        boolean albumExist = this.albumWithTrackList.containsKey(albumName);

        if (!albumExist) {
            throw new IllegalArgumentException();
        }

        List<Track> tracks = this.albumWithTrackList.get(albumName);
        Track track = null;

        for (Track tr : tracks) {
            if (tr.getTitle().equals(trackName)) {
                track = tr;
            }
        }

        if (track == null) {
            throw new IllegalArgumentException();
        }

        this.listeningQueue.add(track);
    }

    @Override
    public Track play() {
        Track track = this.listeningQueue.poll();

        if (track == null) {
            throw new IllegalArgumentException();
        }

        int plays = track.getPlays();
        track.setPlays(plays + 1);

        return track;
    }

    @Override
    public Iterable<Track> getTracksInDurationRangeOrderedByDurationThenByPlaysDescending(int lowerBound, int upperBound) {
        return this.allTracks
                .stream()
                .filter(track -> track.getDurationInSeconds() >= lowerBound && track.getDurationInSeconds() <= upperBound)
                .sorted((tr1, tr2) -> {
                    if (tr1.getDurationInSeconds() != tr2.getDurationInSeconds()) {
                        return Integer.compare(tr1.getDurationInSeconds(), tr2.getDurationInSeconds());
                    }

                    return Integer.compare(tr2.getPlays(), tr1.getPlays());
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Track> getTracksOrderedByAlbumNameThenByPlaysDescendingThenByDurationDescending() {
        Collection<List<Track>> values = this.albumWithTrackList.values();
        List<Track> allTracksSorted = new ArrayList<>();

        for (List<Track> list : values) {
            allTracksSorted.addAll(list);
        }

        return allTracksSorted
                .stream()
                .sorted((tr1, tr2) -> {
                    if (tr1.getPlays() != tr2.getPlays()) {
                        return Integer.compare(tr2.getPlays(), tr1.getPlays());
                    }

                    return Integer.compare(tr2.getDurationInSeconds(),tr1.getDurationInSeconds());
                })
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Track>> getDiscography(String artistName) {
        Map<String, List<Track>> resultMap = new HashMap<>();

        for (Map.Entry<String, List<Track>> entry : albumWithTrackList.entrySet()) {
            String album = entry.getKey();
            for (Track track : entry.getValue()) {
                if (track.getArtist().equals(artistName)) {
                    if (!resultMap.containsKey(album)) {
                        resultMap.put(album, new ArrayList<>());
                    }
                    resultMap.get(album).add(track);
                }
            }
        }

        if (resultMap.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return resultMap;
    }
}
