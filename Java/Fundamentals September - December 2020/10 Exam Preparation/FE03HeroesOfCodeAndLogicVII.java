import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FE03HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, int[]> heroes = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] hero = scanner.nextLine().split("\\s+");
            String heroName = hero[0];
            int hp = Integer.parseInt(hero[1]);
            int mp = Integer.parseInt(hero[2]);

            int[] points = new int[]{hp, mp};
            heroes.put(heroName, points);
        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commands = input.split(" - ");
            String command = commands[0];
            String heroName = commands[1];

            switch (command) {
                case "CastSpell":
                    int neededMP = Integer.parseInt(commands[2]);
                    String spellName = commands[3];

                    if (heroes.get(heroName)[1] >= neededMP) {
                        heroes.get(heroName)[1] -= neededMP;
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n"
                                , heroName, spellName, heroes.get(heroName)[1]);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;

                case "TakeDamage":
                    int damage = Integer.parseInt(commands[2]);
                    String attacker = commands[3];

                    heroes.get(heroName)[0] -= damage;

                    if (heroes.get(heroName)[0] > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n"
                                , heroName, damage, attacker, heroes.get(heroName)[0]);
                    } else {
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                        heroes.remove(heroName);
                    }

                    break;

                case "Recharge":
                    int recharge = Integer.parseInt(commands[2]);
                    int currentR = heroes.get(heroName)[1];
                    heroes.get(heroName)[1] += recharge;

                    if (heroes.get(heroName)[1] > 200) {
                        recharge = 200 - currentR;
                        heroes.get(heroName)[1] = 200;
                    }
                    System.out.printf("%s recharged for %d MP!%n", heroName, recharge);
                    break;

                case "Heal":
                    int healed = Integer.parseInt(commands[2]);
                    int currentH = heroes.get(heroName)[0];
                    heroes.get(heroName)[0] += healed;

                    if (heroes.get(heroName)[0] > 100) {
                        healed = 100 - currentH;
                        heroes.get(heroName)[0] = 100;
                    }
                    System.out.printf("%s healed for %d HP!%n", heroName, healed);
                    break;
            }
            input = scanner.nextLine();
        }

        heroes.entrySet().stream()
                .sorted((a,b) -> {
                    int result = b.getValue()[0] - a.getValue()[0];
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }

                    return result;
                }).forEach(h -> {

            System.out.println(h.getKey());
            System.out.println("  HP: " + h.getValue()[0]);
            System.out.println("  MP: " + h.getValue()[1]);

        });

    }
}
