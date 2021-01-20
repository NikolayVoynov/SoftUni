import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class E02CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split(" ");
        String[] secondLine = scanner.nextLine().split(" ");

        String print = "";

        for (int i = 0; i < secondLine.length; i++) {
            for (int j = 0; j < firstLine.length; j++) {
                if (secondLine[i].equals(firstLine[j])) {
                    print += (secondLine[i] + " ");
                }
            }
        }
        System.out.print(print);
    }
}
