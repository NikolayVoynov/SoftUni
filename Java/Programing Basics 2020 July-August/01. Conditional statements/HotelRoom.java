import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int numberNights = Integer.parseInt(scanner.nextLine());
        double priceApartment = 0;
        double priceStudio = 0;

        switch (month) {
            case "May":
            case "October":
                if (numberNights > 14) {
                    priceStudio = numberNights * 50 * 0.7;
                    priceApartment = numberNights * 65 * 0.9;
                    System.out.printf("Apartment: %.2f lv.%n", priceApartment);
                    System.out.printf("Studio: %.2f lv.", priceStudio);
                } else if (numberNights > 7) {
                    priceStudio = numberNights * 50 * 0.95;
                    priceApartment = numberNights * 65;
                    System.out.printf("Apartment: %.2f lv.%n", priceApartment);
                    System.out.printf("Studio: %.2f lv.", priceStudio);
                } else {
                    priceStudio = numberNights * 50;
                    priceApartment = numberNights * 65;
                    System.out.printf("Apartment: %.2f lv.%n", priceApartment);
                    System.out.printf("Studio: %.2f lv.", priceStudio);
                }
                break;

            case "June":
            case "September":
                if (numberNights > 14) {
                    priceStudio = numberNights * 75.20 * 0.8;
                    priceApartment = numberNights * 68.70 * 0.9;
                    System.out.printf("Apartment: %.2f lv.%n", priceApartment);
                    System.out.printf("Studio: %.2f lv.", priceStudio);
                } else {
                    priceStudio = numberNights * 75.20;
                    priceApartment = numberNights * 68.70;
                    System.out.printf("Apartment: %.2f lv.%n", priceApartment);
                    System.out.printf("Studio: %.2f lv.", priceStudio);
                }
                break;

            case "July":
            case "August":
                if (numberNights > 14) {
                    priceStudio = numberNights * 76;
                    priceApartment = numberNights * 77 * 0.9;
                    System.out.printf("Apartment: %.2f lv.%n", priceApartment);
                    System.out.printf("Studio: %.2f lv.", priceStudio);
                } else {
                    priceStudio = numberNights * 76;
                    priceApartment = numberNights * 77;
                    System.out.printf("Apartment: %.2f lv.%n", priceApartment);
                    System.out.printf("Studio: %.2f lv.", priceStudio);
                }
                break;
        }
    }
}
