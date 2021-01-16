import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double timeFor1m = Double.parseDouble(scanner.nextLine());
        double numberOfSlow = Math.floor(distance / 15);
        double timeTotal = distance * timeFor1m + numberOfSlow * 12.5;

        if (timeTotal < record) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", timeTotal);
        } else {
            double timeExtra = timeTotal - record;
            System.out.printf("No, he failed! He was %.2f seconds slower.", timeExtra);
        }

    }
}
