import java.util.Scanner;

public class EasterDecoration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int clients = Integer.parseInt(scanner.nextLine());

        double billPerClient = 0;
        double billAllClients = 0;
        String product = "";

        for (int i = 1; i <= clients; i++) {

            int counter = 0;
            double bill = 0;

            product = scanner.nextLine();

            while (!product.equals("Finish")) {

                switch (product) {
                    case "basket":
                        bill += 1.5;
                        break;
                    case "wreath":
                        bill += 3.8;
                        break;
                    case "chocolate bunny":
                        bill += 7;
                        break;
                }

                counter++;

                product = scanner.nextLine();
            }

            if (counter % 2 == 0) {
                bill *= 0.8;
                billAllClients += bill;
                System.out.printf("You purchased %d items for %.2f leva.%n", counter, bill);

            } else {
                billAllClients += bill;
                System.out.printf("You purchased %d items for %.2f leva.%n", counter, bill);
            }

        }

        double billAveragePerClient = billAllClients / clients;

        System.out.printf("Average bill per client is: %.2f leva.", billAveragePerClient);

    }
}
