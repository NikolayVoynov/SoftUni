import java.util.Scanner;

public class FuelTankPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine();
        double fuelQuantity = Double.parseDouble(scanner.nextLine());
        String clubCard = scanner.nextLine();

        if (clubCard.equals("Yes")) {
            if (fuelType.equals("Gasoline")) {
                if (fuelQuantity < 20) {
                    double fuelPrice = fuelQuantity * (2.22 - 0.18);
                    System.out.printf("%.2f lv.", fuelPrice);
                } else if (fuelQuantity <= 25) {
                    double fuelPrice = fuelQuantity * (2.22 - 0.18) * 0.92;
                    System.out.printf("%.2f lv.", fuelPrice);
                } else {
                    double fuelPrice = fuelQuantity * (2.22 - 0.18) * 0.9;
                    System.out.printf("%.2f lv.", fuelPrice);
                }
            }
            if (fuelType.equals("Diesel")) {
                if (fuelQuantity < 20) {
                    double fuelPrice = fuelQuantity * (2.33 - 0.12);
                    System.out.printf("%.2f lv.", fuelPrice);
                } else if (fuelQuantity <= 25) {
                    double fuelPrice = fuelQuantity * (2.33 - 0.12) * 0.92;
                    System.out.printf("%.2f lv.", fuelPrice);
                } else {
                    double fuelPrice = fuelQuantity * (2.33 - 0.12) * 0.9;
                    System.out.printf("%.2f lv.", fuelPrice);
                }
            }
            if (fuelType.equals("Gas")) {
                if (fuelQuantity < 20) {
                    double fuelPrice = fuelQuantity * (0.93 - 0.08);
                    System.out.printf("%.2f lv.", fuelPrice);
                } else if (fuelQuantity <= 25) {
                    double fuelPrice = fuelQuantity * (0.93 - 0.08) * 0.92;
                    System.out.printf("%.2f lv.", fuelPrice);
                } else {
                    double fuelPrice = fuelQuantity * (0.93 - 0.08) * 0.9;
                    System.out.printf("%.2f lv.", fuelPrice);
                }
            }

        } else if (clubCard.equals("No")) {
            if (fuelType.equals("Gasoline")) {
                if (fuelQuantity < 20) {
                    double fuelPrice = fuelQuantity * 2.22;
                    System.out.printf("%.2f lv.", fuelPrice);
                } else if (fuelQuantity <= 25) {
                    double fuelPrice = fuelQuantity * 2.22 * 0.92;
                    System.out.printf("%.2f lv.", fuelPrice);
                } else {
                    double fuelPrice = fuelQuantity * 2.22 * 0.9;
                    System.out.printf("%.2f lv.", fuelPrice);
                }
            }
            if (fuelType.equals("Diesel")) {
                if (fuelQuantity < 20) {
                    double fuelPrice = fuelQuantity * 2.33;
                    System.out.printf("%.2f lv.", fuelPrice);
                } else if (fuelQuantity <= 25) {
                    double fuelPrice = fuelQuantity * 2.33 * 0.92;
                    System.out.printf("%.2f lv.", fuelPrice);
                } else {
                    double fuelPrice = fuelQuantity * 2.33 * 0.9;
                    System.out.printf("%.2f lv.", fuelPrice);
                }
            }
            if (fuelType.equals("Gas")) {
                if (fuelQuantity < 20) {
                    double fuelPrice = fuelQuantity * 0.93;
                    System.out.printf("%.2f lv.", fuelPrice);
                } else if (fuelQuantity <= 25) {
                    double fuelPrice = fuelQuantity * 0.93 * 0.92;
                    System.out.printf("%.2f lv.", fuelPrice);
                } else {
                    double fuelPrice = fuelQuantity * 0.93 * 0.9;
                    System.out.printf("%.2f lv.", fuelPrice);
                }
            }

        }
    }
}
