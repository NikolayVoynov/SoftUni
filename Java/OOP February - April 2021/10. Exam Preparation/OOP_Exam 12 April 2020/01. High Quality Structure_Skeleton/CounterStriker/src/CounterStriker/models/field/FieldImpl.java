package CounterStriker.models.field;

import CounterStriker.common.OutputMessages;
import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class FieldImpl implements Field {
    private Collection<Player> terrorists;
    private Collection<Player> counterTerrorists;
    private Collection<Player> deadPlayers;

    public FieldImpl() {
        this.terrorists = new ArrayList<>();
        this.counterTerrorists = new ArrayList<>();
        this.deadPlayers = new ArrayList<>();
    }

    @Override
    public String start(Collection<Player> players) {
        for (Player player : players) {
            if (player.getClass().getSimpleName().equals("Terrorist")) {
                this.terrorists.add(player);
            } else if (player.getClass().getSimpleName().equals("CounterTerrorist")) {
                this.counterTerrorists.add(player);
            }
        }

        boolean terroristsAreAlive = true;
        boolean counterTerroristsAreAlive = true;

        while (terroristsAreAlive && counterTerroristsAreAlive) {
            for (Player player : players) {
                if (player.getClass().getSimpleName().equals("Terrorist") && player.isAlive()) {
                    for (Player player1 : players) {
                        if (player1.getClass().getSimpleName().equals("CounterTerrorist") && player1.isAlive()) {
                            int damagePoints = player.getGun().fire();
                            player1.takeDamage(damagePoints);
                        }
                    }
                }
            }

            this.counterTerrorists.removeIf(ctr -> !ctr.isAlive());
            if (this.counterTerrorists.size() == 0) {
                counterTerroristsAreAlive = false;
            }

            for (Player player : players) {
                if (player.getClass().getSimpleName().equals("CounterTerrorist") && player.isAlive()) {

                    for (Player player1 : players) {
                        if (player1.getClass().getSimpleName().equals("Terrorist") && player1.isAlive()) {
                            int damagePoints = player.getGun().fire();
                            player1.takeDamage(damagePoints);
                        }
                    }
                }
            }


            this.terrorists.removeIf(tr -> !tr.isAlive());
            if (this.terrorists.size() == 0) {
                terroristsAreAlive = false;
            }

        }

        String returnMessage = null;
        if (terrorists.size() == 0) {
            returnMessage = OutputMessages.COUNTER_TERRORIST_WINS;
        }

        if (counterTerrorists.size() == 0) {
            returnMessage = OutputMessages.TERRORIST_WINS;
        }

        return returnMessage;
    }
}
