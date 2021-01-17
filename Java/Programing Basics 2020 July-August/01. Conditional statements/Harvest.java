import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = Integer.parseInt(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        int z = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());

        double harvestForWine = x * y * 0.4;
        double litreWineTotal = harvestForWine / 2.5;

        if (litreWineTotal < z) {
            double deficientWine = Math.floor(z - litreWineTotal);
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", deficientWine);
        } else if (litreWineTotal >= z){
            double moreWine = Math.ceil(litreWineTotal - z);
            double moreWinePerWorker = Math.ceil(moreWine / workers);
            litreWineTotal = Math.floor(harvestForWine / 2.5);
            System.out.printf("Good harvest this year! Total wine: %.0f liters.", litreWineTotal);
            System.out.println();
            System.out.printf("%.0f liters left -> %.0f liters per person.", moreWine, moreWinePerWorker);

        }
    }
}
