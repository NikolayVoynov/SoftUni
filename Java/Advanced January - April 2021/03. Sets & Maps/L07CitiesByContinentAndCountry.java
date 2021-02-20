import java.util.*;

public class L07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            if (!map.containsKey(continent)) {
                map.put(continent, new LinkedHashMap<>());
                map.get(continent).put(country, new ArrayList<>());
                map.get(continent).get(country).add(city);
            } else {
                if (!map.get(continent).containsKey(country)) {
                    map.get(continent).put(country, new ArrayList<>());
                    map.get(continent).get(country).add(city);
                } else {
                    map.get(continent).get(country).add(city);
                }
            }
        }

        for (Map.Entry<String, Map<String, List<String>>> entryMap : map.entrySet()) {
            System.out.println(entryMap.getKey() + ":");
            Map<String, List<String>> innerMap = entryMap.getValue();
            for (Map.Entry<String, List<String>> entryInnerMap : innerMap.entrySet()) {
                System.out.print("  " + entryInnerMap.getKey() + " -> ");
                System.out.println(String.format(entryInnerMap.getValue().toString().replaceAll("[\\[\\]]", "")));
            }
        }
    }
}
