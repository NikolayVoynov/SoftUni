import java.util.Scanner;

public class PaintingEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

                String size = scanner.nextLine();
                String colour = scanner.nextLine();
                int count = Integer.parseInt(scanner.nextLine());


                double price = 0;

                switch (size) {
                    case "Large":
                        switch (colour) {
                            case "Red":
                                price = count * 16;
                                break;
                            case "Green":
                                price = count * 12;
                                break;
                            case "Yellow":
                                price = count * 9;
                                break;
                        }
                        break;
                    case "Medium":
                        switch (colour) {
                            case "Red":
                                price = count * 13;
                                break;
                            case "Green":
                                price = count * 9;
                                break;
                            case "Yellow":
                                price = count * 7;
                                break;
                        }
                        break;
                    case "Small":
                        switch (colour) {
                            case "Red":
                                price = count * 9;
                                break;
                            case "Green":
                                price = count * 8;
                                break;
                            case "Yellow":
                                price = count * 5;
                                break;
                        }
                        break;
                }

                double totalIncome = price * 0.65;

                System.out.printf("%.2f leva.", totalIncome);

            }
        }