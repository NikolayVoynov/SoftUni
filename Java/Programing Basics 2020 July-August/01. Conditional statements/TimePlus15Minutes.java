import java.util.Scanner;

public class TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int timeTotalMinutes = hours * 60 + minutes + 15;
        int hoursFinal = timeTotalMinutes / 60;
        int minutesFinal = timeTotalMinutes % 60;
        int hoursFinalOver24 = hoursFinal % 24;

        if (hoursFinal < 24 && minutesFinal < 10) {
            System.out.printf("%d:%02d", hoursFinal, minutesFinal);
        } else if (hoursFinal < 24) {
            System.out.printf("%d:%2d", hoursFinal, minutesFinal);
        }

        if (hoursFinal >= 24 && minutesFinal < 10) {
            System.out.printf("%d:%02d", hoursFinalOver24, minutesFinal);
        } else if (hoursFinal >= 24) {
            System.out.printf("%d:%2d", hoursFinalOver24, minutesFinal);
        }

    }
}
