package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest {
    private CustomLinkedList<String> customLinkedList;

    @Before
    public void setUp() {
        customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("A");
    }

//    get()

    @Test(expected = IllegalArgumentException.class)
    public void when_getElementWithInvalidIndex_then_throwException() {
        customLinkedList.get(3);
    }

    @Test
    public void when_getElementInValidIndex_then_returnCorrectOne() {
        String actual = customLinkedList.get(0);
        Assert.assertEquals("A", actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_getElementInEmptyList_then_throwException() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.get(1);
    }


//    set()

    @Test(expected = IllegalArgumentException.class)
    public void when_setElementAtInvalidIndex_then_throwException() {
        customLinkedList.set(1, "B");
    }

    @Test
    public void when_validIndex_then_setCorrectElementAtIndex() {
        customLinkedList.set(0, "B");
        Assert.assertEquals("B", customLinkedList.get(0));
    }

//    add()

    @Test
    public void when_addElementToNotEmptyList_then_elementAppend() {
        customLinkedList.add("B");
        Assert.assertEquals("B", customLinkedList.get(1));
    }

//    removeAt()

    @Test(expected = IllegalArgumentException.class)
    public void when_removeAtInvalidIndex_then_throwException() {
        customLinkedList.removeAt(1);
    }

    @Test
    public void when_removeAtValidIndex_then_returnRemovedElement() {
        String actual = customLinkedList.removeAt(0);
        Assert.assertEquals("A", actual);
    }

//    remove()

    @Test
    public void when_removeElementThatDoNotExist_then_returnMinusOne() {
        int returnMessage = customLinkedList.remove("D");
        Assert.assertEquals(-1, returnMessage);
    }

    @Test
    public void when_removeElementExist_then_returnItsIndex() {
        int index = customLinkedList.remove("A");
        Assert.assertEquals(0, index);
    }
}
