import java.util.Scanner;

public class MilitaryTanks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] moves = scanner.nextLine().split("");

        int x = 0;
        int y = 0;

        for (int i = 0; i < moves.length; i++) {
            String direction = moves[i];
            switch (direction) {
                case "U":
                    y += 1;
                    break;
                case "D":
                    y -= 1;
                    break;
                case "R":
                    x += 1;
                    break;
                case "L":
                    x -= 1;
                    break;
            }
        }

        System.out.printf("(%d, %d)", x, y);
    }
}
