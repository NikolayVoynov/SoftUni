import java.util.Scanner;

public class SleepyTomCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int holidays = Integer.parseInt(scanner.nextLine());
        int workdays = 365 - holidays;
        double norm = 30000;
        double timeForPlay = holidays * 127 + workdays * 63;
        double overtime = 0;
        double lessTime = 0;
        double overtimeHours = 0;
        double overtimeMinutes = 0;
        double lessTimeHours = 0;
        double lessTimeMinutes = 0;

        if (timeForPlay > norm) {
            overtime = timeForPlay - norm;
            overtimeHours = Math.floor(overtime / 60);
            overtimeMinutes = overtime % 60;
            System.out.println("Tom will run away");
            System.out.printf("%.0f hours and %.0f minutes more for play", overtimeHours, overtimeMinutes);
        } else {
            lessTime = norm - timeForPlay;
            lessTimeHours = Math.floor(lessTime / 60);
            lessTimeMinutes = lessTime % 60;
            System.out.println("Tom sleeps well");
            System.out.printf("%.0f hours and %.0f minutes less for play", lessTimeHours, lessTimeMinutes);

        }
    }
}
