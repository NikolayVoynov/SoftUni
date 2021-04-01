import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private Map<String, Product> products;

    public Instock() {
        this.products = new LinkedHashMap<>();
    }


    @Override
    public Integer getCount() {
        return products.size();
    }

    @Override
    public Boolean contains(Product product) {
        return this.products.containsKey(product.getLabel());
    }

    @Override
    public void add(Product product) {
        if (!contains(product)) {
            this.products.put(product.getLabel(), product);
        }

    }

    @Override
    public void changeQuantity(String label, int quantity) {
        validateLabelExists(label);
        Product product = products.get(label);
        product.setQuantity(product.getQuantity() + quantity);

    }

    @Override
    public Product find(int index) {
        return new ArrayList<>(this.products.values()).get(index);
    }

    @Override
    public Product findByLabel(String label) {
        validateLabelExists(label);
        return products.get(label);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        return fetchFirstCountComparedBy(count, Comparator.comparing(Product::getLabel));
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return this.products.values()
                .stream()
                .filter(p -> p.getPrice() > lo && p.getPrice() <= hi)
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return products.values()
                .stream()
                .filter(p -> p.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        return fetchFirstCountComparedBy(count, Comparator.comparingDouble(Product::getPrice).reversed());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return products.values()
                .stream()
                .filter(p -> p.getQuantity() == quantity)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return products.values().iterator();
    }

    private Iterable<Product> fetchFirstCountComparedBy(int count, Comparator<Product> comparator) {
        if (count <= 0 || count > this.getCount()) {
            return new ArrayList<>();
        }

        return products.values()
                .stream()
                .sorted(comparator)
                .limit(count)
                .collect(Collectors.toList());
    }

    private void validateLabelExists(String label) {
        if (!products.containsKey(label)) {
            throw new IllegalArgumentException();
        }
    }
}
