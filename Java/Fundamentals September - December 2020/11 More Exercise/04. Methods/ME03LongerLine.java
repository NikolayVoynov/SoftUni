import java.util.Scanner;

public class ME03LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int xA = Integer.parseInt(scanner.nextLine());
        int yA = Integer.parseInt(scanner.nextLine());
        int xB = Integer.parseInt(scanner.nextLine());
        int yB = Integer.parseInt(scanner.nextLine());
        int xC = Integer.parseInt(scanner.nextLine());
        int yC = Integer.parseInt(scanner.nextLine());
        int xD = Integer.parseInt(scanner.nextLine());
        int yD = Integer.parseInt(scanner.nextLine());

        printLongerLine(xA, yA, xB, yB, xC, yC, xD, yD);
    }

    private static void printLongerLine(int xA, int yA, int xB, int yB, int xC, int yC, int xD, int yD) {
        double xAyAxByB = calculateLineLength(xA, yA, xB, yB);
        double xCyCxDyD = calculateLineLength(xC, yC, xD, yD);

        if (xAyAxByB >= xCyCxDyD) {
            printClosestPointFirst(xA, yA, xB, yB);

        } else {
            printClosestPointFirst(xC, yC, xD, yD);
        }

    }

    private static void printClosestPointFirst(int x1, int y1, int x2, int y2) {
        double distanceX1Y1 = Math.sqrt(x1 * x1 + y1 * y1);
        double distanceX2Y2 = Math.sqrt(x2 * x2 + y2 * y2);
        if (distanceX1Y1 <= distanceX2Y2) {
            System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
        } else {
            System.out.printf("(%d, %d)(%d, %d)", x2, y2, x1, y1);
        }
    }


    private static double calculateLineLength(int x1, int y1, int x2, int y2) {
        double length = 0;
        int x1x2 = 0;
        int y1y2 = 0;
        if ((x1 >= 0 && x2 >= 0) || (x1 <= 0 && x2 <= 0)) {
            x1x2 = Math.abs(x1 - x2);
        } else {
            x1x2 = Math.abs(x1) + Math.abs(x2);
        }

        if ((y1 >= 0 && y2 >= 0) || (y1 <= 0 && y2 <= 0)) {
            y1y2 = Math.abs(y1 - y2);
        } else {
            y1y2 = Math.abs(y1) + Math.abs(y2);
        }

        length = Math.sqrt(x1x2 * x1x2 + y1y2 * y1y2);

        return length;
    }
}
