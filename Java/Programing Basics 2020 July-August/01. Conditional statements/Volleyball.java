import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String  year = scanner.nextLine();
        int numberHolidays = Integer.parseInt(scanner.nextLine());
        int weekendHome = Integer.parseInt(scanner.nextLine());

        int weekendSofia = 48 - weekendHome;
        double volleyballSofia = 1.0 * weekendSofia * 3/4;
        double volleyballHolidays = 1.0 * numberHolidays * 2/3;
        double volleyball = volleyballSofia + volleyballHolidays + weekendHome;

        switch (year) {
            case "normal":
                volleyball = Math.floor(volleyball);
                System.out.printf("%.0f", volleyball);
                break;
            case "leap":
                volleyball = Math.floor(volleyball * 1.15);
                System.out.printf("%.0f", volleyball);
                break;
        }
    }
}
