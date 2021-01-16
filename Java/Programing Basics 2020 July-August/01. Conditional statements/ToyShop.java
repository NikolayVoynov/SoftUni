import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceVacation = Double.parseDouble(scanner.nextLine());
        int numberPuzzles = Integer.parseInt(scanner.nextLine());
        int numberDolls = Integer.parseInt(scanner.nextLine());
        int numberBearTeddy = Integer.parseInt(scanner.nextLine());
        int numberMinions = Integer.parseInt(scanner.nextLine());
        int numberTracks = Integer.parseInt(scanner.nextLine());

        int numberToys = numberPuzzles + numberDolls + numberBearTeddy + numberMinions + numberTracks;

        double pricePuzzles = numberPuzzles * 2.60;
        double priceDolls = numberDolls * 3.00;
        double priceBearTeddy = numberBearTeddy * 4.10;
        double priceMinions = numberMinions * 8.20;
        double priceTracks = numberTracks * 2.00;

        double priceTotal = pricePuzzles + priceDolls + priceBearTeddy + priceMinions + priceTracks;


        if (numberToys >= 50) {

            double priceTotalWithDiscount = priceTotal * (1 - 0.25);
            double incomeFinal = priceTotalWithDiscount * (1 - 0.10);

            if (incomeFinal >= priceVacation) {

                double moneyRemaining = incomeFinal - priceVacation;
                System.out.printf("Yes! %.2f lv left.", moneyRemaining);

            } else if (incomeFinal < priceVacation){

                double moneyLack = priceVacation - incomeFinal;
                System.out.printf("Not enough money! %.2f lv needed.", moneyLack);

                }
            } else if (numberToys < 50) {

            double priceTotalWithoutDiscount = priceTotal;
            double incomeFinal = priceTotalWithoutDiscount * (1 - 0.10);

            if (incomeFinal >= priceVacation) {

                double moneyRemaining = incomeFinal - priceVacation;
                System.out.printf("Yes! %.2f lv left.", moneyRemaining);

            } else if (incomeFinal < priceVacation) {

                double moneyLack = priceVacation - incomeFinal;
                System.out.printf("Not enough money! %.2f lv needed.", moneyLack);

            }




        }

    }

}
