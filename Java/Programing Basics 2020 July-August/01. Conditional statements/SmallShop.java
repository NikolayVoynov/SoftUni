import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        String town = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());
        double priceTotalProduct = 0;

        if (product.equals("coffee")) {
            switch (town) {
                case "Sofia":
                    priceTotalProduct = quantity * 0.5;
                    System.out.printf("%f", priceTotalProduct);
                    break;
                case "Plovdiv":
                    priceTotalProduct = quantity * 0.4;
                    System.out.printf("%f", priceTotalProduct);
                    break;
                case "Varna":
                    priceTotalProduct = quantity * 0.45;
                    System.out.printf("%f", priceTotalProduct);
                    break;
            }
        } else if (product.equals("water")) {
            switch (town) {
                case "Sofia":
                    priceTotalProduct = quantity * 0.8;
                    System.out.printf("%f", priceTotalProduct);
                    break;
                case "Plovdiv":
                    priceTotalProduct = quantity * 0.7;
                    System.out.printf("%f", priceTotalProduct);
                    break;
                case "Varna":
                    priceTotalProduct = quantity * 0.7;
                    System.out.printf("%f", priceTotalProduct);
                    break;
            }

        } else if (product.equals("beer")) {
            switch (town) {
                case "Sofia":
                    priceTotalProduct = quantity * 1.2;
                    System.out.printf("%f", priceTotalProduct);
                    break;
                case "Plovdiv":
                    priceTotalProduct = quantity * 1.15;
                    System.out.printf("%f", priceTotalProduct);
                    break;
                case "Varna":
                    priceTotalProduct = quantity * 1.1;
                    System.out.printf("%f", priceTotalProduct);
                    break;
            }

        } else if (product.equals("sweets")) {
            switch (town) {
                case "Sofia":
                    priceTotalProduct = quantity * 1.45;
                    System.out.printf("%f", priceTotalProduct);
                    break;
                case "Plovdiv":
                    priceTotalProduct = quantity * 1.3;
                    System.out.printf("%f", priceTotalProduct);
                    break;
                case "Varna":
                    priceTotalProduct = quantity * 1.35;
                    System.out.printf("%f", priceTotalProduct);
                    break;
            }

        } else if (product.equals("peanuts")) {
            switch (town) {
                case "Sofia":
                    priceTotalProduct = quantity * 1.6;
                    System.out.printf("%f", priceTotalProduct);
                    break;
                case "Plovdiv":
                    priceTotalProduct = quantity * 1.5;
                    System.out.printf("%f", priceTotalProduct);
                    break;
                case "Varna":
                    priceTotalProduct = quantity * 1.55;
                    System.out.printf("%f", priceTotalProduct);
                    break;
            }

        }
    }
}
