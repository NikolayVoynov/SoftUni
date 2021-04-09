package store;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StoreTests {

    @Test
    public void when_testConstructor_then_expectCorrectArrayList() {
        Store store = new Store();
        store.addProduct(new Product("Tire", 1, 80));
        store.addProduct(new Product("Oil", 2, 200));
        store.addProduct(new Product("Mirror", 2, 280));

        List<Product> actual = store.getProducts();

        List<Product> expected = new ArrayList<>();
        expected.add(new Product("Tire", 1, 80));
        expected.add(new Product("Oil", 2, 200));
        expected.add(new Product("Mirror", 2, 280));

        Assert.assertEquals(expected.size(), store.getCount());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void when_getProductsAndAdd_then_throwException() {
        Store store = new Store();
        store.getProducts().add(new Product("Seat", 2, 100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_testAddProductEqualNull_then_throwException() {
        Store store = new Store();
        store.addProduct(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_testAddProductAndProductQuantityLessThanZero_then_throwException() {
        Store store = new Store();
        store.addProduct(new Product("Engine", -4, 3000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_testBuyProductReturnNull_then_throwException() {
        Store store = new Store();
        store.addProduct(new Product("Tire", 1, 80));
        store.addProduct(new Product("Oil", 2, 200));

        store.buyProduct("Engine", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_testBuyProductAndProductQuantityLess_then_throwException() {
        Store store = new Store();
        store.addProduct(new Product("Tire", 1, 80));
        store.addProduct(new Product("Oil", 2, 200));

        store.buyProduct("Oil", 10);
    }

    @Test
    public void when_testBuyProduct_then_returnFinalPrice() {
        Store store = new Store();
        store.addProduct(new Product("Tire", 4, 80.0));
        store.addProduct(new Product("Oil", 2, 200.0));

        double expectedFinalPrice = 160.0;
        double actualFinalPrice = store.buyProduct("Tire", 2);

        boolean equalPrice = false;

        if (expectedFinalPrice == actualFinalPrice) {
            equalPrice = true;
        }

        Assert.assertTrue(equalPrice);
    }

    @Test
    public void when_getTheMostExpensiveProduct_then_returnCorrect() {
        Store store = new Store();
        store.addProduct(new Product("Tire", 1, 80));
        store.addProduct(new Product("Oil", 2, 200));

        Product expected = new Product("Oil", 2, 200);
        Product actual = store.getTheMostExpensiveProduct();

        String expectedName = expected.getName();
        String actualName = actual.getName();
        Assert.assertEquals(expectedName,actualName);
    }


}