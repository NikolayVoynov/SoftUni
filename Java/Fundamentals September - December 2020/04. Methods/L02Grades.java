import java.util.Scanner;

public class L02Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printCorrespondingGrade(Double.parseDouble(scanner.nextLine()));

    }

    public static void printCorrespondingGrade(double grade) {
        if (grade >= 5.50) {
            System.out.print("Excellent");

        } else if (grade >= 4.50) {
            System.out.print("Very good");

        } else if (grade >= 3.50) {
            System.out.print("Good");

        } else if (grade >= 3.00) {
            System.out.print("Poor");

        } else {
            System.out.print("Fail");

        }
    }
}
