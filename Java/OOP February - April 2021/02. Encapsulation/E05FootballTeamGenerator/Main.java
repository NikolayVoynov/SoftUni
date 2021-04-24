package E05FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Team> listOfTeams = new ArrayList<>();

        String input = "";


        while (!"END".equals(input = scanner.nextLine())) {

            try {
                String[] token = input.split(";");
                String command = token[0];
                Team team = null;

                switch (command) {
                    case "Team":
                        team = new Team(token[1]);
                        listOfTeams.add(team);
                        break;

                    case "Add":
                        team = listOfTeams
                                .stream()
                                .filter(t -> t.getName().equals(token[1])).findFirst()
                                .orElse(null);

                        if (team == null) {
                            throw new IllegalArgumentException(String.format("Team %s does not exist.", token[1]));
                        }

                        team.addPlayer(new Player(token[2], Integer.parseInt(token[3])
                                , Integer.parseInt(token[4]), Integer.parseInt(token[5])
                                , Integer.parseInt(token[6]), Integer.parseInt(token[7])));
                        break;

                    case "Remove":
                        team = listOfTeams
                                .stream()
                                .filter(t -> t.getName().equals(token[1])).findFirst()
                                .orElse(null);

                        assert team != null;
                        team.removePlayer(token[2]);
                        break;

                    case "Rating":
                        team = listOfTeams
                                .stream()
                                .filter(t -> t.getName().equals(token[1])).findFirst()
                                .orElse(null);

                        if (team == null) {
                            throw new IllegalArgumentException(String.format("Team %s does not exist.", token[1]));
                        }

                        System.out.println(String.format("%s - %d",token[1], Math.round(team.getRating())));
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }
}
