package implementations;

import interfaces.AbstractTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Tree<E> implements AbstractTree<E> {
    private E key;
    private Tree<E> parent;
    private List<Tree<E>> children;

    public Tree(E key) {
        this.key = key;
        this.children = new ArrayList<>();
    }

    public Tree() {
        this.children = new ArrayList<>();
    }


    @Override
    public void setParent(Tree<E> parent) {
        this.parent = parent;
    }

    @Override
    public void addChild(Tree<E> child) {
        this.children.add(child);
    }

    @Override
    public Tree<E> getParent() {
        return this.parent;
    }

    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public String getAsString() {
        StringBuilder builder = new StringBuilder();

        traverseTreeWithRecurrence(builder, 0, this);

        return builder.toString().trim();
    }

    public List<Tree<E>> traverseWithBFS() {
        Deque<Tree<E>> deque = new ArrayDeque<>();

        deque.offer(this);
        int indent = 0;

        List<Tree<E>> allNodes = new ArrayList<>();

        while (!deque.isEmpty()) {
            Tree<E> tree = deque.poll();
            allNodes.add(tree);

            for (Tree<E> child : tree.children) {
                deque.offer(child);
            }
        }

        return allNodes;
    }

    private void traverseTreeWithRecurrence(StringBuilder builder, int indent, Tree<E> tree) {

        builder
                .append(this.getPadding(indent))
                .append(tree.getKey())
                .append(System.lineSeparator());

        for (Tree<E> child : tree.children) {
            traverseTreeWithRecurrence(builder, indent + 2, child);
        }
    }

    private void traverseTreeWithRecurrence(List<Tree<E>> collection, Tree<E> tree) {
        collection.add(tree);
        for (Tree<E> child : tree.children) {
            traverseTreeWithRecurrence(collection, child);
        }
    }


    private String getPadding(int size) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            builder.append(" ");
        }

        return builder.toString();
    }

    @Override
    public List<E> getLeafKeys() {
        return traverseWithBFS()
                .stream()
                .filter(tree -> tree.children.size() == 0)
                .map(Tree::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public List<E> getMiddleKeys() {
        List<Tree<E>> allNodes = new ArrayList<>();
        this.traverseTreeWithRecurrence(allNodes, this);
        return allNodes
                .stream()
                .filter(tree -> tree.parent != null && tree.children.size() > 0)
                .map(Tree::getKey)
                .collect(Collectors.toCollection(ArrayList::new));
    }

//    --- Get The Deepest Left Most Node with DFS ---

    @Override
    public Tree<E> getDeepestLeftmostNode() {
        List<Tree<E>> deepestLeftMostNote = new ArrayList<>();
        int[] maxPath =new int[1];
        int max = 0;

        deepestLeftMostNote.add(new Tree<E>());

        findDeepestNodeDFS(deepestLeftMostNote, maxPath, max, this);

        return deepestLeftMostNote.get(0);
    }

    private void findDeepestNodeDFS(List<Tree<E>> deepestLeftMostNote, int[] maxPath, int max, Tree<E> tree) {

        if (max > maxPath[0]) {
            maxPath[0] = max;
            deepestLeftMostNote.set(0, tree);
        }

        for (Tree<E> child : tree.children) {
            findDeepestNodeDFS(deepestLeftMostNote, maxPath, max + 1, child);
        }
    }


//    --- Get The Deepest Left Most Node with BFS ---

//    @Override
//    public Tree<E> getDeepestLeftmostNode() {
//        List<Tree<E>> trees = this.traverseWithBFS();
//
//        int maxPath = 0;
//
//        Tree<E> deepestLeftMostNote = null;
//
//        for (Tree<E> tree : trees) {
//            if (tree.isLeaf()) {
//                int currentPath = getStepsFromLeafToRoot(tree);
//                if (currentPath > maxPath) {
//                    maxPath = currentPath;
//                    deepestLeftMostNote = tree;
//                }
//            }
//        }
//
//        return deepestLeftMostNote;
//    }

    private int getStepsFromLeafToRoot(Tree<E> tree) {
        int counter = 0;
        Tree<E> current = tree;

        while (current.parent != null) {
            counter++;
            current = current.parent;
        }
        return counter;
    }

    private boolean isLeaf() {
        return this.parent != null && this.children.size() == 0;
    }

    @Override
    public List<E> getLongestPath() {
        return null;
    }

    @Override
    public List<List<E>> pathsWithGivenSum(int sum) {
        return null;
    }

    @Override
    public List<Tree<E>> subTreesWithGivenSum(int sum) {
        return null;
    }
}



