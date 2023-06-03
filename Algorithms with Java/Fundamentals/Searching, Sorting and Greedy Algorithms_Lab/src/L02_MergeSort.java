import java.util.Arrays;
import java.util.Scanner;


public class L02_MergeSort {
    public static int[] inputArr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        inputArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        print(mergeSort(inputArr));
    }

    private static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int midIndex = array.length / 2;

        int firstArrLength = midIndex;
        int secondArrLength = array.length - midIndex;

        int[] firstArr = new int[firstArrLength];
        int[] secondArr = new int[secondArrLength];

        for (int i = 0; i < firstArrLength; i++) {
            firstArr[i] = array[i];
        }

        for (int i = firstArrLength; i < firstArrLength + secondArrLength; i++) {
            secondArr[i - firstArrLength] = array[i];
        }

        firstArr = mergeSort(firstArr);
        secondArr = mergeSort(secondArr);

        int mainIndex = 0;

        int firstArrIndex = 0;
        int secondArrIndex = 0;

        while (firstArrIndex < firstArrLength && secondArrIndex < secondArrLength) {
            if (firstArr[firstArrIndex] < secondArr[secondArrIndex]) {
                array[mainIndex] = firstArr[firstArrIndex];

                mainIndex++;
                firstArrIndex++;
            } else {
                array[mainIndex] = secondArr[secondArrIndex];

                mainIndex++;
                secondArrIndex++;
            }
        }

        while (firstArrIndex < firstArrLength) {
            array[mainIndex] = firstArr[firstArrIndex];

            mainIndex++;
            firstArrIndex++;
        }

        while (secondArrIndex < secondArrLength) {
            array[mainIndex] = secondArr[secondArrIndex];

            mainIndex++;
            secondArrIndex++;
        }

        return array;
    }

    private static void print(int[] mergeSort) {
        StringBuilder sb = new StringBuilder();

        for (int elem : mergeSort) {
            sb.append(elem).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
