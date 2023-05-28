import java.util.Scanner;

public class L03_VariationsWithoutRepetitions {
    public static String[] elements;
    public static String[] kSlots;
    public static boolean[] used;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");
        int k = Integer.parseInt(scanner.nextLine());

        kSlots = new String[k];
        used = new boolean[elements.length];

        createVariations(0);
    }

    private static void createVariations(int index) {
        if (index >= kSlots.length) {
            print();
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            if (!used[i]) {
                used[i] = true;
                kSlots[index] = elements[i];
                createVariations(index + 1);
                used[i] = false;
            }
        }

    }

    private static void print() {
        System.out.println(String.join(" ", kSlots));
    }
}
