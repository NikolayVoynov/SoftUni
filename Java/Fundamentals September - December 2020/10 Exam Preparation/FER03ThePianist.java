import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FER03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String[]> pieces = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\|");
            String piece = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];

            String[] composerKey = new String[]{composer, key};
            pieces.put(piece, composerKey);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] newTokens = input.split("\\|");
            String command = newTokens[0];
            String piece = newTokens[1];

            switch (command) {
                case "Add":
                    String composer = newTokens[2];
                    String key = newTokens[3];

                    if (pieces.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else {
                        String[] composerKey = new String[]{composer, key};
                        pieces.put(piece, composerKey);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    }
                    break;

                case "Remove":
                    if (pieces.containsKey(piece)) {
                        pieces.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;

                case "ChangeKey":
                    String newKey = newTokens[2];
                    if (pieces.containsKey(piece)) {
                        pieces.get(piece)[1] = newKey;
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }

                    break;
            }

            input = scanner.nextLine();
        }

        pieces.entrySet().stream().sorted((a, b) -> {
            int result = a.getKey().compareTo(b.getKey());
            if (result==0) {
                result = a.getValue()[0].compareTo(b.getValue()[0]);
            }

            return result;
        }).forEach(e-> System.out.printf("%s -> Composer: %s, Key: %s%n", e.getKey(), e.getValue()[0], e.getValue()[1]));
    }
}
