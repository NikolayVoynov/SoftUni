import java.util.Scanner;

public class FuelTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine();
        String fuelTypeLowerCase = new String(fuelType);
        double litreFuel = Double.parseDouble(scanner.nextLine());

        if (fuelType.equals("Diesel") || fuelType.equals("Gasoline") || fuelType.equals("Gas")) {
            if (litreFuel >= 25) {
                System.out.println("You have enough " + fuelTypeLowerCase.toLowerCase() + ".");
            } else {
                System.out.println("Fill your tank with " + fuelTypeLowerCase.toLowerCase() + "!");
            }
        } else {
            System.out.println("Invalid fuel!");
        }

        }

    }
