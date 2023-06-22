import java.util.Arrays;
import java.util.Scanner;

public class E01_Trains {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] arrivals = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        double[] departures = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int platforms = 0;
        int maxPlatforms = 0;

        for (int i = 0, j = 0; i < arrivals.length; ) {
            if (arrivals[i] < departures[j]) {
                platforms++;
                i++;

                maxPlatforms = Math.max(platforms, maxPlatforms);

            } else {
                j++;
                platforms--;
            }
        }

        System.out.println(maxPlatforms);
    }
}