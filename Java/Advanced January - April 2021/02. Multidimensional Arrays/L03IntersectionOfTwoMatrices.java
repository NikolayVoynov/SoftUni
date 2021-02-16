import java.util.Arrays;
import java.util.Scanner;

public class L03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][];

        for (int row = 0; row < rows; row++) {
            firstMatrix[row] = scanner.nextLine().replaceAll("\\s+", "")
                    .toCharArray();
        }

        char[][] secondMatrix = new char[rows][];

        for (int row = 0; row < rows; row++) {
            secondMatrix[row] = scanner.nextLine().replaceAll("\\s+","")
                    .toCharArray();
        }

        char[][] finalMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]) {
                    finalMatrix[row][col] = firstMatrix[row][col];
                } else {
                    finalMatrix[row][col] = '*';
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(finalMatrix[row][col] + " ");
            }
            System.out.println();
        }



    }
}
