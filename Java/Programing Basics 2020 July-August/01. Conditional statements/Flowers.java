import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chrysanthemums = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int tulips = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String holiday = scanner.nextLine();

        double flowersPriceTotal = 0;
        int numberFlowers = chrysanthemums + roses + tulips;
        double flowersPriceSpringSummer = chrysanthemums * 2.00 + roses * 4.10 + tulips * 2.50;
        double flowersPriceAutumnWinter = chrysanthemums * 3.75 + roses * 4.50 + tulips * 4.15;

        switch (holiday) {
            case "Y":
                switch (season) {
                    case "Spring":
                        if (numberFlowers >= 20 && tulips >= 7) {
                            flowersPriceTotal = flowersPriceSpringSummer * 1.15 * (1 - 0.05) * (1 - 0.20) + 2;
                        } else if (numberFlowers >= 20) {
                            flowersPriceTotal = flowersPriceSpringSummer * 1.15 * (1 - 0.20) + 2;
                        } else if (tulips >= 7) {
                            flowersPriceTotal = flowersPriceSpringSummer * 1.15 * (1 - 0.05) + 2;
                        } else {
                            flowersPriceTotal = flowersPriceSpringSummer * 1.15 + 2;
                        }
                        break;
                    case "Summer":
                        if (numberFlowers >= 20) {
                            flowersPriceTotal = flowersPriceSpringSummer * 1.15 * (1 - 0.20) + 2;
                        } else {
                            flowersPriceTotal = flowersPriceSpringSummer * 1.15 + 2;
                        }
                        break;
                    case "Autumn":
                        if (numberFlowers >= 20) {
                            flowersPriceTotal = flowersPriceAutumnWinter * 1.15 * (1 - 0.20) + 2;
                        } else {
                            flowersPriceTotal = flowersPriceAutumnWinter * 1.15 + 2;
                        }
                        break;
                    case "Winter":
                        if (numberFlowers >= 20 && roses >= 10) {
                            flowersPriceTotal = flowersPriceAutumnWinter * 1.15 * (1 - 0.1) * (1 - 0.20) + 2;
                        } else  if (numberFlowers >= 20) {
                            flowersPriceTotal = flowersPriceAutumnWinter * 1.15 * (1 - 0.20) + 2;
                        } else if (roses >= 10) {
                            flowersPriceTotal = flowersPriceAutumnWinter * 1.15 * (1 - 0.1) + 2;
                        } else {
                            flowersPriceTotal = flowersPriceAutumnWinter * 1.15 + 2;
                        }
                        break;
                }
                break;
            case "N":
                switch (season) {
                    case "Spring":
                        if (numberFlowers >= 20 && tulips >= 7) {
                            flowersPriceTotal = flowersPriceSpringSummer * (1 - 0.05) * (1 - 0.20) + 2;
                        } else if (numberFlowers >= 20) {
                            flowersPriceTotal = flowersPriceSpringSummer * (1 - 0.20) + 2;
                        } else if (tulips >= 7) {
                            flowersPriceTotal = flowersPriceSpringSummer * (1 - 0.05) + 2;
                        } else {
                            flowersPriceTotal = flowersPriceSpringSummer + 2;
                        }
                        break;
                    case "Summer":
                        if (numberFlowers >= 20) {
                            flowersPriceTotal = flowersPriceSpringSummer * (1 - 0.20) + 2;
                        } else {
                            flowersPriceTotal = flowersPriceSpringSummer + 2;
                        }
                        break;
                    case "Autumn":
                        if (numberFlowers >= 20) {
                            flowersPriceTotal = flowersPriceAutumnWinter * (1 - 0.20) + 2;
                        } else {
                            flowersPriceTotal = flowersPriceAutumnWinter + 2;
                        }
                        break;
                    case "Winter":
                        if (numberFlowers >= 20 && roses >= 10) {
                            flowersPriceTotal = flowersPriceAutumnWinter * (1 - 0.1) * (1 - 0.20) + 2;
                        } else  if (numberFlowers >= 20) {
                            flowersPriceTotal = flowersPriceAutumnWinter * (1 - 0.20) + 2;
                        } else if (roses >= 10) {
                            flowersPriceTotal = flowersPriceAutumnWinter * (1 - 0.1) + 2;
                        } else {
                            flowersPriceTotal = flowersPriceAutumnWinter + 2;
                        }
                        break;
                }
                break;

        }
        System.out.printf("%.2f", flowersPriceTotal);
    }
}
