import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeProg {

    static class BinarySearchTree<K extends Comparable<K>> {

        static class Node<K> {
            K key;
            Node<K> left;
            Node<K> right;

            public Node(K key, Node<K> left, Node<K> right) {
                this.key = key;
                this.left = left;
                this.right = right;
            }

            public K getKey() {
                return key;
            }

            public Node<K> getLeft() {
                return left;
            }

            public Node<K> getRight() {
                return right;
            }
        }

        Node<K> root;

        public BinarySearchTree() {

        }

        private BinarySearchTree(Node<K> root) {
            this.root = root;
        }

        public List<K> getKeysSorted() {
            return getKeysSorted(this.root);
        }

        private List<K> getKeysSorted(Node<K> node) {
            if (node == null) {
                return new ArrayList<>();
            }

            List<K> sortedKeys = new ArrayList<>();
            sortedKeys.addAll(getKeysSorted(node.getLeft()));
            sortedKeys.add(node.getKey());
            sortedKeys.addAll(getKeysSorted(node.getRight()));
            return sortedKeys;
        }

        public void print() {
            print(this.root, 0);
        }

        private void print(Node<K> node, int level) {
            if (node == null) {
                return;
            }

            for (int i = 0; i < level; i++) {
                System.out.print('\t');
            }

            System.out.println(node.getKey());
            print(node.getLeft(), level + 1);
            print(node.getRight(), level + 1);
        }

        public BinarySearchTree<K> copy() {
            return new BinarySearchTree<>(copy(this.root));
        }

        private Node<K> copy(Node<K> node) {
            if (node == null) {
                return null;
            }

            Node<K> copiedNode = new Node<>(node.key, null, null);
            copiedNode.left = copy(node.getLeft());
            copiedNode.right = copy(node.getRight());

            return copiedNode;
        }

        public void insert(K key) {
            Node<K> node = new Node<>(key, null, null);
            if (root == null) {
                this.root = node;
            }

            insert(key, this.root);
        }

        private void insert(K key, Node<K> node) {
            int compareResult = key.compareTo(node.getKey());
            if (compareResult == 0) {
                return;
            }

            if (compareResult < 0) {
                if (node.getLeft() == null) {
                    node.left = new Node<>(key, null, null);
                } else {
                    insert(key, node.getLeft());
                }

            } else {
                if (node.getRight() == null) {
                    node.right = new Node<>(key, null, null);
                } else {
                    insert(key, node.getRight());
                }

            }

        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();

        binarySearchTree.insert(14);
        binarySearchTree.insert(5);
        binarySearchTree.insert(18);
        binarySearchTree.insert(16);
        binarySearchTree.insert(2);
        binarySearchTree.insert(9);
        binarySearchTree.insert(47);

        binarySearchTree.print();

        System.out.println();

        for (Integer number : binarySearchTree.getKeysSorted()) {
            System.out.print(number + " ");
        }


    }
}
