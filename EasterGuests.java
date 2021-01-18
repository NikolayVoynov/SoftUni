import java.util.Scanner;

public class EasterGuests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guests = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        int countEggs = guests * 2;
        double priceEggs = countEggs * 0.45;

        double countCakes = Math.ceil(guests * 1.0 / 3);
        double priceCakes = countCakes * 4;

        double totalPrice = priceEggs + priceCakes;

        if (budget >= totalPrice) {
            System.out.printf("Lyubo bought %.0f Easter bread and %d eggs.%n", countCakes, countEggs);
            System.out.printf("He has %.2f lv. left.", Math.abs(budget - totalPrice));
        } else {
            System.out.printf("Lyubo doesn't have enough money.%n");
            System.out.printf("He needs %.2f lv. more.", Math.abs(budget - totalPrice));
        }
    }
}

