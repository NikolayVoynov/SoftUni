import java.util.Scanner;

public class BalancedNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isBalanced = true;
        int sumOfBalancedNum = 0;

        while (isBalanced) {
            String number = scanner.nextLine();
            String[] input = number.split("");

            if (input.length > 3) {
                isBalanced = false;
            } else {

                int middle = Integer.parseInt(input[1]);
                int sumRear = Integer.parseInt(input[0]) + Integer.parseInt(input[2]);

                if (middle != sumRear) {
                    isBalanced = false;
                } else {
                    sumOfBalancedNum += Integer.parseInt(number);
                }
            }
        }

        System.out.println(sumOfBalancedNum);
    }
}
