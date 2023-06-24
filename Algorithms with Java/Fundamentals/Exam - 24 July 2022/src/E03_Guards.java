import java.util.*;

public class E03_Guards {

    public static Set<Integer> notVisitedNodes = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        int nodes = Integer.parseInt(scanner.nextLine());
        int edges = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= nodes; i++) {
            notVisitedNodes.add(i);
            graph.put(i, new HashSet<>());
        }

        for (int i = 0; i < edges; i++) {
            int[] edge = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int from = edge[0];
            int to = edge[1];

            graph.get(from).add(to);
        }

        int startNode = Integer.parseInt(scanner.nextLine());

        dfs(startNode, graph);

        for (Integer node : notVisitedNodes) {
            System.out.print(node + " ");
        }
    }

    private static void dfs(int currentNode, Map<Integer, Set<Integer>> graph) {

        if (!notVisitedNodes.contains(currentNode)) {
            return;
        }

        notVisitedNodes.remove(currentNode);

        Set<Integer> nodes = graph.get(currentNode);
        for (Integer node : nodes) {
            dfs(node, graph);
        }

    }
}
