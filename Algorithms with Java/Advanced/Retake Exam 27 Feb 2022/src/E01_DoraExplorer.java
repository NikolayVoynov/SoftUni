import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E01_DoraExplorer {

    public static Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
    public static Map<Integer, Integer> distances = new HashMap<>();
    public static Set<Integer> visited = new HashSet<>();
    public static Map<Integer, Integer> prev = new HashMap<>();
    public static PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(node -> distances.get(node)));

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int edgesCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < edgesCount; i++) {
            String[] token = reader.readLine().split(", ");

            int firstCity = Integer.parseInt(token[0]);
            int secondCity = Integer.parseInt(token[1]);
            int minutes = Integer.parseInt(token[2]);

            graph.putIfAbsent(firstCity, new HashMap<>());
            graph.get(firstCity).put(secondCity, minutes);

            graph.putIfAbsent(secondCity, new HashMap<>());
            graph.get(firstCity).put(firstCity, minutes);
        }

        int minutesOnStop = Integer.parseInt(reader.readLine());

        int startCity = Integer.parseInt(reader.readLine());
        int endCity = Integer.parseInt(reader.readLine());

        for (int node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
            prev.put(node, -1);
        }

        distances.put(startCity, 0);

        findShortestPath(minutesOnStop, startCity, endCity);

        System.out.println("Total time: " + distances.get(endCity));

        List<Integer> path = new ArrayList<>();
        path.add(endCity);
        int nPrev = prev.get(endCity);

        while (nPrev != -1) {
            path.add(0, nPrev);
            nPrev = prev.get(nPrev);
        }

        path.stream().forEach(System.out::println);
    }

    private static void findShortestPath(int minutesOnStop, int startCity, int endCity) {
        queue.offer(startCity);

        while (!queue.isEmpty()) {
            int minNode = queue.poll();
            visited.add(minNode);
            Set<Integer> children = graph.get(minNode).keySet();

            for (int child : children) {
                if (!visited.contains(child)) {
                    int newDistance = distances.get(minNode) + graph.get(minNode).get(child);

                    if (child != endCity) {
                        newDistance += minutesOnStop;
                    }
                    int currentDistance = distances.get(child);

                    if (newDistance < currentDistance) {
                        distances.put(child, newDistance);
                        prev.put(child, minNode);
                    }

                    queue.offer(child);
                }
            }
        }
    }
}