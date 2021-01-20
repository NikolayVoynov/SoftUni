import java.util.Arrays;
import java.util.Scanner;

public class E08MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputLine = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(element -> Integer.parseInt(element)).toArray();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < inputLine.length; i++) {
            int currentNum = inputLine[i];

            for (int j = i+1; j < inputLine.length; j++) {

                if (currentNum + inputLine[j] == n) {
                    String print = currentNum + " " + inputLine[j];
                    System.out.printf("%s%n", print);
                }

            }


        }


    }
}
