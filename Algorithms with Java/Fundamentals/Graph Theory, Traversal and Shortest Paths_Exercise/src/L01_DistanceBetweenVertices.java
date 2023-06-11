import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class L01_DistanceBetweenVertices {
    public static int[][] graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine());
        int pairs = Integer.parseInt(scanner.nextLine());

        graph = new int[nodes + 1][];

        for (int i = 1; i <= nodes; i++) {
            String[] edges = scanner.nextLine().split(":");

            if (edges.length == 1) {
                graph[i] = new int[0];
            } else {
                graph[i] = Arrays.stream(edges[1].split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
        }


        while (pairs-- > 0) {
            int[] relations = Arrays.stream(scanner.nextLine().split("-"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int source = relations[0];
            int destination = relations[1];

            System.out.printf("{%d, %d} -> ", source, destination);

           int[] path = new int[1];

            bfs(graph, source, destination, path);

            System.out.println(path[0]);
        }

    }

    private static void bfs(int[][] graph, int source, int destination, int[] path) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(source);

        boolean[] visited = new boolean[graph.length + 1];
        visited[source] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            if (node == destination) {
                return;
            }
            path[0]++;
            for (int i = 0; i < graph[node].length; i++) {
                int child = graph[node][i];
                if (!visited[child]) {
                    visited[child] = true;
                    queue.offer(child);
                }
            }
        }
    }
}
