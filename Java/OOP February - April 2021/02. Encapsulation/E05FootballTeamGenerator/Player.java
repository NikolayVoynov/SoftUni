package E05FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    private void setName(String playerName) {
        if (playerName == null || playerName.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = playerName;
    }

    private void setEndurance(int endurance) {
        if (endurance < 0 || 100 < endurance) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", "Endurance"));
        }
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        if (sprint < 0 || 100 < sprint) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", "Sprint"));
        }
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        if (dribble < 0 || 100 < dribble) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", "Dribble"));
        }
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        if (passing < 0 || 100 < passing) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", "Passing"));
        }
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        if (shooting < 0 || 100 < shooting) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", "Shooting"));
        }
        this.shooting = shooting;
    }

    public String getName() {
        return this.name;
    }

    public int getEndurance() {
        return this.endurance;
    }

    public int getSprint() {
        return this.sprint;
    }

    public int getDribble() {
        return this.dribble;
    }

    public int getPassing() {
        return this.passing;
    }

    public int getShooting() {
        return this.shooting;
    }

    public double overallSkillLevel() {
        return 1.0 * (this.getEndurance() + this.getSprint()
                + this.getDribble() + this.getPassing()
                + this.getShooting()) / 5;
    }
}
