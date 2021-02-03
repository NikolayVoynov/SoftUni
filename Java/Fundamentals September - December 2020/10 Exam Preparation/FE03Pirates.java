import java.util.*;

public class FE03Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputCities = scanner.nextLine();

        Map<String, int[]> citiesInfo = new HashMap<>();

        while (!inputCities.equals("Sail")) {
            String[] tokens = inputCities.split("\\|\\|");
            String city = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);

            if (citiesInfo.containsKey(city)) {
                citiesInfo.get(city)[0] += population;
                citiesInfo.get(city)[1] += gold;
            } else {
                int[] citiesPopulationGold = new int[]{population, gold};
                citiesInfo.put(city, citiesPopulationGold);
            }

            inputCities = scanner.nextLine();
        }

        String events = scanner.nextLine();

        while (!events.equals("End")) {
            String[] tokens = events.split("=>");
            String event = tokens[0];
            String town = tokens[1];


            switch (event) {
                case "Plunder":
                    int people = Integer.parseInt(tokens[2]);
                    int goldPlunder = Integer.parseInt(tokens[3]);

                    citiesInfo.get(town)[0] -= people;
                    citiesInfo.get(town)[1] -= goldPlunder;

                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n"
                            , town, goldPlunder, people);

                    if (citiesInfo.get(town)[0] == 0 || citiesInfo.get(town)[1] == 0) {
                        System.out.println(town + " has been wiped off the map!");
                        citiesInfo.remove(town);
                    }
                    break;

                case "Prosper":
                    int goldProsper = Integer.parseInt(tokens[2]);

                    if (goldProsper < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        citiesInfo.get(town)[1] += goldProsper;
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n"
                                , goldProsper, town, citiesInfo.get(town)[1]);
                    }

                    break;
            }

            events = scanner.nextLine();
        }

        if (citiesInfo.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");

        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n"
                    , citiesInfo.size());
        }

        citiesInfo.entrySet().stream()
                .sorted((a, b) -> {
                    int result = b.getValue()[1] - a.getValue()[1];
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }

                    return  result;
                })
                .forEach(e -> {
                    System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n"
                            , e.getKey(), e.getValue()[0], e.getValue()[1]);
                });

    }
}
