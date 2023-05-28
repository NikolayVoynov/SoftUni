import java.util.Scanner;

public class L04_VariationsWithRepetition {
    public static String[] elements;
    public static String[] kSlots;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");
        int k = Integer.parseInt(scanner.nextLine());

        kSlots = new String[k];


        createVariations(0);
    }

    private static void createVariations(int index) {
        if (index >= kSlots.length) {
            print();
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            kSlots[index] = elements[i];
            createVariations(index + 1);
        }
    }


    private static void print() {
        System.out.println(String.join(" ", kSlots));
    }
}
