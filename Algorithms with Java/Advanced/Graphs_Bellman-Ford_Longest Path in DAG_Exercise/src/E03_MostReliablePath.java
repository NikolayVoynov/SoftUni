import java.util.*;

public class E03_MostReliablePath {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine().split("\\s+")[1]);
        String[] path = scanner.nextLine().split("\\s+");
        int source = Integer.parseInt(path[1]);
        int destination = Integer.parseInt(path[3]);
        int edges = Integer.parseInt(scanner.nextLine().split("\\s+")[1]);

        int[][] graph = new int[nodes][nodes];

        for (int i = 0; i < edges; i++) {
            int[] token = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            graph[token[0]][token[1]] = token[2];
            graph[token[1]][token[0]] = token[2];
        }

        double[] distances = new double[nodes];
        boolean[] visited = new boolean[nodes];

        int[] prev = new int[nodes];

        Arrays.fill(prev,-1);

        distances[source] = 100.00;

        PriorityQueue<Integer> queue = new PriorityQueue<>((f, s) -> Double.compare(distances[s], distances[f]));

        queue.offer(source);

        while (!queue.isEmpty()) {
            int maxNode = queue.poll();
            visited[maxNode] = true;

            for (int i = 0; i < graph[maxNode].length; i++) {
                int weight = graph[maxNode][i];

                if (weight != 0 && !visited[i]) {
                    double newDistance = distances[maxNode] * weight / 100.00;

                    if (newDistance > distances[i]) {
                        distances[i] = newDistance;
                        prev[i] = maxNode;
                    }

                    queue.offer(i);
                }
            }
        }

        System.out.printf("Most reliable path reliability: %.2f%%%n", distances[destination]);

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(destination);

        int node = prev[destination];

        while (node != -1) {
            stack.push(node);
            node = prev[node];
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());

            if (stack.size() > 0) {
                System.out.print(" -> ");
            }
        }
    }

}