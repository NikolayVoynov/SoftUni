package store;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StoreTests {
    private Store store;

    @Before
    public void setUp() {
        this.store = new Store();
        this.store.addProduct(new Product("Tire", 2, 80));
        this.store.addProduct(new Product("Oil", 2, 200));
        this.store.addProduct(new Product("Mirror", 2, 280));
    }

    @Test
    public void when_testConstructor_then_expectCorrectArrayList() {
        List<Product> actual = this.store.getProducts();
        List<Product> expected = new ArrayList<>();
        expected.add(new Product("Tire", 2, 80));
        expected.add(new Product("Oil", 2, 200));
        expected.add(new Product("Mirror", 2, 280));

        Assert.assertEquals(expected.size(), actual.size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void when_getProductsAndAdd_then_throwException() {
        this.store.getProducts().add(new Product("Seat", 2, 100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_testAddProductEqualNull_then_throwException() {
        this.store.addProduct(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_testAddProductAndProductQuantityLessThanZero_then_throwException() {
        this.store.addProduct(new Product("Engine", -4, 3000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_testBuyProductReturnNull_then_throwException() {
        this.store.buyProduct("Engine", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_testBuyProductAndProductQuantityLess_then_throwException() {
        this.store.buyProduct("Oil", 10);
    }

    @Test
    public void when_testBuyProduct_then_returnFinalPrice() {
        double expectedFinalPrice = 160.0;
        double actualFinalPrice = this.store.buyProduct("Tire", 2);

        boolean equalPrice = false;

        if (expectedFinalPrice == actualFinalPrice) {
            equalPrice = true;
        }

        Assert.assertTrue(equalPrice);
    }

    @Test
    public void when_getTheMostExpensiveProduct_then_returnCorrect() {
        Product expected = new Product("Mirror", 2, 280);
        Product actual = this.store.getTheMostExpensiveProduct();

        String expectedName = expected.getName();
        String actualName = actual.getName();
        Assert.assertEquals(expectedName, actualName);
    }


}