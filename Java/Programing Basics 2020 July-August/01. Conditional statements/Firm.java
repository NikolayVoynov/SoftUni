import java.util.Scanner;

public class Firm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int employeesExtraTime = Integer.parseInt(scanner.nextLine());
        double workingDays = days * (1 - 0.1);
        double workingHours = Math.floor(workingDays * 8 + employeesExtraTime * 2 * days);

        if (workingHours >= hours) {
            double extraHours = Math.floor(workingHours - hours);
            System.out.printf("Yes!%.0f hours left.", extraHours);
        } else {
            double deficientHours = Math.floor(hours - workingHours);
            System.out.printf("Not enough time!%.0f hours needed.", deficientHours);
        }
    }
}
