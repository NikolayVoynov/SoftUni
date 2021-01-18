import java.util.Scanner;

public class EasterEggs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int eggsCount = Integer.parseInt(scanner.nextLine());

        int maxEggs = Integer.MIN_VALUE;

        int counterRed = 0;
        int counterOrange = 0;
        int counterBlue = 0;
        int counterGreen = 0;

        String colour = "";
        String maxColour = "";

        for (int i = 1; i <= eggsCount; i++) {
            colour = scanner.nextLine();

            switch (colour) {
                case "red":
                    counterRed++;
                    if (counterRed > maxEggs) {
                        maxEggs = counterRed;
                        maxColour = "red";
                    }
                break;
                case "orange":
                    counterOrange++;
                    if (counterOrange > maxEggs) {
                        maxEggs = counterOrange;
                        maxColour = "orange";
                    }
                break;
                case "blue":
                    counterBlue++;
                    if (counterBlue > maxEggs) {
                        maxEggs = counterBlue;
                        maxColour = "blue";
                    }
                break;
                case "green":
                    counterGreen++;
                    if (counterGreen > maxEggs) {
                        maxEggs = counterGreen;
                        maxColour = "green";
                    }
                break;
            }
        }

        System.out.printf("Red eggs: %d%n", counterRed);
        System.out.printf("Orange eggs: %d%n", counterOrange);
        System.out.printf("Blue eggs: %d%n", counterBlue);
        System.out.printf("Green eggs: %d%n", counterGreen);
        System.out.printf("Max eggs: %d -> %s", maxEggs, maxColour);
    }
}
