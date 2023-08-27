import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E03_BitcoinGroups {

    private static List<List<Integer>> stronglyConnectedComponents;
    private static boolean[] visited;
    private static Deque<Integer> stack = new ArrayDeque<>();
    private static List<Integer>[] reversedGraph;
    private static List<Integer>[] graph;

    private static List<Integer> resultListOfComp;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(reader.readLine());
        int edges = Integer.parseInt(reader.readLine());

        graph = new ArrayList[nodes];

        for (int i = 0; i < nodes; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges; i++) {
            int[] token = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int source = token[0];
            int dest = token[1];

            graph[source].add(dest);
        }

        visited = new boolean[graph.length];
        stronglyConnectedComponents = new ArrayList<>();

        for (int node = 0; node < graph.length; node++) {
            if (!visited[node]) {
                dfs(node);
            }
        }

        setReversedGraph();

        Arrays.fill(visited, false);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                stronglyConnectedComponents.add(new ArrayList<>());
                reversedDfs(node);
            }
        }

        int max = 0;

        for (List<Integer> stronglyConnectedComponent : stronglyConnectedComponents) {

            if (stronglyConnectedComponent.size() > max) {
                resultListOfComp = stronglyConnectedComponent;
                max = stronglyConnectedComponent.size();
            }
        }

        for (int i = 0; i < resultListOfComp.size(); i++) {
            int parent = resultListOfComp.get(i);
            List<Integer> children = graph[parent];

            for (Integer child : children) {
                if (resultListOfComp.contains(child)) {
                    System.out.println(parent + " -> " + child);
                }
            }
        }
    }

    private static void reversedDfs(int node) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;

        stronglyConnectedComponents.get(stronglyConnectedComponents.size() - 1).add(node);

        for (int child : reversedGraph[node]) {
            reversedDfs(child);
        }
    }

    @SuppressWarnings("unchecked")
    private static void setReversedGraph() {
        reversedGraph = new ArrayList[graph.length];

        for (int i = 0; i < reversedGraph.length; i++) {
            reversedGraph[i] = new ArrayList<>();
        }

        for (int node = 0; node < graph.length; node++) {
            for (int child = 0; child < graph[node].size(); child++) {
                int parent = graph[node].get(child);
                reversedGraph[parent].add(node);
            }
        }
    }

    private static void dfs(int node) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;

        for (int child : graph[node]) {
            dfs(child);
        }

        stack.push(node);
    }
}

