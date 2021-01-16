import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String destination = "";
        String typeVacation = "";
        double totalPrice = 0;
        String dash = "-";

        if (budget <= 100) {
            destination = "Bulgaria";
            switch (season) {
                case "summer":
                    typeVacation = "Camp";
                    totalPrice = budget * 0.3;
                    break;
                case "winter":
                    typeVacation = "Hotel";
                    totalPrice = budget * 0.7;
                    break;
            }

        } else if (budget <= 1000) {
            destination = "Balkans";
            switch (season) {
                case "summer":
                    typeVacation = "Camp";
                    totalPrice = budget * 0.4;
                    break;
                case "winter":
                    typeVacation = "Hotel";
                    totalPrice = budget * 0.8;
                    break;
            }

        } else {
            destination = "Europe";
                switch (season) {
                    case "summer":
                    case "winter":
                        typeVacation = "Hotel";
                        totalPrice = budget * 0.9;
                        break;
                }
        }
        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s %s %.2f", typeVacation, dash, totalPrice);
    }
}
