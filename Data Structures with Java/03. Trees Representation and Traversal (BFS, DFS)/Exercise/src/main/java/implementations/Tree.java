package implementations;

import interfaces.AbstractTree;

import java.util.*;
import java.util.stream.Collectors;

public class Tree<E> implements AbstractTree<E> {

    private E value;
    private Tree<E> parent;
    private List<Tree<E>> children;

    public Tree(E value, Tree<E>... children) {
        this.value = value;
        this.children = this.initChildren(children);
    }

    public List<Tree<E>> initChildren(Tree<E>[] children) {
        List<Tree<E>> treeChildren = new ArrayList<>();

        for (Tree<E> child : children) {
            child.setParent(this);
            treeChildren.add(child);
        }

        return treeChildren;
    }

    private String getAsStringDFS(Tree<E> node, String indent) {
        StringBuilder result = new StringBuilder(indent + node.getKey());

        for (Tree<E> child : node.getChildren()) {
            result
                    .append(System.lineSeparator())
                    .append(getAsStringDFS(child, indent + "  "));
        }

        return result.toString();
    }

    private Tree<E> getDeepestLeftmostNodeDFS(Tree<E> node, Integer currentDepth) {
        return null;
    }

    private void getLongestPathDFS(Tree<E> node, Stack<Tree<E>> longestPath, Stack<Tree<E>> currentPath) {
        if (node.getChildren().isEmpty()) {
            if (longestPath.size() < (currentPath.size())) {
                longestPath.clear();

                for (Tree<E> currentPathNode : currentPath) {
                    longestPath.push(currentPathNode);
                }
            }
        } else {

            for (Tree<E> childNode : node.getChildren()) {
                currentPath.push(childNode);
                getLongestPathDFS(childNode, longestPath, currentPath);
                currentPath.pop();
            }
        }
    }

    private void getAllPathsWithGivenSum(Tree<E> node, List<List<E>> paths, Stack<Tree<E>> currentPath, int targetSum) {
        if (node.getChildren().isEmpty()) {
            if (currentPath.stream().mapToInt(x->(int) x.getKey()).sum() == targetSum) {
                paths.add(new ArrayList<E>(currentPath.stream().map(x->x.getKey()).collect(Collectors.toList())));
            }
        } else {
            for (Tree<E> childNode : node.getChildren()) {
                currentPath.push(childNode);
                getAllPathsWithGivenSum(childNode, paths, currentPath, targetSum);
                currentPath.pop();
            }
        }
    }

    public List<Tree<E>> getChildren() {
        return this.children;
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
        return this.value;
    }

    @Override
    public String getAsString() {
        return this.getAsStringDFS(this, "");
    }

    @Override
    public List<E> getLeafKeys() {
        Queue<Tree<E>> treeQueue = new ArrayDeque<>();
        treeQueue.offer(this);

        List<E> leafs = new ArrayList<>();

        while (!treeQueue.isEmpty()) {
            Tree<E> currentNode = treeQueue.poll();

            if (currentNode.getChildren().isEmpty()) {
                leafs.add(currentNode.getKey());
            } else {
                for (Tree<E> childNode : currentNode.getChildren()) {
                    treeQueue.offer(childNode);
                }
            }
        }

        return leafs;
    }

    @Override
    public List<E> getMiddleKeys() {
        Queue<Tree<E>> treeQueue = new ArrayDeque<>();
        treeQueue.offer(this);

        List<E> middles = new ArrayList<>();

        while (!treeQueue.isEmpty()) {
            Tree<E> currentNode = treeQueue.poll();

            if (!currentNode.getChildren().isEmpty() && currentNode.getParent() != null) {
                middles.add(currentNode.getKey());
            } else {
                for (Tree<E> childNode : currentNode.getChildren()) {
                    treeQueue.offer(childNode);
                }
            }
        }

        return middles;
    }

    @Override
    public Tree<E> getDeepestLeftmostNode() {
        return null;
    }

    @Override
    public List<E> getLongestPath() {
        Stack<Tree<E>> longestPath = new Stack<>();
        Stack<Tree<E>> currentPath = new Stack<>();

        currentPath.push(this);

        getLongestPathDFS(this, longestPath, currentPath);

        List<E> resultPath = new ArrayList<>();

        for (Tree<E> longestPathNode : longestPath) {
            resultPath.add(longestPathNode.getKey());
        }

        return resultPath;
    }

    @Override
    public List<List<E>> pathsWithGivenSum(int sum) {
        List<List<E>> paths = new ArrayList<>();
        Stack<Tree<E>> currentPath = new Stack<>();

        currentPath.push(this);
        getAllPathsWithGivenSum(this, paths, currentPath, sum);

        return paths;
    }

    @Override
    public List<Tree<E>> subTreesWithGivenSum(int sum) {
        return null;
    }
}



