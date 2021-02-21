import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class E04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> letterOccurrence = new TreeMap<>();

        String text = scanner.nextLine();

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            letterOccurrence.putIfAbsent(letter, 0);
            letterOccurrence.put(letter, letterOccurrence.get(letter) + 1);
        }

        letterOccurrence.entrySet().forEach(entry -> {
            System.out.println(String.format("%c: %d time/s", entry.getKey(), entry.getValue()));
        });
    }
}
