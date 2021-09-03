public class BinaryTreeProg {

    static class BinaryTree<K> {
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

        public void insert(Node<K> node) {
            if (root == null) {
                root = node;
            }


        }

    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.insert(new BinaryTree.Node<>(14, null, null));

    }
}
