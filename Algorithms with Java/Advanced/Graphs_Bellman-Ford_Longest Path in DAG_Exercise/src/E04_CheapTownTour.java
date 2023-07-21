import java.util.*;
import java.util.stream.Collectors;

public class E04_CheapTownTour {

    public static Map<Integer, List<Edge>> graph = new LinkedHashMap<>();
    public static int cost = 0;

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

        int nodes = Integer.parseInt(scanner.nextLine());
        int edgesCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < edgesCount; i++) {
            String[] token = scanner.nextLine().split(" - ");

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

        PriorityQueue<Edge> edges = graph
                .values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toCollection(PriorityQueue::new));


        while (!edges.isEmpty()) {
            Edge minEdge = edges.poll();

            int firstRoot = findRoot(minEdge.from, parents);
            int secondRoot = findRoot(minEdge.to, parents);

            if (firstRoot != secondRoot) {
                cost += minEdge.weight;
                parents[secondRoot] = firstRoot;

                for (int i = 0; i < parents.length; i++) {
                    if (parents[i] == secondRoot) {
                        parents[i] = firstRoot;
                    }
                }
            }
        }

        System.out.println("Total cost: " + cost);
    }

    private static int findRoot(int node, int[] parents) {
        int root = parents[node];

        while (parents[node] != root) {
            root = parents[root];
        }

        return root;
    }

}
