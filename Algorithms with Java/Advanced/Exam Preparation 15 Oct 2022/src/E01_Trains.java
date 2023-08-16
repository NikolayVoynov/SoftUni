import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class E01_Trains {

    public static int[][] graph;
    public static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(reader.readLine());
        int edges = Integer.parseInt(reader.readLine());

        int[] inputVar = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int source = inputVar[0];
        int destination = inputVar[1];

        graph = new int[nodes][nodes];
        parents = new int[nodes];

        while (edges-- > 0) {
            int[] tokens = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int from = tokens[0];
            int to = tokens[1];
            int capacity = tokens[2];

            graph[from][to] = capacity;
        }

        int maxFlow = 0;

        while (bfs(source, destination)) {
            // Find min flow in path
            int minFlow = Integer.MAX_VALUE;
            int node = destination;

            while (node != source) {
                minFlow = Math.min(minFlow, graph[parents[node]][node]);
                node = parents[node];
            }

            // add min flow to max flow
            maxFlow += minFlow;

            // adjust graph

            node = destination;

            while (node != source) {
                graph[parents[node]][node] -= minFlow;
                graph[node][parents[node]] += minFlow;
                node = parents[node];
            }
        }

        System.out.println(maxFlow);
    }

    private static boolean bfs(int source, int destination) {
        boolean[] visited = new boolean[graph.length];
        Arrays.fill(parents, -1);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        visited[source] = true;
        queue.offer(source);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int child = 0; child < graph[node].length; child++) {
                if (!visited[child] && graph[node][child] > 0) {
                    visited[child] = true;
                    queue.offer(child);
                    parents[child] = node;
                }
            }
        }

        return visited[destination];
    }
}