import java.util.Iterator;
import java.util.LinkedList;

public class HashTable<K, V> implements Iterable<KeyValue<K, V>> {
    private final static int INITIAL_CAPACITY = 16;
    private final static double LOAD_FACTOR = 0.80d;

    private LinkedList<KeyValue<K, V>>[] slots;

    private int count;
    private int capacity;

    public HashTable() {
        this(INITIAL_CAPACITY);
    }

    public HashTable(int capacity) {
        this.slots = new LinkedList[capacity];
        this.count = 0;
        this.capacity = capacity;
    }

    public void add(K key, V value) {
        throw new UnsupportedOperationException();
    }

    private int findSlotNumber(K key) {
        throw new UnsupportedOperationException();
    }

    private void growIfNeeded() {
        throw new UnsupportedOperationException();
    }

    private void grow() {
        throw new UnsupportedOperationException();
    }

    public int size() {
        throw new UnsupportedOperationException();
    }

    public int capacity() {
        throw new UnsupportedOperationException();
    }

    public boolean addOrReplace(K key, V value) {
        throw new UnsupportedOperationException();
    }

    public V get(K key) {
        throw new UnsupportedOperationException();
    }

    public KeyValue<K, V> find(K key) {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(K key) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(K key) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Iterable<K> keys() {
        throw new UnsupportedOperationException();
    }

    public Iterable<V> values() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<KeyValue<K, V>> iterator() {
        throw new UnsupportedOperationException();
    }
}
