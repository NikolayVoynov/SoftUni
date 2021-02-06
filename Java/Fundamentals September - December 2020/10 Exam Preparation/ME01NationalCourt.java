import java.util.Scanner;

public class ME01NationalCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());

        int people = Integer.parseInt(scanner.nextLine());

        int answersPerHour = firstEmployee + secondEmployee + thirdEmployee;

        int neededHours = 0;
        int breaks = 0;

        while (people > 0) {
            neededHours++;
            people -= answersPerHour;

            if (neededHours % 3 == 0) {
                breaks++;
            }
        }

        int finalNeededHours = neededHours + breaks;
        System.out.printf("Time needed: %dh.", finalNeededHours);
    }
}
