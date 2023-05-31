import java.util.Scanner;

public class E05_CombinationsWithoutRepetition {
    public static int n;
    public static int[] combinations;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

        combinations = new int[k];

        createCombination(0, 1);
    }

    private static void createCombination(int index, int start) {
        if (index == combinations.length) {
            printCombinations();
        } else {
            for (int i = start; i <= n; i++) {
                combinations[index] = i;
                createCombination(index + 1, i + 1);
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
