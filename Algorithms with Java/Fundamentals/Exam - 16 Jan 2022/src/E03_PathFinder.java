import java.util.*;
import java.util.stream.Collectors;

public class E03_PathFinder {
    public static Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String inputLine = scanner.nextLine();
            if (!inputLine.equals("")) {
                List<Integer> children = Arrays.stream(inputLine.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

                graph.put(i, children);
            } else {
                graph.put(i, new ArrayList<>());
            }
        }

        int p = Integer.parseInt(scanner.nextLine());
        Map<Integer, List<Integer>> paths = new HashMap<>();

        for (int i = 1; i <= p; i++) {
            List<Integer> path = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            paths.put(i, path);
        }

        for (List<Integer> path : paths.values()) {
            boolean exist = true;

            for (int i = 0; i < path.size() - 1; i++) {
                int pathElem = path.get(i);
                int pathNextElem = path.get(i + 1);

                if (!graph.get(pathElem).contains(pathNextElem)) {
                    exist = false;
                }
            }

            if (exist) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
