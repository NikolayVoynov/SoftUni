import java.util.Scanner;

public class MEP02MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int bitcoins = 0;

        String[] dungeonsRooms = scanner.nextLine().split("\\|");

        for (int i = 0; i < dungeonsRooms.length; i++) {
            String[] currentRoom = dungeonsRooms[i].split("\\s+");
            String command = currentRoom[0];
            int number = Integer.parseInt(currentRoom[1]);

            switch (command) {
                case "potion":
                    if (health < 100) {
                        health += number;
                        if (health <= 100) {
                            System.out.printf("You healed for %d hp.%n", number);
                            System.out.printf("Current health: %d hp.%n", health);
                        } else {
                            int overHealth = health - 100;
                            health -= overHealth;
                            int healedFor = number - overHealth;
                            System.out.printf("You healed for %d hp.%n", healedFor);
                            System.out.printf("Current health: %d hp.%n", health);
                        }

                    }
                    break;
                case "chest":
                    bitcoins += number;
                    System.out.printf("You found %d bitcoins.%n", number);
                    break;
                default:
                    String monster = currentRoom[0];
                    int monsterAttack = Integer.parseInt(currentRoom[1]);
                    health -= monsterAttack;

                    if (health > 0) {
                        System.out.printf("You slayed %s.%n", monster);
                    } else {
                        int bestRoom = i + 1;
                        System.out.printf("You died! Killed by %s.%n", monster);
                        System.out.printf("Best room: %d", bestRoom);
                        return;
                    }
                    break;
            }
        }

        System.out.println("You've made it!");
        System.out.printf("Bitcoins: %d%n", bitcoins);
        System.out.printf("Health: %d", health);
    }
}
