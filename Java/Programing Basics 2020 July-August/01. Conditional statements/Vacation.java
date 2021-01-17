import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String accommodation = "";
        String location = "";
        String dash = "-";
        double price = 0;

        if (budget <= 1000) {
            accommodation = "Camp";
            switch (season) {
                case "Summer":
                    location = "Alaska";
                    price = budget * 0.65;
                    break;
                case "Winter":
                    location = "Morocco";
                    price = budget * 0.45;
                    break;
            }

        } else if (budget <= 3000) {
            accommodation = "Hut";
            switch (season) {
                case "Summer":
                    location = "Alaska";
                    price = budget * 0.80;
                    break;
                case "Winter":
                    location = "Morocco";
                    price = budget * 0.60;
                    break;
            }

        } else {
            accommodation = "Hotel";
            switch (season) {
                case "Summer":
                    location = "Alaska";
                    price = budget * 0.90;
                    break;
                case "Winter":
                    location = "Morocco";
                    price = budget * 0.90;
                    break;
            }
        }

        System.out.printf("%s %s %s %s %.2f", location, dash, accommodation, dash, price);
    }
}

