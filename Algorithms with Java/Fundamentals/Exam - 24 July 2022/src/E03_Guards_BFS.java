import java.util.*;

public class E03_Guards_BFS {
    public static Set<Integer> notVisitedNodes = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine());
        int edges = Integer.parseInt(scanner.nextLine());

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= nodes; i++) {
            notVisitedNodes.add(i);
            graph.put(i, new HashSet<>());
        }

        for (int i = 0; i < edges; i++) {
            int[] edge = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int from = edge[0];
            int to = edge[1];

            graph.get(from).add(to);
        }

        int startNode = Integer.parseInt(scanner.nextLine());

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(startNode);


        while (!deque.isEmpty()) {
            Integer currentNode = deque.poll();

            if (!notVisitedNodes.contains(currentNode)) {
                continue;
            }

            notVisitedNodes.remove(currentNode);

            Set<Integer> toTraverse = graph.get(currentNode);
            deque.addAll(toTraverse);
        }

        notVisitedNodes.stream().sorted().forEach(node -> System.out.print(node + " "));
    }
}
