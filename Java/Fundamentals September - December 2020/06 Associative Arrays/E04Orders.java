import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E04Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> productsQty = new LinkedHashMap<>();
        Map<String, Double> productsPrice = new LinkedHashMap<>();
        Map<String, Double> productsTotalPrice = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("buy")) {
            String[] data = input.split("\\s+");
            String product = data[0];
            double price = Double.parseDouble(data[1]);
            double quantity = Double.parseDouble(data[2]);
            double totalPrice = 0;

            if (!productsQty.containsKey(product)) {
                productsQty.put(product, quantity);
                productsPrice.put(product, price);
                totalPrice = price * quantity;
                productsTotalPrice.put(product, totalPrice);
            } else {
                productsQty.put(product, productsQty.get(product) + quantity);

                if (productsPrice.get(product) != price) {
                    productsPrice.put(product, price);
                    productsTotalPrice.put(product, productsPrice.get(product) * productsQty.get(product));
                } else {
                    productsTotalPrice.put(product, price * productsQty.get(product));
                }
            }

            input = scanner.nextLine();
        }

        productsTotalPrice.forEach((k,v) -> System.out.printf("%s -> %.2f%n", k, v));

    }
}
