import java.util.Scanner;

public class Energy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] num = scanner.nextLine().split("");
        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < num.length; i++) {
            int currentNum = Integer.parseInt(num[i]);

            if (currentNum % 2 == 0) {
                evenSum += currentNum;
            } else {
                oddSum += currentNum;
            }
        }

        if (evenSum > oddSum){
            System.out.printf("%d energy drinks", evenSum);
        } else if (evenSum < oddSum) {
            System.out.printf("%d cups of coffee", oddSum);
        } else {
            System.out.printf("%d of both", evenSum);
        }

    }
}
