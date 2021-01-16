import java.util.Scanner;

public class OnTimeForExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hourExam = Integer.parseInt(scanner.nextLine());
        int minExam = Integer.parseInt(scanner.nextLine());
        int hourArrival = Integer.parseInt(scanner.nextLine());
        int minArrival = Integer.parseInt(scanner.nextLine());

        int totalMinExam = hourExam * 60 + minExam;
        int totalMinArrival = hourArrival * 60 + minArrival;
        int differenceTime = Math.abs(totalMinExam - totalMinArrival);

        int hoursEarly = 0;
        int minEarly = 0;
        int hoursLate = 0;
        int minLate = 0;

        if (totalMinExam >= totalMinArrival && differenceTime <= 30) {
            if (differenceTime == 0) {
                System.out.println("On time");
            } else {
                System.out.printf("On time%n");
                System.out.printf("%d minutes before the start", differenceTime);
            }
        } else if (totalMinExam > totalMinArrival) {
            if (differenceTime < 60) {
                System.out.printf("Early%n");
                System.out.printf("%d minutes before the start", differenceTime);
            } else {
                hoursEarly = differenceTime / 60;
                minEarly = differenceTime % 60;

                System.out.printf("Early%n");
                System.out.printf("%d : %02d hours before the start", hoursEarly, minEarly);
            }
        } else if (totalMinExam < totalMinArrival) {
            if (differenceTime < 60) {
                System.out.printf("Late%n");
                System.out.printf("%d minutes after the start", differenceTime);
            } else {
            hoursLate = differenceTime / 60;
            minLate = differenceTime % 60;

            System.out.printf("Late%n");
            System.out.printf("%d : %02d hours after the start", hoursLate, minLate);
            }
        }
    }
}
