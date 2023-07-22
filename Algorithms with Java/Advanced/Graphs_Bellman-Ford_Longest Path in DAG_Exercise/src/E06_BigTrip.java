import java.util.*;
import java.util.stream.Collectors;

public class E06_BigTrip {

    public static List<int[]> edges = new ArrayList<>();
    public static int[][] graph;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine());
        int edgesCount = Integer.parseInt(scanner.nextLine());

        graph = new int[nodes + 1][nodes + 1];

        for (int i = 0; i < edgesCount; i++) {
            int[] edge = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            graph[from][to] = weight;
            edges.add(new int[]{from, to});
        }

        int source = Integer.parseInt(scanner.nextLine());
        int destination = Integer.parseInt(scanner.nextLine());

        visited = new boolean[nodes + 1];

        Deque<Integer> sortedNodes = new ArrayDeque<>();

        for (int i = 1; i < graph.length; i++) {
            topologicalSortDFS(i, sortedNodes);
        }

        int[] distance = new int[nodes + 1];
        Arrays.fill(distance, Integer.MIN_VALUE);
        distance[source] = 0;

        int[] prev = new int[nodes + 1];
        Arrays.fill(prev, -1);

        for (Integer sNode : sortedNodes) {
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                int weight = graph[from][to];

                if (weight != 0) {
                    if (distance[from] + weight > distance[to]) {
                        distance[to] = distance[from] + weight;
                        prev[to] = from;
                    }
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        path.add(destination);
        int current = prev[destination];
        while (current != -1) {
            path.add(current);
            current = prev[current];
        }
        Collections.reverse(path);
        System.out.println(distance[destination]);

        System.out.println(path.stream().map(String::valueOf).collect(Collectors.joining(" ")));

    }

    private static void topologicalSortDFS(int node, Deque<Integer> sortedNodes) {

        if (visited[node]) {
            return;
        }

        visited[node] = true;

        for (int i = 1; i < graph[node].length; i++) {
            if (graph[node][i] != 0) {
                topologicalSortDFS(i, sortedNodes);
            }
        }

        sortedNodes.push(node);
    }

}
