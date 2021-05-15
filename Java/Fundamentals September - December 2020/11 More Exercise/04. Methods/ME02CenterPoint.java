import java.util.Scanner;

public class ME02CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        printClosestPoint(x1, y1, x2, y2);
    }

    public static void printClosestPoint(int x1, int y1, int x2, int y2) {
        double distanceX1Y1 = Math.sqrt(x1 * x1 + y1 * y1);
        double distanceX2Y2 = Math.sqrt(x2 * x2 + y2 * y2);
        if (distanceX1Y1 <= distanceX2Y2) {
            System.out.printf("(%d, %d)", x1, y1);
        } else {
            System.out.printf("(%d, %d)", x2, y2);
        }
    }
}
