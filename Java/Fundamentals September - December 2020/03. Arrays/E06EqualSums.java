import java.util.Arrays;
import java.util.Scanner;

public class E06EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numInput = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(element->Integer.parseInt(element)).toArray();

        boolean noEqualLeftRight = false;


        for (int i = 0; i < numInput.length; i++) {
            int leftSide = 0;
            int rightSide = 0;
            int currentNum = numInput[i];

            if (i > 0) {
                for (int j = 0; j < i; j++) {
                    leftSide += numInput[j];
                }
            }

            if (i < (numInput.length - 1)) {
                for (int j = i +1; j < numInput.length; j++) {
                    rightSide += numInput[j];
                }
            }

            if (leftSide == rightSide) {
                noEqualLeftRight = false;
                System.out.print(i);
                break;
            } else {
                noEqualLeftRight = true;
            }
        }

        if (noEqualLeftRight) {
            System.out.print("no");
        }
    }
}
