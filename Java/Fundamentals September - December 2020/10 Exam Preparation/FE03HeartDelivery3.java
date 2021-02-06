import java.util.Arrays;
import java.util.Scanner;

public class FE03HeartDelivery3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] neighborhood = Arrays.stream(scanner.nextLine().split("@"))
                .mapToInt(Integer::parseInt).toArray();

        String command = scanner.nextLine();

        int house = 0;

        while (!command.equals("Love!")) {
            String[] token = command.split("\\s+");
            int jumpLength = Integer.parseInt(token[1]);

            house += jumpLength;

            if (house >= neighborhood.length) {
                house = 0;

                if (neighborhood[house] == 0) {
                    System.out.printf("Place %d already had Valentine's day.%n", house);

                } else {
                    int check = neighborhood[house] - 2;

                    if (check != 0) {
                        neighborhood[house] -= 2;
                    } else {
                        System.out.printf("Place %d has Valentine's day.%n", house);
                        neighborhood[house] = 0;
                    }
                }


            } else {
                if (neighborhood[house] == 0) {
                    System.out.printf("Place %d already had Valentine's day.", house);
                } else {
                    neighborhood[house] -= 2;

                    if (neighborhood[house] == 0) {
                        System.out.printf("Place %d has Valentine's day.%n", house);
                    }
                }

            }
            command = scanner.nextLine();
        }

        System.out.printf("Cupid's last position was %d.%n", house);

        int failedHouses = 0;

        for (int i = 0; i < neighborhood.length; i++) {
            if (neighborhood[i] != 0) {
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
