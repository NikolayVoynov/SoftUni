import java.util.Scanner;

public class E03ZigZag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] firstArray = new int[n];
        int[] secondArray = new int[n];

        for (int i = 1; i <= n; i++) {
            String[] inputLine = scanner.nextLine().split(" ");

            if (i % 2 == 0) {
                firstArray[i - 1] = Integer.parseInt(inputLine[1]);
                secondArray[i - 1] = Integer.parseInt(inputLine[0]);
            } else {
                firstArray[i - 1] = Integer.parseInt(inputLine[0]);
                secondArray[i - 1] = Integer.parseInt(inputLine[1]);
            }

        }

        for (int i = 0; i < firstArray.length; i++) {
            System.out.print(firstArray[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < secondArray.length; i++) {
            System.out.print(secondArray[i] + " ");
        }

    }
}
