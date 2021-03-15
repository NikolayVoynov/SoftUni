package P04FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        this.name = name;
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

    private void setName() {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Person player) {
        if (player.getAge() < 40) {
            this.firstTeam.add(player);
        } else {
            this.reserveTeam.add(player);
        }
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(firstTeam);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(reserveTeam);
    }


}
