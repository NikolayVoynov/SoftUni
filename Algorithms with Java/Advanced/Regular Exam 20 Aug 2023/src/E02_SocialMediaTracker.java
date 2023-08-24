import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E02_SocialMediaTracker {

    public static Map<Character, Map<Character, Integer>> graph = new HashMap<>();
    public static Set<Character> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int edgesCount = Integer.parseInt(reader.readLine());

        Map<Character, int[]> distancesAndHops = new HashMap<>();

        for (int i = 0; i < edgesCount; i++) {
            String[] token = reader.readLine().split("\\s+");

            Character userA = token[0].charAt(0);
            Character userB = token[1].charAt(0);

            int influence = Integer.parseInt(token[2]);

            graph.putIfAbsent(userA, new HashMap<>());
            graph.get(userA).put(userB, influence);

            distancesAndHops.put(userA, new int[]{Integer.MIN_VALUE, 0});
            distancesAndHops.put(userB, new int[]{Integer.MIN_VALUE, 0});
        }

        Character startUser = reader.readLine().charAt(0);
        Character destinUser = reader.readLine().charAt(0);

        distancesAndHops.get(startUser)[0] = 0;

        ArrayDeque<Character> stackNodesTopologicalSorted = new ArrayDeque<>();
        for (Character node : graph.keySet()) {
            topologicalSort(node, stackNodesTopologicalSorted);
        }

        while (!stackNodesTopologicalSorted.isEmpty()){
            Character fromNode = stackNodesTopologicalSorted.pop();
            Map<Character, Integer> edgesOfFromNode = graph.get(fromNode);

            if (edgesOfFromNode != null) {
                for (Character child : edgesOfFromNode.keySet()) {
                    int influence = edgesOfFromNode.get(child);
                    int newDistance = distancesAndHops.get(fromNode)[0] + influence;
                    int currentDistance = distancesAndHops.get(child)[0];

                    int newHops = distancesAndHops.get(fromNode)[1] + 1;
                    int currentHops = distancesAndHops.get(child)[1];

                    if (newDistance > currentDistance || (newDistance == currentDistance && newHops < currentHops)) {
                        distancesAndHops.get(child)[0] = newDistance;
                        distancesAndHops.get(child)[1] = newHops;
                    }
                }
            }
        }

        System.out.printf("(%d, %d)%n", distancesAndHops.get(destinUser)[0], distancesAndHops.get(destinUser)[1]);
    }

    private static void topologicalSort(Character node, ArrayDeque<Character> stackNodesTopologicalSorted) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);

        Map<Character, Integer> edgesOfNode = graph.get(node);

        if (edgesOfNode != null) {
            for (Character child : edgesOfNode.keySet()) {
                topologicalSort(child, stackNodesTopologicalSorted);
            }

            stackNodesTopologicalSorted.push(node);
        }

    }
}
