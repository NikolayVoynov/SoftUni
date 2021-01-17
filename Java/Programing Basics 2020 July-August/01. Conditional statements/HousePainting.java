import java.util.Scanner;

public class HousePainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double door = 2 * 1.2;
        double window = 1.5 * 1.5;

        double areaGreenWall = 2 * (x * x + x * y) - door - 2 * window;
        double areaRedRoof = 2 * (x * h / 2 + x * y);

        double litreGreenPaint = areaGreenWall / 3.4;
        double litreRedPaint = areaRedRoof / 4.3;

        System.out.printf("%.2f", litreGreenPaint);
        System.out.println();
        System.out.printf("%.2f", litreRedPaint);


    }
}
