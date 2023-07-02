import java.util.*;

public class E02_Chainalysis {

    public static Map<String, List<String>> graph = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vertices = Integer.parseInt(scanner.nextLine());

        List<String> transactions = new ArrayList<>();
        String[] vertice = scanner.nextLine().split("\\s+");
        String from = vertice[0];
        String to = vertice[1];

        transactions.add(from);
        transactions.add(to);

        int counter = 1;

        for (int i = 1; i < vertices; i++) {
            vertice = scanner.nextLine().split("\\s+");
            from = vertice[0];
            to = vertice[1];

            if (transactions.contains(from)) {
                transactions.add(to);
            } else {
                transactions.add(from);
                transactions.add(to);
                counter++;
            }
        }

        System.out.println(counter);
    }
}
