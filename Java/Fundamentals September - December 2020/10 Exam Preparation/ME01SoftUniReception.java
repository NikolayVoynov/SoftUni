import java.util.Scanner;

public class ME01SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEfficiency = Integer.parseInt(scanner.nextLine());
        int secondEfficiency = Integer.parseInt(scanner.nextLine());
        int thirdEfficiency = Integer.parseInt(scanner.nextLine());

        int students = Integer.parseInt(scanner.nextLine());

        int studentsPerHour = firstEfficiency + secondEfficiency + thirdEfficiency;

        int neededHours = 0;

        while (students > 0) {
            neededHours++;

            if (neededHours % 4 != 0) {
                students -= studentsPerHour;
            }
        }

        System.out.printf("Time needed: %dh.", neededHours);
    }
}
