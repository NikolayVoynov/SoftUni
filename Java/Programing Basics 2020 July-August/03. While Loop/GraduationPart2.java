import java.util.Scanner;

public class GraduationPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        int counter = 1;
        int exclude = 0;
        double sum = 0;

        while (counter <= 12) {
            double grade = Double.parseDouble(scanner.nextLine());
            if (grade < 4.00) {
                exclude++;
                if (exclude > 1) {
                    System.out.printf("%s has been excluded at %d grade", name, counter);
                    return;
                }
                continue;
            }
            sum += grade;
            counter++;
        }
        double average = sum / 12;
        System.out.printf("%s graduated. Average grade: %.2f", name, average);
    }
}
