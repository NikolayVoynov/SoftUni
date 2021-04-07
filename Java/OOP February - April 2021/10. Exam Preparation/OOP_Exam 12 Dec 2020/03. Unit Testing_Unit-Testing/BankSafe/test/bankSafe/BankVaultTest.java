package bankSafe;


import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class BankVaultTest {

    @Test(expected = UnsupportedOperationException.class)
    public void when_getVaultCellsAndPut_then_throwException() {
        BankVault bankVault = new BankVault();
        bankVault.getVaultCells().put("Nikolay", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_addItemAndVaultCellsNotContainCell_then_throwException() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        bankVault.addItem("H2", null);
        Assert.assertFalse(bankVault.getVaultCells().containsKey("H2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_addItemAndCellIsTaken_then_throwException() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        bankVault.addItem("H2", null);
        bankVault.addItem("H2", null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_addItemAndCheckThatItemAlreadyExist() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        bankVault.addItem("A1", null);
        Assert.assertTrue(bankVault.getVaultCells().containsValue(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWrong() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();

        Item item = new Item("Kamen", "strong");

        bankVault.addItem("A1", item);
        bankVault.addItem("A1", item);
    }


    @Test(expected = IllegalArgumentException.class)
    public void when_removeItemWhichCellDoesNotExist_then_thrownException() {
        BankVault bankVault = new BankVault();
        bankVault.removeItem("Nikolay", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_removeItemWhichItemDoesNotExist_then_throwException() {
        BankVault bankVault = new BankVault();
        Item item = new Item("Nikolay", "91");
        bankVault.removeItem("A1", item);
    }

    @Test
    public void when_removeItem_then_returnProperMessage() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("Nikolay", "1991");
        bankVault.addItem("A1", item);

        String expected = String.format("Remove item:%s successfully!", item.getItemId());
        String actual = bankVault.removeItem("A1", item);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveItemWorksProperly() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("Gosho", "OPa");
        bankVault.addItem("A1", item);

        bankVault.removeItem("A1", item);

        Assert.assertNull(bankVault.getVaultCells().get("A1"));
    }


}