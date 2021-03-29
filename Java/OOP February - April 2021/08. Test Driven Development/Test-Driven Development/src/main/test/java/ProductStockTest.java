import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductStockTest {

    private Instock instock;
    private Product product;

    @Before
    public void setUp() {
        instock = new Instock();
        product = new Product("default_test_label", 100, 1);
    }

    @Test
    public void testGetCountShouldReturnTwoWhenTwoProductsAdded() {
        addProducts();
        assertEquals(Integer.valueOf(10), instock.getCount());
    }

    @Test
    public void testGetCountShouldReturnZeroWhenEmpty() {
        assertEquals(Integer.valueOf(0), instock.getCount());
    }

    @Test
    public void testAddProductShouldStoreTheProductByValidatingWithContains() {
        instock.add(product);
        Boolean contains = instock.contains(product);
        assertNotNull(contains);
        assertTrue(contains);
    }

    @Test
    public void testAddShouldNotAllowedAdditionOfTheSameProductTwice() {
        instock.add(product);
        instock.add(product);
        Integer count = instock.getCount();
        assertNotNull(count);
        assertEquals(Integer.valueOf(1), count);
    }

    @Test
    public void testContainsShouldReturnFalseWhenProductIsNotPresent() {
        instock.add(product);
        Boolean contains = instock.contains(new Product("test_label", 100, 1));
        assertNotNull(contains);
        assertFalse(contains);
    }

    @Test
    public void testContainsShouldReturnFalseWhenEmpty() {
        Boolean contains = instock.contains(product);
        assertNotNull(contains);
        assertFalse(contains);
    }

    @Test
    public void testFindShouldReturnTheCorrect6thProductAdded() {
        assertFindReturnsCorrectProduct(6);
    }

    @Test
    public void testFindShouldReturnTheCorrect1stProductAdded() {
        assertFindReturnsCorrectProduct(0);
    }

    @Test
    public void testFindShouldReturnTheCorrect10thProductAdded() {
        assertFindReturnsCorrectProduct(9);
    }

    public void assertFindReturnsCorrectProduct(int index) {
        addProducts();
        assertEquals(Integer.valueOf(10), instock.getCount());
        Product product = instock.find(index);
        assertNotNull(product);
        assertEquals("test_label_" + index, product.getLabel());
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindShouldFailWhenIndexOutOfBoundsWhenNegativeIndex() {
        instock.find(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindShouldFailWhenIndexOutOfBoundsWhenIndexIsEqualToCount() {
        addProducts();
        instock.find(instock.getCount());
    }

    @Test
    public void testChangeQuantityShouldUpdateTheProductQuantityValue() {
        instock.add(product);
        int quantityBeforeUpdate = product.getQuantity();
        instock.changeQuantity(product.getLabel(), 10);
        assertEquals(quantityBeforeUpdate + 10, product.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityShouldFailForMissingProduct() {
        addProducts();
        instock.changeQuantity(product.getLabel(), 10);
    }

    private void addProducts() {
        instock.add(new Product("test_label_0", 13, 1));
        instock.add(new Product("test_label_1", 95.8, 10));
        instock.add(new Product("test_label_2", 1000, 13));
        instock.add(new Product("test_label_3", 100.50, 42));
        instock.add(new Product("test_label_4", 42.69, 69));
        instock.add(new Product("test_label_5", 10000, 32));
        instock.add(new Product("test_label_6", 0.90, 2));
        instock.add(new Product("test_label_7", 0.10, 7));
        instock.add(new Product("test_label_8", 1, 99));
        instock.add(new Product("test_label_9", 0.94, 73));
    }
}