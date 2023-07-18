import java.util.*;
import java.util.stream.Collectors;

public class E01_CableNetwork {

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

        int budget = Integer.parseInt(scanner.nextLine().split("\\s+")[1]);
        int nodes = Integer.parseInt(scanner.nextLine().split("\\s+")[1]);
        int edgesCount = Integer.parseInt(scanner.nextLine().split("\\s+")[1]);

        boolean[] connected = new boolean[nodes];

        for (int i = 0; i < edgesCount; i++) {
            String[] token = scanner.nextLine().split("\\s+");

            int from = Integer.parseInt(token[0]);
            int to = Integer.parseInt(token[1]);
            int weight = Integer.parseInt(token[2]);

            Edge edge = new Edge(from, to, weight);

            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(edge);

            if (token.length == 4) {
                connected[from] = connected[to] = true;
            }
        }

        prim(connected, budget);
        System.out.println("Budget used: " + cost);
    }

    private static boolean prim(boolean[] related, int budget) {
        PriorityQueue<Edge> edges = graph.values()
                .stream().flatMap(List::stream)
                .filter(e -> (related[e.from] && !related[e.to]) || (!related[e.from] && related[e.to]))
                .collect(Collectors.toCollection(PriorityQueue::new));

        while (!edges.isEmpty()) {
            Edge minEdge = edges.poll();
            int from = minEdge.from;
            int to = minEdge.to;
            int weight = minEdge.weight;

            int removedWeight = -1;

            if (related[from] && !related[to]) {
                related[to] = true;
                removedWeight = weight;
            } else if (!related[from] && related[to]) {
                related[from] = true;
                removedWeight = weight;
            }

            edges = graph.values()
                    .stream().flatMap(List::stream)
                    .filter(e -> (related[e.from] && !related[e.to]) || (!related[e.from] && related[e.to]))
                    .collect(Collectors.toCollection(PriorityQueue::new));

            if (removedWeight != -1 && budget - removedWeight > 0) {
                budget -= removedWeight;
                cost += removedWeight;
            } else if (budget - removedWeight < 0) {
                return false;
            }
        }

        return true;
    }
}