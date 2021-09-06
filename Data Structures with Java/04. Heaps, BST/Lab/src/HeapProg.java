import java.util.ArrayList;

public class HeapProg {

    static class Heap<K extends Comparable<K>, V> {
        static class Element<K, V> {
            K key;
            V value;

            public Element(K key, V value) {
                this.key = key;
                this.value = value;
            }

            public K getKey() {
                return key;
            }

            public V getValue() {
                return value;
            }
        }

        ArrayList<Element<K, V>> elements = new ArrayList<>();

        public int getSize() {
            return elements.size();
        }

        public boolean isEmpty() {
            return getSize() > 0;
        }

        public void push(K key, V value) {

        }

        public Element<K, V> popMax() {
            return null;
        }

    }

    public static void main(String[] args) {
        Heap<Integer, String> playersByScore = new Heap<>();
        playersByScore.push(45, "Nikolay");
        playersByScore.push(21, "Stefan");
        playersByScore.push(102, "Valentin");
        playersByScore.push(32, "Dimitar");
        playersByScore.push(52, "Emil");

        while (!playersByScore.isEmpty()) {
            Heap.Element<Integer, String> max = playersByScore.popMax();
            System.out.println(max.getValue() + " -> " + max.getKey());
        }
    }
}
