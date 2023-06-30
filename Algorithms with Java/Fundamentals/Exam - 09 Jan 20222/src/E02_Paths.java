import java.util.*;
import java.util.stream.Collectors;

public class E02_Paths {

    public static Map<Integer, List<Integer>> graph = new HashMap<>();
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        visited = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            List<Integer> children = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            graph.put(i, children);
        }

        int destination = n - 1;

        for (int i = 0; i < n - 1; i++) {
            int start = i;
            List<Integer> path = new ArrayList<>();
            path.add(start);
            dfs(start, destination, path);
        }

    }

    private static void dfs(int current, int destination, List<Integer> path) {
        visited[current] = true;

        if (current == destination) {
            for (Integer elem : path) {
                System.out.print(elem + " ");
            }
            System.out.println();
            visited[current] = false;
            return;
        }

        List<Integer> children = graph.get(current);
        for (Integer child : children) {
            if (!visited[child]) {
                path.add(child);
                dfs(child, destination, path);
                path.remove(child);
            }
        }

        visited[current] = false;
    }
}
