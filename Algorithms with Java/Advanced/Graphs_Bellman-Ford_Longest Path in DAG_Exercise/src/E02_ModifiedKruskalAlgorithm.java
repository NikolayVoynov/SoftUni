import java.util.*;
import java.util.stream.Collectors;

public class E02_ModifiedKruskalAlgorithm {

    public static Map<Integer, List<Edge>> graph = new LinkedHashMap<>();

    public static class Edge implements Comparable<Edge> {

        public int from;
        public int to;
        public int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine().split("\\s+")[1]);
        int edges = Integer.parseInt(scanner.nextLine().split("\\s+")[1]);

        for (int i = 0; i < edges; i++) {
            String[] token = scanner.nextLine().split("\\s+");

            int from = Integer.parseInt(token[0]);
            int to = Integer.parseInt(token[1]);
            int weight = Integer.parseInt(token[2]);

            Edge newEdge = new Edge(from, to, weight);

            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(newEdge);
        }

        int[] parents = new int[nodes];

        for (int i = 0; i < nodes; i++) {
            parents[i] = i;
        }

        PriorityQueue<Edge> queue = graph.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toCollection(PriorityQueue::new));

        int forestWeight = 0;

        while (!queue.isEmpty()) {
            Edge minEdge = queue.poll();

            int firstRoot = findRoot(minEdge.from, parents);
            int secondRoot = findRoot(minEdge.to, parents);

            if (firstRoot != secondRoot) {
                forestWeight += minEdge.weight;
                parents[secondRoot] = firstRoot;

                for (int i = 0; i < parents.length; i++) {
                    if (parents[i] == secondRoot) {
                        parents[i] = firstRoot;
                    }
                }
            }
        }

        System.out.println("Minimum spanning forest weight: " + forestWeight);
    }

    private static int findRoot(int node, int[] parents) {
        int root = parents[node];

        while (parents[node] != root) {
            root = parents[root];
        }

        return root;
    }
}
