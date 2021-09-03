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

        public void insert(K key) {
            Node<K> node = new Node<>(key, null, null);
            if (root == null) {
                root = node;
            }
        }

        public BinaryTree(Node<K> root) {
            this.root = root;
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
    }

    public static void main(String[] args) {

        BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(
                14,
                new BinaryTree.Node<>(12,
                        new BinaryTree.Node<>(5, null, null),
                        null),
                new BinaryTree.Node<>(13,
                        new BinaryTree.Node<>(28, null, null),
                        new BinaryTree.Node<>(7, null, null))
        );

        BinaryTree<Integer> tree = new BinaryTree<>(root);

        tree.print();

    }
}
