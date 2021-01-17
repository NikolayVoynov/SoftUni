import java.io.PrintStream;
import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int sumPieces = 0;

        int piecesCakeAll = width * length;

        while (!input.equals("STOP")) {
           int pieces = Integer.parseInt(input);
           sumPieces += pieces;
           if (sumPieces > piecesCakeAll) {
               System.out.printf("No more cake left! You need %d pieces more.", Math.abs(sumPieces - piecesCakeAll));
               return;
           }
           input = scanner.nextLine();
        }
        System.out.printf("%d pieces are left.", Math.abs(sumPieces - piecesCakeAll));
    }
}
