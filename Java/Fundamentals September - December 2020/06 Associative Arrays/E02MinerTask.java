import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E02MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();

        String input = scanner.nextLine();

        String resourceKey = "";
        int resourceValue = 0;
        int counter = 0;

        while (!input.equals("stop")) {
            counter++;
            if (counter % 2 != 0) {
                resourceKey = input;
                if (!resources.containsKey(resourceKey)) {
                    resources.put(resourceKey, 0);
                }
            } else {
                    resourceValue = resources.get(resourceKey);
                    resourceValue += Integer.parseInt(input);
                    resources.put(resourceKey, resourceValue);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
