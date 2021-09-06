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
            return getSize() == 0;
        }

        public void push(K key, V value) {
            Element<K, V> element = new Element<>(key, value);
            elements.add(element);

            swim(elements.size() - 1);
        }

        private boolean isValidIndex(int index) {
            return index >= 0 && index < elements.size();
        }

        private void swim(int index) {
            if (!isValidIndex(index)) {
                return;
            }

            if (index == 0) {
                return;
            }

            int parentIndex = (index - 1) / 2;

            if (isLessThan(parentIndex, index)) {
                swap(index, parentIndex);
                swim(parentIndex);
            }

        }

        private void swap(int index, int parentIndex) {
            Element<K, V> oldValue = elements.get(index);
            elements.set(index, elements.get(parentIndex));
            elements.set(parentIndex, oldValue);
        }

        private boolean isLessThan(int index, int parentIndex) {
            return elements.get(index).getKey().compareTo(elements.get(parentIndex).getKey()) < 0;
        }

        public Element<K, V> popMax() {
            Element<K, V> max = elements.get(0);
            elements.set(0, elements.get(elements.size() - 1));
            elements.remove(elements.size() - 1);

            sink(0);
            return max;
        }

        private void sink(int index) {
            int indexFirstChild = index * 2 + 1;
            int indexSecondChild = index * 2 + 2;

            if (!isValidIndex(indexFirstChild)) {
                return;
            }

            int maxIndex;
            if (isValidIndex(indexSecondChild) && isLessThan(indexFirstChild,indexSecondChild)) {
                maxIndex = indexSecondChild;
            } else {
                maxIndex = indexFirstChild;
            }

            if (isLessThan(index, maxIndex)) {
                swap(index, maxIndex);
                sink(maxIndex);
            }

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
