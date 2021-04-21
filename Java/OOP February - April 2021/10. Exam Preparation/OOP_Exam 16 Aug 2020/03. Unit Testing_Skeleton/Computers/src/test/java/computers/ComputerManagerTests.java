package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComputerManagerTests {
    private ComputerManager computerManager;

    @Before
    public void setUp() {
        this.computerManager = new ComputerManager();
        this.computerManager.addComputer(new Computer("Dell", "A1", 1500.0));
        this.computerManager.addComputer(new Computer("HP", "HP1", 1900.0));
        this.computerManager.addComputer(new Computer("Asus", "ASS1", 2300.0));
    }

    @Test
    public void when_testConstructor_then_returnCorrectArrayList() {
        List<Computer> expected = new ArrayList<>();
        expected.add(new Computer("Dell", "A1", 1500.0));
        expected.add(new Computer("HP", "HP1", 1900.0));
        expected.add(new Computer("Asus", "ASS1", 2300.0));

        int expectedSize = expected.size();
        int actualSize = this.computerManager.getCount();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void when_getComputersAddComputer_throwException() {
        this.computerManager.getComputers().add(new Computer("Asus", "ASS1", 2300.0));
    }

    @Test
    public void when_getComputersByManufacturer_then_returnCorrectList() {
        List<Computer> expected = this.computerManager.getComputersByManufacturer("Asus");
        List<Computer> actual = new ArrayList<>();
        actual.add(new Computer("Asus", "ASS1", 2300.0));

        Assert.assertEquals(expected.size(), actual.size());
    }

    @Test
    public void when_removeComputer_then_removeCorrectOne() {
        Computer actualRemovedComputer = this.computerManager.removeComputer("Asus", "ASS1");
        String expectedRemovedComputer = "ASS1";
        Assert.assertEquals(expectedRemovedComputer, actualRemovedComputer.getModel());
    }
}