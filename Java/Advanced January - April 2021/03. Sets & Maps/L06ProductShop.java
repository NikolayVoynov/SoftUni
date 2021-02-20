import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class L06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Double>> shopInfo = new TreeMap<>();

        while (!input.equals("Revision")) {
            String[] info = input.split(",\\s+");
            String shop = info[0];
            String product = info[1];
            double price = Double.parseDouble(info[2]);

            shopInfo.putIfAbsent(shop, new LinkedHashMap<>());
            shopInfo.get(shop).put(product, price);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Double>> entry: shopInfo.entrySet()) {
            System.out.println(entry.getKey() + "->");
            Map<String, Double> innerMap = entry.getValue();

            for (Map.Entry<String, Double> innerEntry : innerMap.entrySet()) {
                System.out.println(String.format("Product: %s, Price: %.1f", innerEntry.getKey(), innerEntry.getValue()));
            }
        }
    }
}
