import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String ticketCategory = scanner.nextLine();
        int people = Integer.parseInt(scanner.nextLine());

        double moneyTickets = 0;
        double budgetTickets = 0;
        double difference = 0;

        switch (ticketCategory) {
            case "VIP":
                if (people >= 50) {
                    moneyTickets = people * 499.99;
                    budgetTickets = budget * (1 - 0.25);
                } else if (people >= 25) {
                    moneyTickets = people * 499.99;
                    budgetTickets = budget * (1 - 0.40);
                } else if (people >= 10) {
                    moneyTickets = people * 499.99;
                    budgetTickets = budget * (1 - 0.50);
                } else if (people >= 5) {
                    moneyTickets = people * 499.99;
                    budgetTickets = budget * (1 - 0.60);
                } else if (people >= 1) {
                    moneyTickets = people * 499.99;
                    budgetTickets = budget * (1 - 0.75);
                }
                break;
            case "Normal":
                if (people >= 50) {
                    moneyTickets = people * 249.99;
                    budgetTickets = budget * (1 - 0.25);
                } else if (people >= 25) {
                    moneyTickets = people * 249.99;
                    budgetTickets = budget * (1 - 0.40);
                } else if (people >= 10) {
                    moneyTickets = people * 249.99;
                    budgetTickets = budget * (1 - 0.50);
                } else if (people >= 5) {
                    moneyTickets = people * 249.99;
                    budgetTickets = budget * (1 - 0.60);
                } else if (people >= 1) {
                    moneyTickets = people * 249.99;
                    budgetTickets = budget * (1 - 0.75);
                }
                break;
        }
        difference = Math.abs(budgetTickets - moneyTickets);
        if (budgetTickets >= moneyTickets) {
            System.out.printf("Yes! You have %.2f leva left.", difference);
         } else {
            System.out.printf("Not enough money! You need %.2f leva.", difference);
         }
    }
}
