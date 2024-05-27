import java.util.Scanner;

public class SmallerGreaterOrEqual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] allNum = new int[n];

        for (int i = 0; i < n; i++) {
            allNum[i] = Integer.parseInt(scanner.nextLine());
        }

        StringBuilder result = new StringBuilder(String.valueOf(allNum[0]));

        for (int i = 0; i < allNum.length; i++) {
            if (i + 1 < allNum.length) {
                if (allNum[i] < allNum[i + 1]) {
                    result.append("<").append(String.valueOf(allNum[i + 1]));
                } else if (allNum[i] > allNum[i + 1]) {
                    result.append(">").append(String.valueOf(allNum[i + 1]));
                } else {
                    result.append("=").append(String.valueOf(allNum[i + 1]));
                }
            }
        }

        System.out.println(result);
    }
}
