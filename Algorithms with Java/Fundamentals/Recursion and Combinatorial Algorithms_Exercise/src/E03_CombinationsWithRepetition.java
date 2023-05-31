import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E03_CombinationsWithRepetition {
    public static int[] combinations;
    public static int n;
    public static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        k = Integer.parseInt(reader.readLine());

        combinations = new int[k];

        createCombination(0, 1);
    }

    private static void createCombination(int index, int start) {
        if (index == combinations.length) {
            printCombinations();
        } else {
            for (int i = start; i <= n; i++) {
                combinations[index] = i;
                createCombination(index + 1, i);
            }
        }
    }

    private static void printCombinations() {
        for (int i = 0; i < combinations.length; i++) {
            System.out.print(combinations[i] + " ");
        }
        System.out.println();
    }
}
