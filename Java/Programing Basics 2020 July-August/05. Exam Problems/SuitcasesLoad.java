import java.util.Scanner;

public class SuitcasesLoad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double cargoCapacity = Double.parseDouble(scanner.nextLine());

        String input = scanner.nextLine();

        boolean noFreeSpace = false;
        int counter = 1;

        while (!input.equals("End")) {
            double suitcaseVol = Double.parseDouble(input);

            if (counter % 3 == 0) {
                suitcaseVol += suitcaseVol * 0.1;
            }

            cargoCapacity -= suitcaseVol;

            if (cargoCapacity < 0) {
                noFreeSpace = true;
                break;
            }

            counter++;

            input = scanner.nextLine();
        }

        if (noFreeSpace) {
            System.out.println("No more space!");
        } else {
            System.out.println("Congratulations! All suitcases are loaded!");
        }

        System.out.printf("Statistic: %d suitcases loaded.", counter - 1);
    }
}
