package Basic1;

import java.util.Arrays;
import java.util.Scanner;

public class E79RotatedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] initialArr = new int[]{20, 30, 40, 50, 60};
        int lengthArr = initialArr.length;
        int[] tempArr = new int[lengthArr];

        System.out.print("Input step of rotation: ");
        int stepRotation = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < stepRotation; i++) {
            tempArr[i] = initialArr[i];
        }

        for (int i = stepRotation; i < lengthArr; i++) {
            initialArr[i - stepRotation] = initialArr[i];
        }

        for (int i = 0; i < stepRotation; i++) {
            initialArr[i + lengthArr - stepRotation] = tempArr[i];
        }

        System.out.print(Arrays.toString(initialArr).replaceAll("[\\[\\],]", ""));
    }
}
