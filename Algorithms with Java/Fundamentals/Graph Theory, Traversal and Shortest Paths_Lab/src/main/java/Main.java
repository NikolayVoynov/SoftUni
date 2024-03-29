import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static boolean[] visited;
    //    public static List<List<Integer>> graph = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

//        for (int i = 0; i < n; i++) {
//            String str = scanner.nextLine();
//
//            if (str.trim().equals("")) {
//                graph.add(new ArrayList<>());
//            } else {
//                List<Integer> inputLine = Arrays.stream(str.split("\\s+"))
//                        .map(Integer::parseInt).collect(Collectors.toList());
//                graph.add(inputLine);
//            }
//        }
//
//        List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);
//
//        for (Deque<Integer> connectedComponent : connectedComponents) {
//            System.out.print("Connected component: ");
//            for (Integer intgr : connectedComponent) {
//                System.out.print(intgr + " ");
//            }
//            System.out.println();
//        }
    }

    private static void dfs(int vertex, List<Deque<Integer>> components, List<List<Integer>> graph, boolean[] visited) {
        if (!visited[vertex]) {
            visited[vertex] = true;

            for (int child : graph.get(vertex)) {
                dfs(child, components, graph, visited);
            }

            components.get(components.size() - 1).offer(vertex);
        }
    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
        visited = new boolean[graph.size()];
        List<Deque<Integer>> components = new ArrayList<>();

        for (int startNode = 0; startNode < graph.size(); startNode++) {
            if (!visited[startNode]) {
                components.add(new ArrayDeque<>());
                dfs(startNode, components, graph, visited);
            }
        }

        return components;
    }


    public static Collection<String> topSort(Map<String, List<String>> graph) {
//        Map<String, Integer> dependenciesCount = getDependenciesCount(graph);

        List<String> sorted = new ArrayList<>();

//        while (!graph.isEmpty()) {
//            String key = graph.keySet()
//                    .stream()
//                    .filter(k -> dependenciesCount.get(k) == 0)
//                    .findFirst()
//                    .orElse(null);
//
//            if (key == null) {
//                break;
//            }
//
//            for (String child : graph.get(key)) {
//                dependenciesCount.put(child, dependenciesCount.get(child) - 1);
//            }
//
//            sorted.add(key);
//            graph.remove(key);
//        }
//
//        if (!graph.isEmpty()) {
//            throw new IllegalArgumentException();
//        }

        Set<String> visited = new HashSet<>();
        Set<String> detectCycles = new HashSet<>();

        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            dfs(node.getKey(), visited, graph, sorted, detectCycles);
        }

        Collections.reverse(sorted);

        return sorted;
    }

    public static void dfs(String key, Set<String> visited, Map<String, List<String>> graph, List<String> sorted, Set<String> detectCycles) {
        if (detectCycles.contains(key)) {
            throw new IllegalArgumentException();
        }
        if (!visited.contains(key)) {

            visited.add(key);
            detectCycles.add(key);
            for (String child : graph.get(key)) {
                dfs(child, visited, graph, sorted, detectCycles);
            }
            detectCycles.remove(key);
            sorted.add(key);
        }
    }

//    private static Map<String, Integer> getDependenciesCount(Map<String, List<String>> graph) {
//        Map<String, Integer> dependenciesCount = new LinkedHashMap<>();
//
//        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
//            dependenciesCount.putIfAbsent(node.getKey(), 0);
//            for (String child : node.getValue()) {
//                dependenciesCount.putIfAbsent(child, 0);
//                dependenciesCount.put(child, dependenciesCount.get(child) + 1);
//            }
//        }
//
//        return dependenciesCount;
//    }
}










