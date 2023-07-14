import java.util.*;
import java.util.stream.Collectors;

public class L01_BellmanFordShortestPaths {

    public static int[][] graph;
    public static int[] distance;
    public static int[] prev;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine());
        int edges = Integer.parseInt(scanner.nextLine());

        graph = new int[nodes + 1][nodes + 1];

        for (int i = 0; i < edges; i++) {
            int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int from = tokens[0];
            int to = tokens[1];
            int weight = tokens[2];

            graph[from][to] = weight;
        }

        int source = Integer.parseInt(scanner.nextLine());
        int destination = Integer.parseInt(scanner.nextLine());

        try {
            bellmanFord(source);
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
            return;
        }

        List<Integer> path = new ArrayList<>();

        path.add(destination);

        int node = prev[destination];

        while (node != -1) {
            path.add(node);
            node = prev[node];
        }

        Collections.reverse(path);

        System.out.println(path.stream().map(String::valueOf).collect(Collectors.joining(" ")));

        System.out.println(distance[destination]);
    }

    private static void bellmanFord(int sourceNode) {
        distance = new int[graph.length];
        Arrays.fill(distance, Integer.MAX_VALUE);

        prev = new int[graph.length];
        Arrays.fill(prev, -1);

        distance[sourceNode] = 0;

        for (int i = 1; i < graph.length - 1; i++) {
            for (int r = 1; r < graph.length; r++) {
                for (int c = 1; c < graph[r].length; c++) {
                    int weight = graph[r][c];

                    if (weight != 0) {
                        int source = r;
                        int destination = c;

                        if (distance[source] != Integer.MAX_VALUE) {
                            int newValue = distance[r] + weight;

                            if (newValue < distance[destination]) {
                                distance[destination] = newValue;
                                prev[destination] = source;
                            }
                        }
                    }
                }
            }
        }

        for (int r = 1; r < graph.length; r++) {
            for (int c = 1; c < graph[r].length; c++) {
                int weight = graph[r][c];

                if (weight != 0) {
                    int source = r;
                    int destination = c;

                    if (distance[source] != Integer.MAX_VALUE) {
                        int newValue = distance[r] + weight;

                        if (newValue < distance[destination]) {
                            throw new IllegalStateException("Negative Cycle Detected");
                        }
                    }
                }
            }
        }
    }
}