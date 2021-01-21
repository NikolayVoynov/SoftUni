import java.util.Scanner;

public class L09GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeInput = scanner.nextLine();

        if (typeInput.equals("int")) {
            int first = Integer.parseInt(scanner.nextLine());
            int second = Integer.parseInt(scanner.nextLine());
            System.out.print(getMax(first, second));
        }

        if (typeInput.equals("char")) {
            String first = scanner.nextLine();
            String second = scanner.nextLine();
            char firstCh = first.charAt(0);
            char secondCh = second.charAt(0);
            System.out.print(getMax(firstCh, secondCh));

        }

        if (typeInput.equals("string")) {
            String first = scanner.nextLine();
            String second = scanner.nextLine();
            System.out.print(getMax(first, second));

        }

    }

    public static int getMax(int first, int second) {
        if (first >= second) {
            return first;
        }
        return second;
    }

    public static char getMax(char firstCh, char secondCh) {

        if (firstCh >= secondCh) {
            return firstCh;
        }
        return secondCh;
    }

    public static String getMax(String first, String second) {

        if (first.compareTo(second) >= 0) {
            return first;
        }
        return second;
    }
}
