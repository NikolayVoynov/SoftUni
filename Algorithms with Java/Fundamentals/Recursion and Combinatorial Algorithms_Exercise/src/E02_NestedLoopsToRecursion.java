import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E02_NestedLoopsToRecursion {
    public static int[] array;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        array = new int[n];

        createPermutations(0);
    }

    private static void createPermutations(int index) {
        if (index == array.length) {
            printPermutation();
        } else {
            for (int i = 1; i <= n; i++) {
                array[index] = i;
                createPermutations(index + 1);
            }
        }
    }

    private static void printPermutation() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
