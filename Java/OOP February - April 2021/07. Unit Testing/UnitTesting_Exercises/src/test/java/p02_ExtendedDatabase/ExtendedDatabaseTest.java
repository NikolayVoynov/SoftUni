package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ExtendedDatabaseTest {

    private static final Person[] PEOPLE = new Person[]{
            new Person(1, "A"),
            new Person(2, "B"),
            new Person(3, "C"),
    };
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

//    tests for constructor

    @Test
    public void when_correctElementsArePassed_then_createDatabaseInstance() throws OperationNotSupportedException {

        Assert.assertEquals(PEOPLE.length, database.getElements().length);
        Assert.assertArrayEquals(PEOPLE, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_elementsMoreThan16PassedToConstructor_then_exceptionIsThrown() throws OperationNotSupportedException {
        new Database(new Person[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_elementsLessThan1PassedToConstructor_then_exceptionIsThrown() throws OperationNotSupportedException {
        new Database();
    }

//    add()

    @Test
    public void whenValidElementPassedToAdd_then_addElementOnLastPosition() throws OperationNotSupportedException {
        Person expectedPerson = new Person(4, "D");
        database.add(expectedPerson);
        Person[] databaseElements = database.getElements();
        Assert.assertEquals(PEOPLE.length + 1, databaseElements.length);
        Person actualPerson = databaseElements[databaseElements.length - 1];
        Assert.assertEquals(expectedPerson.getId(), actualPerson.getId());
        Assert.assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void whenInvalidElementPassedToAdd_then_exceptionIsThrown() throws OperationNotSupportedException {
        database.add(null);
    }

//    remove

    @Test
    public void when_remove_then_lastElementIsRemoved() throws OperationNotSupportedException {
        database.remove();
        Person[] databaseElements = database.getElements();
        Assert.assertEquals(PEOPLE.length - 1, databaseElements.length);
        Person expectedPerson = PEOPLE[PEOPLE.length - 2];
        Person actualPerson = databaseElements[databaseElements.length - 1];
        Assert.assertEquals(expectedPerson.getId(), actualPerson.getId());
        Assert.assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_removeInEmptyElements_then_exceptionIsThrown() throws OperationNotSupportedException {
        database = new Database(new Person[1]);
        database.remove();
        database.remove();
    }

    // find username

    @Test(expected = OperationNotSupportedException.class)
    public void when_usernameIsNullPassedToFindUsername_then_exceptionIsThrown() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void when_validUsernamePassedToFindUsername_then_returnPerson() throws OperationNotSupportedException {
        Person actualPerson = database.findByUsername("B");
        Person expectedPerson = PEOPLE[1];
        Assert.assertEquals(expectedPerson.getId(), actualPerson.getId());
        Assert.assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_findUsernameOnEmptyArr_then_exceptionIsThrown() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
        database.findByUsername("A");
    }

    // find by Id

    @Test(expected = OperationNotSupportedException.class)
    public void when_findPersonByIdOnEmptyArray_then_exceptionIsThrown() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
        database.findById(2);
    }

    @Test
    public void when_validIdPassed_then_returnPerson() throws OperationNotSupportedException {
        Person actualPerson = database.findById(2);
        Person expectedPerson = PEOPLE[1];
        Assert.assertEquals(expectedPerson.getId(), actualPerson.getId());
        Assert.assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());
    }
}
