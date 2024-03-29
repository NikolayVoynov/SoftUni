package implementations;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class TreeFactory {
    private Map<Integer, Tree<Integer>> nodesByKeys;

    public TreeFactory() {
        this.nodesByKeys = new LinkedHashMap<>();
    }

    private Tree<Integer> getRoot() {
        for (Tree<Integer> node : nodesByKeys.values()) {
            if (node.getParent() == null) {
                return node;
            }
        }

        return null;
    }

    public Tree<Integer> createNodeByKey(int key) {
        this.nodesByKeys.putIfAbsent(key, new Tree<>(key));

        return this.nodesByKeys.get(key);
    }

    public void addEdge(int parent, int child) {
        Tree<Integer> parentTree = this.createNodeByKey(parent);
        Tree<Integer> childTree = this.createNodeByKey(child);

        parentTree.addChild(childTree);
        childTree.setParent(parentTree);

    }

    public Tree<Integer> createTreeFromStrings(String[] input) {
        for (String inputLine : input) {
            int[] integerElements = Arrays.stream(inputLine.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            addEdge(integerElements[0], integerElements[1]);
        }

        return getRoot();
    }
}



