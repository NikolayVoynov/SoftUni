import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E11ThePartyReservationFilterModule {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> invitations = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = "";

        Map<String, Predicate<String>> predicates = new HashMap<>();

        while (!"Print".equals(input = scanner.nextLine())) {
            String[] token = input.split(";");
            String firstCommand = token[0];
            String predicateName = token[1] + token[2];

            switch (firstCommand) {
                case "Add filter":
                    Predicate<String> predicate = getPredicate(token);
                    predicates.put(predicateName, predicate);
                    break;
                case "Remove filter":
                    predicates.remove(predicateName);
                    break;
            }
        }

        invitations.stream().filter(invitation -> {
            boolean isValid = true;
            for (Predicate<String> predicate : predicates.values()) {
                if (predicate.test(invitation)) {
                    isValid = false;
                    break;
                }
            }
            return isValid;
        }).forEach(element -> System.out.print(element + " "));
    }


    public static Predicate<String> getPredicate(String[] token) {
        Predicate<String> predicate = null;
        if (token[1].equals("Starts with")) {
            predicate = name -> name.startsWith(token[2]);

        } else if (token[1].equals("Ends with")) {
            predicate = name -> name.endsWith(token[2]);

        } else if (token[1].equals("Length")) {
            predicate = name -> name.length() == Integer.parseInt(token[2]);

        } else if (token[1].equals("Contains")) {
            predicate = name -> name.contains(token[2]);
        }

        return predicate;
    }
}
