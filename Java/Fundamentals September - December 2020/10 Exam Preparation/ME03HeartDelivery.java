import java.util.Arrays;
import java.util.Scanner;

public class ME03HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] neighborhood = Arrays.stream(scanner.nextLine().split("@"))
                .mapToInt(Integer::parseInt).toArray();

        int[] initialNeighborhood = new int[neighborhood.length];

        for (int i = 0; i < neighborhood.length; i++) {
            initialNeighborhood[i] = neighborhood[i];
        }

        int lastPosition = 0;

        String input = scanner.nextLine();

        int house = 0;

        while (!input.equals("Love!")) {
            String[] token = input.split("\\s+");
            int length = Integer.parseInt(token[1]);

            if (house < neighborhood.length) {
                house += length;
                lastPosition = house;

                if (house < neighborhood.length) {

                    if (neighborhood[house] == 0) {
                        System.out.printf("Place %d already had Valentine's day.%n", house);
                    } else {
                        neighborhood[house] -= 2;

                        if (neighborhood[house] == 0) {
                            System.out.printf("Place %d has Valentine's day.%n", house);
                        }
                    }
                } else {
                    house = 0;
                }
            }
            input = scanner.nextLine();
        }

        System.out.printf("Cupid's last position was %d.%n", lastPosition);

        int failedHouses = 0;

        for (int i = 0; i < initialNeighborhood.length; i++) {
            if (initialNeighborhood[i] != neighborhood[i]) {
                failedHouses++;
            }
        }

        if (failedHouses == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.%n", failedHouses);
        }
    }
}
