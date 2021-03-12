package L02PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rectangleCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int bottomLeftX = rectangleCoordinates[0];
        int bottomLeftY = rectangleCoordinates[1];

        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);

        int topRightX = rectangleCoordinates[2];
        int topRightY = rectangleCoordinates[3];

        Point topRight = new Point(topRightX, topRightY);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {
            int[] pointCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int x = pointCoordinates[0];
            int y = pointCoordinates[1];

            Point point = new Point(x, y);

            System.out.println(rectangle.contains(point));
        }


    }
}
