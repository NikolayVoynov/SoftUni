import java.util.List;
import java.util.Scanner;

public class FE01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder trip = new StringBuilder(scanner.nextLine());

        String message = scanner.nextLine();

        while (!message.equals("Travel")) {
            String[] stops = message.split(":");
            String action = stops[0];

            switch (action) {
                case "Add Stop":
                    int index = Integer.parseInt(stops[1]);
                    String insertText = stops[2];

                    if (isValidIndex(index, trip)) {
                        trip.insert(index, insertText);
                    }
                    break;

                case "Remove Stop":
                    int startIndex = Integer.parseInt(stops[1]);
                    int endIndex = Integer.parseInt(stops[2]) + 1;

                    if (isValidIndex(startIndex, trip) && isValidIndex(endIndex - 1, trip)) {
                        trip.replace(startIndex, endIndex, "");
                    }
                    break;

                case "Switch":
                    String oldString = stops[1];
                    String newString = stops[2];
                    if (trip.toString().contains(oldString)) {
                        trip = new StringBuilder(trip.toString().replace(oldString, newString));
                    }
                    break;
            }
            System.out.println(trip);
            message = scanner.nextLine();
        }

        System.out.println("Ready for world tour! Planned stops: " + trip);
    }

    public static boolean isValidIndex(int index, StringBuilder trip) {

        return index >= 0 && index < trip.length();

    }
}
