import java.util.Scanner;

public class ExamNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int low = Integer.parseInt(scanner.nextLine());
        int high = Integer.parseInt(scanner.nextLine());
        int target = Integer.parseInt(scanner.nextLine());

        for (int i = low; i <= high; i++) {
            int num = i;

            int firstDigit = num / 100;
            int secondDigit = num / 10 % 10;
            int thirdDigit = num % 10;

            int sum = firstDigit + secondDigit + thirdDigit;

            if (sum == target){
                System.out.println(num);
            }
        }
    }
}
