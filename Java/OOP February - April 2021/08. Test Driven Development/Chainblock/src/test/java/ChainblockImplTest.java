import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChainblockImplTest {
    private Chainblock chainblock;
    private Transaction transaction;

    @Before
    public void setUp() {
        this.chainblock = new ChainblockImpl();
        this.transaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Gosho", 10);
    }

    @Test
    public void testAddTransactionWithExistingIdShouldNotBeAdded() {
        Transaction transaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Gosho", 5);
        this.chainblock.add(this.transaction);
        this.chainblock.add(transaction);
        int expectedSize = 1;
        int actualSize = this.chainblock.getCount();
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testContainsMethodShouldReturnTrueForExistingTransaction() {
        this.chainblock.add(this.transaction);
        boolean actualResult = this.chainblock.contains(this.transaction);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void testCntainsMethodShouldReturnFalseForNonExistingTransaction() {
        boolean actualResult = this.chainblock.contains(this.transaction);
        Assert.assertFalse(actualResult);
    }

    @Test
    public void testContainsByIdMethodShouldReturnTrueForExistingTransaction() {
        this.chainblock.add(this.transaction);
        boolean actualResult = this.chainblock.contains(1);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void testContainsByIdMethodShouldReturnFalseForNonExistingTransaction() {
        boolean actualResult = this.chainblock.contains(25);
        Assert.assertFalse(actualResult);
    }

    @Test
    public void testChangeTransactionStatusByExistingIdShouldChangeTheStatus() {
        this.chainblock.add(transaction);
        this.generateTransaction();
        this.chainblock.changeTransactionStatus(1, TransactionStatus.UNAUTHORIZED);
        Transaction transaction = this.chainblock.getById(1);
        TransactionStatus actual = transaction.getStatus();
        TransactionStatus expected = TransactionStatus.UNAUTHORIZED;
        Assert.assertEquals(expected, actual);
        transaction = this.chainblock.getById(5);
        actual = transaction.getStatus();
        expected = TransactionStatus.FAILED;
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusOfNonExistingIdShouldThrowException() {
        this.chainblock.changeTransactionStatus(2, TransactionStatus.FAILED);

    }

    private void generateTransaction() {
        for (int i = 2; i <= 10; i++) {
            Transaction transaction = new TransactionImpl(i, TransactionStatus.FAILED, "Pesho" + i, "Gosho", i);
            this.chainblock.add(transaction);
        }
    }

}