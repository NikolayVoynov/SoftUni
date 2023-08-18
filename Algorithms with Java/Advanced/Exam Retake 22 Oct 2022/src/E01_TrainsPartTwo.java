import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E01_TrainsPartTwo {

    public static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(reader.readLine());
        int edges = Integer.parseInt(reader.readLine());

        int[] inputInfo = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int source = inputInfo[0];
        int destination = inputInfo[1];

        graph = new int[nodes][nodes];

        while (edges-- > 0) {
            int[] tokens = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int from = tokens[0];
            int to = tokens[1];
            int distance = tokens[2];

            graph[from][to] = distance;
            graph[to][from] = distance;
        }

        int[] distances = new int[nodes];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        int[] prev = new int[nodes];
        Arrays.fill(prev, -1);

        boolean[] visited = new boolean[nodes];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> distances[node]));

        priorityQueue.add(source);

        while (!priorityQueue.isEmpty()) {
            int parent = priorityQueue.poll();
            visited[parent] = true;
            int[] children = graph[parent];

            for (int childNode = 0; childNode < children.length; childNode++) {
                if (children[childNode] != 0 && !visited[childNode]) {
                    priorityQueue.add(childNode);

                    int newDistance = distances[parent] + graph[parent][childNode];

                    if (newDistance < distances[childNode]) {
                        distances[childNode] = newDistance;
                        prev[childNode] = parent;
                    }
                }
            }
        }

        List<Integer> path = new ArrayList<>();

        path.add(destination);
        int prevNode = prev[destination];

        while (prevNode != -1) {
            path.add(prevNode);
            prevNode = prev[prevNode];
        }

        Collections.reverse(path);

        int minDistance = 0;
        StringBuilder minPath = new StringBuilder();

        for (int i = 1; i < path.size(); i++) {
            minDistance += graph[path.get(i - 1)][path.get(i)];
        }

        for (Integer node : path) {
            minPath.append(node).append(" ");
        }

        System.out.println(minPath.toString().trim());
        System.out.println(minDistance);
    }
}