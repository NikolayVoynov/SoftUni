import java.util.Scanner;

public class Aquapark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//•	На първия ред е месецът ("march", "april", "may", "june", "july", "august ")
//•	На втория ред е броят на прекараните - часове цяло число в интервала [0…100]
//•	На третия ред е броят на хората в групата - цяло число в интервала [0…100]
//•	На четвъртия ред е времето от деня ("day" или "night")

        String month = scanner.nextLine();
        int hours = Integer.parseInt(scanner.nextLine());
        int people = Integer.parseInt(scanner.nextLine());
        String partOfDay = scanner.nextLine();

        double pricePerPerson = 0;
        double totalCost = 0;

        switch (month) {
            case "march":
            case "april":
            case "may":
                if (partOfDay.equals("day")) {
                    if (people >= 4) {
                        if (hours >= 5) {
                            pricePerPerson = 10.5 * 0.9 * 0.5;
                            totalCost = pricePerPerson * people * hours;
                        } else {
                            pricePerPerson = 10.5 * 0.9;
                            totalCost = pricePerPerson * people * hours;
                        }

                    } else {
                        if (hours >= 5) {
                            pricePerPerson = 10.5 * 0.5;
                            totalCost = pricePerPerson * people * hours;
                        } else {
                            pricePerPerson = 10.5;
                            totalCost = pricePerPerson * people * hours;
                        }
                    }

                } else {
                    if (people >= 4) {
                        if (hours >= 5) {
                            pricePerPerson = 8.4 * 0.9 * 0.5;
                            totalCost = pricePerPerson * people * hours;
                        } else {
                            pricePerPerson = 8.4 * 0.9;
                            totalCost = pricePerPerson * people * hours;
                        }

                    } else {
                        if (hours >= 5) {
                            pricePerPerson = 8.4 * 0.5;
                            totalCost = pricePerPerson * people * hours;
                        } else {
                            pricePerPerson = 8.4;
                            totalCost = pricePerPerson * people * hours;
                        }
                    }
                }
                break;
            case "june":
            case "july":
            case "august":
                if (partOfDay.equals("day")) {
                    if (people >= 4) {
                        if (hours >= 5) {
                            pricePerPerson = 12.6 * 0.9 * 0.5;
                            totalCost = pricePerPerson * people * hours;
                        } else {
                            pricePerPerson = 12.6 * 0.9;
                            totalCost = pricePerPerson * people * hours;
                        }

                    } else {
                        if (hours >= 5) {
                            pricePerPerson = 12.6 * 0.5;
                            totalCost = pricePerPerson * people * hours;
                        } else {
                            pricePerPerson = 12.6;
                            totalCost = pricePerPerson * people * hours;
                        }
                    }

                } else {
                    if (people >= 4) {
                        if (hours >= 5) {
                            pricePerPerson = 10.2 * 0.9 * 0.5;
                            totalCost = pricePerPerson * people * hours;
                        } else {
                            pricePerPerson = 10.2 * 0.9;
                            totalCost = pricePerPerson * people * hours;
                        }

                    } else {
                        if (hours >= 5) {
                            pricePerPerson = 10.2 * 0.5;
                            totalCost = pricePerPerson * people * hours;
                        } else {
                            pricePerPerson = 10.2;
                            totalCost = pricePerPerson * people * hours;
                        }
                    }
                }
                break;
        }
        System.out.printf("Price per person for one hour: %.2f%n", pricePerPerson);
        System.out.printf("Total cost of the visit: %.2f", totalCost);
    }
}

