import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String day = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());
        double price = 0;

        if (fruit.equals("banana")) {
            switch (day) {
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                    price = quantity * 2.50;
                    System.out.printf("%.2f", price);
                    break;
                case "Saturday":
                case "Sunday":
                    price = quantity * 2.70;
                    System.out.printf("%.2f", price);
                    break;
                default:
                    System.out.println("error");
            }

        } else if (fruit.equals("apple")) {
            switch (day) {
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                    price = quantity * 1.20;
                    System.out.printf("%.2f", price);
                    break;
                case "Saturday":
                case "Sunday":
                    price = quantity * 1.25;
                    System.out.printf("%.2f", price);
                    break;
                default:
                    System.out.println("error");
            }

        } else if (fruit.equals("orange")) {
            switch (day) {
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                    price = quantity * 0.85;
                    System.out.printf("%.2f", price);
                    break;
                case "Saturday":
                case "Sunday":
                    price = quantity * 0.90;
                    System.out.printf("%.2f", price);
                    break;
                default:
                    System.out.println("error");
            }

        } else if (fruit.equals("grapefruit")) {
            switch (day) {
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                    price = quantity * 1.45;
                    System.out.printf("%.2f", price);
                    break;
                case "Saturday":
                case "Sunday":
                    price = quantity * 1.60;
                    System.out.printf("%.2f", price);
                    break;
                default:
                    System.out.println("error");
            }

        } else if (fruit.equals("kiwi")) {
            switch (day) {
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                    price = quantity * 2.70;
                    System.out.printf("%.2f", price);
                    break;
                case "Saturday":
                case "Sunday":
                    price = quantity * 3.00;
                    System.out.printf("%.2f", price);
                    break;
                default:
                    System.out.println("error");
            }

        } else  if (fruit.equals("pineapple")) {
            switch (day) {
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                    price = quantity * 5.50;
                    System.out.printf("%.2f", price);
                    break;
                case "Saturday":
                case "Sunday":
                    price = quantity * 5.60;
                    System.out.printf("%.2f", price);
                    break;
                default:
                    System.out.println("error");
            }

        } else if (fruit.equals("grapes")) {
            switch (day) {
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                    price = quantity * 3.85;
                    System.out.printf("%.2f", price);
                    break;
                case "Saturday":
                case "Sunday":
                    price = quantity * 4.20;
                    System.out.printf("%.2f", price);
                    break;
                default:
                    System.out.println("error");
            }

        } else {
            System.out.println("error");
        }

    }
}