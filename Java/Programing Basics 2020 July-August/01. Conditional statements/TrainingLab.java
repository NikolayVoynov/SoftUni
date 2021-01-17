import java.util.Scanner;

public class TrainingLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double w = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double hWithoutCorridor = (h-1) * 100;
        double wMetricToCentimetres = w * 100;

        double placesPerRow = Math.floor(hWithoutCorridor / 70);
        double rows = Math.floor(wMetricToCentimetres / 120);

        double places = rows * placesPerRow - 3;

        System.out.printf("%.0f", places);

    }

}
