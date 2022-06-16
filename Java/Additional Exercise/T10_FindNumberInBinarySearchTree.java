import java.util.Scanner;

public class T10_FindNumberInBinarySearchTree {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static boolean ifNodeExists(Node node, int key) {

        if (node == null) {
            return false;
        } else if (node.data == key) {
            return true;
        } else if (node.data > key) {
            return ifNodeExists(node.left, key);
        } else {
            return ifNodeExists(node.right, key);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Node root = new Node(20);
        root.left = new Node(14);
        root.left.left = new Node(7);
        root.left.right = new Node(17);
        root.right = new Node(33);
        root.right.left = new Node(31);
        root.right.right = new Node(45);

        System.out.println("Enter search number:");
        int key = Integer.parseInt(scanner.nextLine());

        if (ifNodeExists(root, key)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}
