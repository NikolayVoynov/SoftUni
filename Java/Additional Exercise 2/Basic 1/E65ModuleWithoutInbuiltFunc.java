package Basic1;

import java.util.Scanner;

public class E65ModuleWithoutInbuiltFunc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input n1: ");
        int n1 = Integer.parseInt(scanner.nextLine());
        System.out.print("Input n2: ");
        int n2 = Integer.parseInt(scanner.nextLine());
        System.out.println("Result: " + calcModule(n1, n2));
    }

    private static int calcModule(int n1, int n2) {
        int divided = n1 / n2;
        return n1 - (divided * n2);
    }
}
