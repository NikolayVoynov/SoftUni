import java.util.Scanner;

public class L05_CombinationsWithoutRepetition {
    public static String[] elements;
    public static String[] kSlots;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");
        int k = Integer.parseInt(scanner.nextLine());

        kSlots = new String[k];

        createCombination(0, 0);
    }

    private static void createCombination(int index, int start) {
        if (index >= kSlots.length) {
            print();
            return;
        }

        for (int i = start; i < elements.length; i++) {
            kSlots[index] = elements[i];
            createCombination(index + 1, i + 1);

        }

    }

    private static void print() {
        System.out.println(String.join(" ", kSlots));
    }
}
