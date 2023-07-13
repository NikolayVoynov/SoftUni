import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KruskalAlgorithm {

    public static List<Edge> kruskal(int numberOfVertices, List<Edge> edges) {
//        PriorityQueue<Edge> orderedEdges = new PriorityQueue<>(edges);

        Collections.sort(edges);

        List<Edge> forest = new ArrayList<>();

        int[] parents = new int[numberOfVertices];

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

        return forest;
    }

    public static int findRoot(int node, int[] parents) {

        while (parents[node] != node) {
            node = parents[node];
        }

        return node;
    }
}
