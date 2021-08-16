import java.util.List;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> integers = new BinarySearchTree<>();

        integers.insert(10);
        integers.insert(5);
        integers.insert(3);
        integers.insert(7);

        integers.deleteMax();

        integers.eachInOrder(System.out::println);

    }
}
