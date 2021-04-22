package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static final Integer[] ELEMENTS = new Integer[]{4, 6, 19, 32, 5};
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(ELEMENTS);
    }

//    tests for constructor

    @Test
    public void when_correctElementsArePassed_then_createDatabaseInstance() throws OperationNotSupportedException {

        Assert.assertEquals(ELEMENTS.length, database.getElements().length);
        Assert.assertArrayEquals(ELEMENTS, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_elementsMoreThan16PassedToConstructor_then_exceptionIsThrown() throws OperationNotSupportedException {
        new Database(new Integer[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_elementsLessThan1PassedToConstructor_then_exceptionIsThrown() throws OperationNotSupportedException {
        new Database();
    }

//    add()

    @Test
    public void whenValidElementPassedToAdd_then_addElementOnLastPosition() throws OperationNotSupportedException {
        int element = 15;
        database.add(element);
        Integer[] databaseElements = database.getElements();
        Assert.assertEquals(ELEMENTS.length + 1, databaseElements.length);
        Assert.assertEquals(Integer.valueOf(element), databaseElements[databaseElements.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void whenInvalidElementPassedToAdd_then_exceptionIsThrown() throws OperationNotSupportedException {
        database.add(null);
    }

//    remove

    @Test
    public void when_remove_then_lastElementIsRemoved() throws OperationNotSupportedException {
        database.remove();
        Integer[] databaseElements = database.getElements();
        Assert.assertEquals(ELEMENTS.length - 1, databaseElements.length);
        Assert.assertEquals(ELEMENTS[ELEMENTS.length - 2], databaseElements[databaseElements.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_removeInEmptyElements_then_exceptionIsThrown() throws OperationNotSupportedException {
        database = new Database(new Integer[1]);
        database.remove();
        database.remove();
    }
}
