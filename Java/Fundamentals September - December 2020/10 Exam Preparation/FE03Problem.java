import java.util.*;

public class FE03Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lines = scanner.nextLine();

        Map<String, List<String>> guestLikedMeals = new HashMap<>();
        List<String> unLikedMeals = new ArrayList<>();

        while (!lines.equals("Stop")) {
            String[] tokens = lines.split("-");
            String command = tokens[0];
            String guest = tokens[1];
            String meal = tokens[2];

            switch (command) {
                case "Like":
                    if (guestLikedMeals.containsKey(guest)) {
                        if (!guestLikedMeals.get(guest).contains(meal)) {
                            guestLikedMeals.get(guest).add(meal);
                        }

                    } else {
                        List<String> likedMealsList = new ArrayList<>();
                        likedMealsList.add(meal);
                        guestLikedMeals.put(guest, likedMealsList);
                    }
                    break;

                case "Unlike":
                    if (guestLikedMeals.containsKey(guest)) {

                        if (guestLikedMeals.get(guest).contains(meal)) {
                            unLikedMeals.add(meal);
                            guestLikedMeals.get(guest).remove(meal);
                            System.out.printf("%s doesn't like the %s.%n", guest, meal);

                        } else {
                            System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, meal);
                        }

                    } else {
                        System.out.printf("%s is not at the party.%n", guest);
                    }

                    break;
            }

            lines = scanner.nextLine();
        }


        guestLikedMeals.entrySet().stream()
                .sorted((a, b) -> {
                    int aMealsCount = a.getValue().size();
                    int bMealsCount = b.getValue().size();

                    int result = bMealsCount - aMealsCount;

                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                })
                .forEach(e -> {
                    System.out.println(e.getKey() + ": " + e.getValue().toString().replaceAll("[\\[\\]]",""));
                });


        System.out.printf("Unliked meals: %d", unLikedMeals.size());
    }
}
