import java.util.Scanner;

public class GreaterNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input1 = scanner.nextLine().split(",");
        String[] input2 = scanner.nextLine().split(",");

        int[] firstArr = new int[input1.length];
        int[] secondArr = new int[input2.length];

        String[] result = new String[input1.length];
        int index = 0;

        for (int i = 0; i < input1.length; i++) {
            firstArr[i] = Integer.parseInt(input1[i]);
        }

        for (int i = 0; i < input2.length; i++) {
            secondArr[i] = Integer.parseInt(input2[i]);
        }

        for (int i = 0; i < firstArr.length; i++) {
            int firstNum = firstArr[i];

            for (int j = 0; j < secondArr.length; j++) {
                int secondNum = secondArr[j];

                if (firstNum == secondNum) {
                    if (j + 1 < secondArr.length) {
                        int rightNum = secondArr[j + 1];
                        if (rightNum > firstNum) {
                            result[index] = String.valueOf(rightNum);
                        } else {
                            result[index] = "-1";
                        }
                    } else {
                        result[index] = "-1";
                    }
                    index++;
                }
            }
        }

        System.out.println(String.join(",", result));
    }
}
