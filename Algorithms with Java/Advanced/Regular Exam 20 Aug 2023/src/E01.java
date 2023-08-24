import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class E01 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int edgesCount = Integer.parseInt(reader.readLine());

        Map<String, Map<String, Integer>> graph = new HashMap<>();
        PriorityQueue<String[]> edges = new PriorityQueue<>(Comparator.comparingInt(e -> graph.get(e[0]).get(e[1])));
        Map<String, String> parents = new HashMap<>();

        for (int i = 0; i < edgesCount; i++) {
            String[] token = reader.readLine().split("\\s+");

            String from = token[0];
            String to = token[1];
            int cost = Integer.parseInt(token[2]);

            if (token.length > 3) {
                cost += Integer.parseInt(token[3]);
            }

            graph.putIfAbsent(from, new HashMap<>());
            graph.get(from).put(to, cost);

            parents.put(from, from);
            parents.put(to, to);

            edges.offer(new String[]{from, to});
        }

        int totalCost = 0;

        while (!edges.isEmpty()) {
            String[] edge = edges.poll();

            String source = edge[0];
            String destin = edge[1];

            String firstRoot = findRoot(source, parents);
            String secondRoot = findRoot(destin, parents);

            if (!firstRoot.equals(secondRoot)) {
                totalCost += graph.get(source).get(destin);
                parents.put(secondRoot, firstRoot);
            }
        }

        System.out.println("Total cost of building highways: " + totalCost);
    }

    private static String findRoot(String node, Map<String, String> parents) {

        while (!parents.get(node).equals(node)) {
            node = parents.get(node);
        }

        return node;
    }
}