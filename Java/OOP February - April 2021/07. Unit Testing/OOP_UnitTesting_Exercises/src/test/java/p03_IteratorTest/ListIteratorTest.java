package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    @Test(expected = OperationNotSupportedException.class)
    public void when_nullElementsPassedToConstructor_then_exceptionIsThrown() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }

    @Test
    public void when_validElementsPassedToConstructor_then_moveAndReturnCorrectBoolean() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator("power", "strength", "money");
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.move());
        Assert.assertFalse(listIterator.move());
    }


    @Test(expected = IllegalStateException.class)
    public void when_emptyListIterator_then_exceptionIsThrown() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void when_elementsInListIterator_then_printListIterator() throws OperationNotSupportedException {
        String[] elements = new String[]{"power", "strength", "money"};
        ListIterator listIterator = new ListIterator(elements);

        for (int i = 0; listIterator.hasNext(); listIterator.move(), i++) {
            Assert.assertEquals(elements[i], listIterator.print());
        }

    }

}
