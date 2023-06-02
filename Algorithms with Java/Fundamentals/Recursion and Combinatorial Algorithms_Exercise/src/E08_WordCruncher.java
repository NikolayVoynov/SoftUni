import java.util.*;
import java.util.stream.Collectors;

public class E08_WordCruncher {
    public static List<String> words;
    public static List<String> permutations = new ArrayList<>();
    public static String target;

    public static Set<String> out = new TreeSet<>();

    public static Map<Integer, List<String>> table = new HashMap<>();
    public static Map<String, Integer> occurrences = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        words = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        target = scanner.nextLine();

        words.removeIf(next -> !target.contains(next));

        for (String substr : words) {
            occurrences.putIfAbsent(substr, 0);
            occurrences.put(substr, occurrences.get(substr) + 1);
            int index = target.indexOf(substr);
            while (index != -1) {
                table.putIfAbsent(index, new ArrayList<>());
                table.get(index).add(substr);
                index = target.indexOf(substr, index + 1);
            }
        }

        generatePermutation(0);

        for (String str : out) {
            System.out.println(str);
        }
    }

    private static void generatePermutation(int index) {
        if (index == target.length()) {
            print();
        } else if (table.containsKey(index)) {
            List<String> strings = table.get(index);
            for (String str : strings) {
                if (occurrences.get(str) > 0) {
                    occurrences.put(str, occurrences.get(str) - 1);
                    permutations.add(str);
                    generatePermutation(index + str.length());
                    permutations.remove(permutations.size() - 1);
                    occurrences.put(str, occurrences.get(str) + 1);
                }
            }
        }
    }

    private static void print() {
        String result = String.join("", permutations);
        if (result.contains(target)) {
            out.add(String.join(" ", permutations));
        }
    }
}
