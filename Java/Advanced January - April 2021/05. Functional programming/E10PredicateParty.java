import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E10PredicateParty {
    static List<String> names = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = "";
        while (!"Party!".equals(input = scanner.nextLine())) {
            String[] token = input.split("\\s+");
            String commandFirstLevel = token[0];


            switch (commandFirstLevel) {
                case "Double":
                    addAnother(getPredicate(token));
                    break;
                case "Remove":
                    removeThis(getPredicate(token));
                    break;
            }
        }

        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(names);
            System.out.println(names.toString().replaceAll("[\\[\\]]", "") + " are going to the party!");
        }


    }

    public static void removeThis(Predicate<String> predicate) {
        names.removeIf(predicate);
    }

    public static void addAnother(Predicate<String> predicate) {
        List<String> addName = new ArrayList<>();
        names.stream().filter(predicate).forEach(e -> addName.add(e));
        names.addAll(addName);
    }

    public static Predicate<String> getPredicate(String[] token) {
        Predicate<String> predicate = null;
        if (token[1].equals("StartsWith")) {
            predicate = name -> name.startsWith(token[2]);

        } else if (token[1].equals("EndsWith")) {
            predicate = name -> name.endsWith(token[2]);

        } else if (token[1].equals("Length")) {
            int length = Integer.parseInt(token[2]);
            predicate = name -> name.length() == length;

        }

        return predicate;
    }
}
