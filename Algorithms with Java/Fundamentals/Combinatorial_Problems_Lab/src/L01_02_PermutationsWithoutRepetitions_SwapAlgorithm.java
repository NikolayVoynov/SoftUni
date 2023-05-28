import java.util.Scanner;

public class L01_02_PermutationsWithoutRepetitions_SwapAlgorithm {
    public static String[] elements;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");

        permute(0);
    }

    private static void permute(int index) {
        if (index >= elements.length) {
            print(elements);
            return;
        }
        permute(index + 1);
        for (int i = index + 1; i < elements.length; i++) {
            swap(elements, index, i);
            permute(index + 1);
            swap(elements, index, i);
        }
    }

    private static void swap(String[] array, int first, int second) {
        String temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    private static void print(String[] array) {
        System.out.println(String.join(" ", array));
    }
}
