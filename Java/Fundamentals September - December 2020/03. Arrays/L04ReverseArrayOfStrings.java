import java.util.Scanner;

public class L04ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputLine = scanner.nextLine().split(" ");

        for (int i = inputLine.length - 1; i >= 0 ; i--) {
            String element = inputLine[i];
            System.out.print(element + " ");
        }
    }
}
