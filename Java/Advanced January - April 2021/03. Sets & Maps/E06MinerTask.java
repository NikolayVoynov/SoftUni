import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E06MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resource = scanner.nextLine();

        Map<String, Integer> collectedResources = new LinkedHashMap<>();

        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());

            collectedResources.putIfAbsent(resource, 0);
            collectedResources.put(resource, collectedResources.get(resource) + quantity);

            resource = scanner.nextLine();
        }

        collectedResources.forEach((key, value) -> {
            System.out.println(String.format("%s -> %d", key, value));
        });
    }
}
