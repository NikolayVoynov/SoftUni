import java.util.Scanner;

public class EasterTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();
        String reservation = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());

//                    21-23 март    24-27 март     28-31 март
//        Франция        30 лв.        35 лв.        40 лв.
//         Италия        28 лв.        32 лв.        39 лв.
//         Германия      32 лв.        37 лв.        43 лв.


        double price = 0;

        switch (destination) {
            case "France":
                switch (reservation) {
                    case "21-23":
                        price = nights * 30;
                        break;
                    case "24-27":
                        price = nights * 35;
                        break;
                    case "28-31":
                        price = nights * 40;
                        break;
                }
                break;
            case "Italy":
                switch (reservation) {
                    case "21-23":
                        price = nights * 28;
                        break;
                    case "24-27":
                        price = nights * 32;
                        break;
                    case "28-31":
                        price = nights * 39;
                        break;
                }
                break;
            case "Germany":
                switch (reservation) {
                    case "21-23":
                        price = nights * 32;
                        break;
                    case "24-27":
                        price = nights * 37;
                        break;
                    case "28-31":
                        price = nights * 43;
                        break;
                }
                break;
        }

        System.out.printf("Easter trip to %s : %.2f leva.", destination, price);

    }
}