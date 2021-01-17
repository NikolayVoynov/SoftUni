import java.util.Scanner;

public class SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        String groupType = scanner.nextLine();
        int number = Integer.parseInt(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());

        String sport = "";
        double price = 0;

        if (number >= 50) {
            switch (season) {
                case "Winter":
                    switch (groupType) {
                        case "girls":
                            sport = "Gymnastics";
                            price = nights * 9.6 * number * 0.5;
                            break;
                        case "boys":
                            sport = "Judo";
                            price = nights * 9.6 * number * 0.5;
                            break;
                        case "mixed":
                            sport = "Ski";
                            price = nights * 10 * number * 0.5;
                            break;
                    }
                    break;
                case "Spring":
                    switch (groupType) {
                        case "girls":
                            sport = "Athletics";
                            price = nights * 7.2 * number * 0.5;
                            break;
                        case "boys":
                            sport = "Tennis";
                            price = nights * 7.2 * number * 0.5;
                            break;
                        case "mixed":
                            sport = "Cycling";
                            price = nights * 9.5 * number * 0.5;
                            break;
                    }
                    break;
                case "Summer":
                    switch (groupType) {
                        case "girls":
                            sport = "Volleyball";
                            price = nights * 15 * number * 0.5;
                            break;
                        case "boys":
                            sport = "Football";
                            price = nights * 15 * number * 0.5;
                            break;
                        case "mixed":
                            sport = "Swimming";
                            price = nights * 20 * number * 0.5;
                            break;
                    }
                    break;
            }
        } else if (number >= 20) {
            switch (season) {
                case "Winter":
                    switch (groupType) {
                        case "girls":
                            sport = "Gymnastics";
                            price = nights * 9.6 * number * 0.85;
                            break;
                        case "boys":
                            sport = "Judo";
                            price = nights * 9.6 * number * 0.85;
                            break;
                        case "mixed":
                            sport = "Ski";
                            price = nights * 10 * number * 0.85;
                            break;
                    }
                    break;
                case "Spring":
                    switch (groupType) {
                        case "girls":
                            sport = "Athletics";
                            price = nights * 7.2 * number * 0.85;
                            break;
                        case "boys":
                            sport = "Tennis";
                            price = nights * 7.2 * number * 0.85;
                            break;
                        case "mixed":
                            sport = "Cycling";
                            price = nights * 9.5 * number * 0.85;
                            break;
                    }
                    break;
                case "Summer":
                    switch (groupType) {
                        case "girls":
                            sport = "Volleyball";
                            price = nights * 15 * number * 0.85;
                            break;
                        case "boys":
                            sport = "Football";
                            price = nights * 15 * number * 0.85;
                            break;
                        case "mixed":
                            sport = "Swimming";
                            price = nights * 20 * number * 0.85;
                            break;
                    }
                    break;
            }

        } else if (number >= 10) {
            switch (season) {
                case "Winter":
                    switch (groupType) {
                        case "girls":
                            sport = "Gymnastics";
                            price = nights * 9.6 * number * 0.95;
                            break;
                        case "boys":
                            sport = "Judo";
                            price = nights * 9.6 * number * 0.95;
                            break;
                        case "mixed":
                            sport = "Ski";
                            price = nights * 10 * number * 0.95;
                            break;
                    }
                    break;
                case "Spring":
                    switch (groupType) {
                        case "girls":
                            sport = "Athletics";
                            price = nights * 7.2 * number * 0.95;
                            break;
                        case "boys":
                            sport = "Tennis";
                            price = nights * 7.2 * number * 0.95;
                            break;
                        case "mixed":
                            sport = "Cycling";
                            price = nights * 9.5 * number * 0.95;
                            break;
                    }
                    break;
                case "Summer":
                    switch (groupType) {
                        case "girls":
                            sport = "Volleyball";
                            price = nights * 15 * number * 0.95;
                            break;
                        case "boys":
                            sport = "Football";
                            price = nights * 15 * number * 0.95;
                            break;
                        case "mixed":
                            sport = "Swimming";
                            price = nights * 20 * number * 0.95;
                            break;
                    }
                    break;
            }

        } else {
            switch (season) {
                case "Winter":
                    switch (groupType) {
                        case "girls":
                            sport = "Gymnastics";
                            price = nights * 9.6 * number;
                            break;
                        case "boys":
                            sport = "Judo";
                            price = nights * 9.6 * number;
                            break;
                        case "mixed":
                            sport = "Ski";
                            price = nights * 10 * number;
                            break;
                    }
                    break;
                case "Spring":
                    switch (groupType) {
                        case "girls":
                            sport = "Athletics";
                            price = nights * 7.2 * number;
                            break;
                        case "boys":
                            sport = "Tennis";
                            price = nights * 7.2 * number;
                            break;
                        case "mixed":
                            sport = "Cycling";
                            price = nights * 9.5 * number;
                            break;
                    }
                    break;
                case "Summer":
                    switch (groupType) {
                        case "girls":
                            sport = "Volleyball";
                            price = nights * 15 * number;
                            break;
                        case "boys":
                            sport = "Football";
                            price = nights * 15 * number;
                            break;
                        case "mixed":
                            sport = "Swimming";
                            price = nights * 20 * number;
                            break;
                    }
                    break;
            }

        }
        System.out.printf("%s %.2f lv.", sport, price);
    }
}