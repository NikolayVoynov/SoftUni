import java.util.Arrays;
import java.util.Scanner;

public class L06EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(element -> Integer.parseInt(element)).toArray();


        int[] secondArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(element -> Integer.parseInt(element)).toArray();

        int firstArrayLength = firstArray.length;
        int sum = 0;

        boolean isEqual = false;

        for (int i = 0; i < firstArrayLength; i++) {
            if (firstArray[i] != secondArray[i]) {
                isEqual = false;
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                break;
            } else {
                isEqual = true;
                sum += firstArray[i];
            }
        }

        if (isEqual) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
