import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeFlower = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;

        switch (typeFlower) {
            case "Roses":
                if (count <= 80) {
                    totalPrice = count * 5;
                    if (totalPrice <= budget) {
                        double difference = Math.abs(budget - totalPrice);
                        System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", count, typeFlower, difference);
                    } else {
                        double difference = Math.abs(budget - totalPrice);
                        System.out.printf("Not enough money, you need %.2f leva more.", difference);
                    }
                } else {
                    totalPrice = count * 5 * 0.9;
                    if (totalPrice <= budget) {
                        double difference = Math.abs(budget - totalPrice);
                        System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", count, typeFlower, difference);
                    } else {
                        double difference = Math.abs(budget - totalPrice);
                        System.out.printf("Not enough money, you need %.2f leva more.", difference);
                    }
                }
                break;
            case "Dahlias":
                if (count <= 90) {
                    totalPrice = count * 3.80;
                    if (totalPrice <= budget) {
                        double difference = Math.abs(budget - totalPrice);
                        System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", count, typeFlower, difference);
                    } else {
                        double difference = Math.abs(budget - totalPrice);
                        System.out.printf("Not enough money, you need %.2f leva more.", difference);
                    }
                } else {
                    totalPrice = count * 3.80 * 0.85;
                    if (totalPrice <= budget) {
                        double difference = Math.abs(budget - totalPrice);
                        System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", count, typeFlower, difference);
                    } else {
                        double difference = Math.abs(budget - totalPrice);
                        System.out.printf("Not enough money, you need %.2f leva more.", difference);
                    }
                }
                break;
            case "Tulips":
                if (count <= 80) {
                    totalPrice = count * 2.80;
                    if (totalPrice <= budget) {
                        double difference = Math.abs(budget - totalPrice);
                        System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", count, typeFlower, difference);
                    } else {
                        double difference = Math.abs(budget - totalPrice);
                        System.out.printf("Not enough money, you need %.2f leva more.", difference);
                    }
                } else {
                    totalPrice = count * 2.80 * 0.85;
                    if (totalPrice <= budget) {
                        double difference = Math.abs(budget - totalPrice);
                        System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", count, typeFlower, difference);
                    } else {
                        double difference = Math.abs(budget - totalPrice);
                        System.out.printf("Not enough money, you need %.2f leva more.", difference);
                    }
                }
                break;
            case "Narcissus":
                if (count < 120) {
                    totalPrice = count * 3 * 1.15;
                    if (totalPrice <= budget) {
                        double difference = Math.abs(budget - totalPrice);
                        System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", count, typeFlower, difference);
                    } else {
                        double difference = Math.abs(budget - totalPrice);
                        System.out.printf("Not enough money, you need %.2f leva more.", difference);
                    }
                } else {
                    totalPrice = count * 3;
                    if (totalPrice <= budget) {
                        double difference = Math.abs(budget - totalPrice);
                        System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", count, typeFlower, difference);
                    } else {
                        double difference = Math.abs(budget - totalPrice);
                        System.out.printf("Not enough money, you need %.2f leva more.", difference);
                    }
                }
                break;
            case "Gladiolus":
                if (count < 80) {
                    totalPrice = count * 2.50 * 1.20;
                    if (totalPrice <= budget) {
                        double difference = Math.abs(budget - totalPrice);
                        System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", count, typeFlower, difference);
                    } else {
                        double difference = Math.abs(budget - totalPrice);
                        System.out.printf("Not enough money, you need %.2f leva more.", difference);
                    }
                } else {
                    totalPrice = count * 2.50;
                    if (totalPrice <= budget) {
                        double difference = Math.abs(budget - totalPrice);
                        System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", count, typeFlower, difference);
                    } else {
                        double difference = Math.abs(budget - totalPrice);
                        System.out.printf("Not enough money, you need %.2f leva more.", difference);
                    }
                }
                break;
        }
    }
}
