import java.util.Scanner;

public class CrookedDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] num = scanner.nextLine().split("");
        int sum = 0;

        for (int i = 0; i < num.length; i++) {

            if (!num[i].equals(".") && !num[i].equals("-")) {
                int current = Integer.parseInt(num[i]);

                sum += current;
            }
        }

        if (sum > 9) {
            while (sum > 9) {
                String[] currentSum = String.valueOf(sum).split("");
                sum = 0;
                for (int i = 0; i < currentSum.length; i++) {
                    sum += Integer.parseInt(currentSum[i]);
                }
            }
        }

        System.out.println(sum);
    }
}
