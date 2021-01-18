import java.util.Scanner;

public class FoodForPets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double totalFood = Double.parseDouble(scanner.nextLine());

        double biscuits = 0;
        double totalBiscuits = 0;
        int totalEatenDog = 0;
        int totalEatenCat = 0;
        int totalEatenFood = 0;

        for (int i = 1; i <= days; i++) {
            int foodPerDayDog = Integer.parseInt(scanner.nextLine());
            int foodPerDayCat = Integer.parseInt(scanner.nextLine());

            int foodEatenPerDayDogCat = foodPerDayDog + foodPerDayCat;

            if (i % 3 == 0) {
                biscuits = 0.1 * foodEatenPerDayDogCat;
                totalBiscuits += biscuits;
            }

            totalEatenDog += foodPerDayDog;
            totalEatenCat += foodPerDayCat;

        }

        totalEatenFood += (totalEatenDog + totalEatenCat);

        double totalBiscuitsRound = Math.round(totalBiscuits);
        double percentEatenFood = totalEatenFood / totalFood * 100;
        double percentEatenDog = totalEatenDog * 1.0 / totalEatenFood * 100;
        double percentEatenCat = totalEatenCat * 1.0 / totalEatenFood * 100;

        System.out.printf("Total eaten biscuits: %.0fgr.%n", totalBiscuitsRound);
        System.out.printf("%.2f%% of the food has been eaten.%n", percentEatenFood);
        System.out.printf("%.2f%% eaten from the dog.%n", percentEatenDog);
        System.out.printf("%.2f%% eaten from the cat.", percentEatenCat);
    }
}
