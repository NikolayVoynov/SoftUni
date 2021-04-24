package E05FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String teamName) {
        if (teamName == null || teamName.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = teamName;
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player) {
        if (this.name == null) {

        }
        this.players.add(player);
    }

    public void removePlayer(String playerName) {
        Player player = this.players.stream().filter(p -> p.getName().equals(playerName)).findFirst().orElse(null);

        if (player == null) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, this.name));
        } else {
            this.players.remove(player);
        }
    }

    public double getRating() {
        double sumOfRatings = 0;
        for (Player player : players) {
            sumOfRatings += player.overallSkillLevel();
        }

        return sumOfRatings / this.players.size();
    }

}
