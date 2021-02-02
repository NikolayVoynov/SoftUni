import java.util.*;

public class FE03PlantDiscovery2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> plantRarity = new HashMap<>();
        Map<String, List<Double>> plantRating = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("<->");
            String namePlant = line[0];
            int rarity = Integer.parseInt(line[1]);

            if (!plantRarity.containsKey(namePlant)) {
                plantRarity.put(namePlant, rarity);
                plantRating.put(namePlant, new ArrayList<>());
            } else {
                plantRarity.remove(namePlant);
                plantRarity.put(namePlant, rarity);
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("Exhibition")) {
            String[] tokens = input.split(":\\s+");
            String command = tokens[0];
            String infoPlant = tokens[1];

            String[] newTokens = infoPlant.split(" - ");
            String name = newTokens[0];

            switch (command) {
                case "Rate":
                    if (plantRating.containsKey(name)) {
                        double rating = Double.parseDouble(newTokens[1]);
                        List<Double> ratings = plantRating.get(name);
                        ratings.add(rating);
                    } else {
                        System.out.println("error");
                    }
                    break;

                case "Update":
                    if (plantRarity.containsKey(name)) {
                        int rarity = Integer.parseInt(newTokens[1]);
                        plantRarity.put(name, rarity);
                    } else {
                        System.out.println("error");
                    }
                    break;

                case "Reset":
                    if (plantRating.containsKey(name)) {
                        List<Double> resetRatings = plantRating.get(name);
                        resetRatings.clear();
                    } else {
                        System.out.println("error");
                    }
                    break;

                default:
                    System.out.println("error");
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");

        plantRarity.entrySet().stream().sorted((a, b) -> {
            int aRarity = a.getValue();
            int bRarity = b.getValue();

            if (aRarity != bRarity) {
                return Integer.compare(bRarity,aRarity);
            } else {
                List<Double> aRatingsList = plantRating.get(a.getKey());
                List<Double> bRatingsList = plantRating.get(b.getKey());

                double aAverageRating = calculateAverage(aRatingsList);
                double bAverageRating = calculateAverage(bRatingsList);

                return Double.compare(bAverageRating,aAverageRating);
            }
        }).map(entry -> "- " + entry.getKey()+ "; Rarity: " + entry.getValue() + "; Rating: "
                + String.format("%.2f", calculateAverage(plantRating.get(entry.getKey()))))
                .forEach(e-> System.out.println(e));

    }

    public static double calculateAverage(List<Double> numbersRatings) {

        if (numbersRatings.size() == 0) {
            return 0;
        } else {
            double sum = 0;

            for (Double numbersRating : numbersRatings) {
                sum += numbersRating;
            }

            double averageSum = sum / numbersRatings.size();
            return  averageSum;
        }
    }
}
