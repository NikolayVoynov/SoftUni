import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class E03_Guards_Matrix {

    private static final Set<Integer> visitedNodes = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine());
        int edges = Integer.parseInt(scanner.nextLine());
        boolean[][] graph = new boolean[nodes + 1][nodes + 1];

        for (int i = 0; i < edges; i++) {
            int[] edge = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int from = edge[0];
            int to = edge[1];

            graph[from][to] = true;
        }

        int startNode = Integer.parseInt(scanner.nextLine());

        dfs(startNode, graph);

        for (int i = 1; i <= nodes; i++) {
            if (!visitedNodes.contains(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static void dfs(int currentNode, boolean[][] graph) {

        if (visitedNodes.contains(currentNode)) {
            return;
        }

        visitedNodes.add(currentNode);

        for (int i = 1; i < graph[currentNode].length; i++) {
            if (graph[currentNode][i]) {
                dfs(i, graph);
            }
        }

    }
}
