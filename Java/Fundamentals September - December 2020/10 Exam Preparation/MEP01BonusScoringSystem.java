import java.util.Scanner;

public class MEP01BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());
        int lectures = Integer.parseInt(scanner.nextLine());
        int initialBonus = Integer.parseInt(scanner.nextLine());

        double maxPoints = 0;
        int attendanceStudentMaxBonus = 0;

        for (int i = 0; i < students; i++) {
            int attendance = Integer.parseInt(scanner.nextLine());
            double totalBonus = 1.0 * attendance / lectures * (5 + initialBonus);

            if (totalBonus > maxPoints) {
                maxPoints = totalBonus;
                attendanceStudentMaxBonus = attendance;
            }
        }

        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxPoints));
        System.out.printf("The student has attended %d lectures.", attendanceStudentMaxBonus);
    }
}
