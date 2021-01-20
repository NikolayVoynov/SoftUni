import java.util.Arrays;
import java.util.Scanner;

public class E05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(element -> Integer.parseInt(element)).toArray();


        for (int i = 0; i < numArray.length; i++) {
            int currentNumber = numArray[i];
            boolean isTopInteger = true;

            for (int j = i + 1; j < numArray.length; j++) {
                if (currentNumber <= numArray[j]) {
                    isTopInteger = false;
                }
            }

            if (isTopInteger) {
                System.out.print(currentNumber + " ");
            }

        }

    }
}
