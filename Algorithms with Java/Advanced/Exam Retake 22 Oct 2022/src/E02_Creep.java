import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class E02_Creep {

    public static class Edge implements Comparable<Edge> {

        public int startNode;
        public int endNode;
        public int weight;

        public Edge(int startNode, int endNode, int weight) {
            this.startNode = startNode;
            this.endNode = endNode;
            this.weight = weight;
        }

        public int getStartNode() {
            return startNode;
        }

        public int getEndNode() {
            return endNode;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static List<Edge> edges = new ArrayList<>();
    public static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodesCount = Integer.parseInt(reader.readLine());
        int edgesCount = Integer.parseInt(reader.readLine());

        parents = new int[nodesCount];

        while (edgesCount-- > 0) {
            int[] tokens = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int from = tokens[0];
            int to = tokens[1];
            int weight = tokens[2];

            edges.add(new Edge(from, to, weight));
        }

        Collections.sort(edges);

        List<Edge> forest = new ArrayList<>();

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        while (!edges.isEmpty()) {
            Edge edge = edges.remove(0);

            int startNode = edge.getStartNode();
            int endNode = edge.getEndNode();

            int firstParent = findRoot(startNode, parents);
            int secondParent = findRoot(endNode, parents);

            if (firstParent != secondParent) {
                forest.add(edge);
                parents[firstParent] = secondParent;
            }
        }

        int totalSum = 0;

        for (Edge edge : forest) {
            System.out.printf("%d %d%n", edge.getStartNode(), edge.getEndNode());
            totalSum += edge.getWeight();
        }

        System.out.println(totalSum);
    }

    private static int findRoot(int node, int[] parents) {

        while (parents[node] != node) {
            node = parents[node];
        }

        return node;
    }
}
