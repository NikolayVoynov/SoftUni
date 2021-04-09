package computers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComputerManagerTests {

    @Test
    public void when_testConstructor_then_returnCorrectArrayList() {
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(new Computer("Dell", "A1", 1500.0));
        computerManager.addComputer(new Computer("HP", "HP1", 1900.0));
        computerManager.addComputer(new Computer("Asus", "ASS1", 2300.0));

        List<Computer> expected = new ArrayList<>();
        expected.add(new Computer("Dell", "A1", 1500.0));
        expected.add(new Computer("HP", "HP1", 1900.0));
        expected.add(new Computer("Asus", "ASS1", 2300.0));

        int expectedSize = expected.size();
        int actualSize = computerManager.getCount();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void when_getComputersAddComputer_throwException() {
        ComputerManager computerManager = new ComputerManager();
        computerManager.getComputers().add(new Computer("Asus", "ASS1", 2300.0));
    }

    @Test
    public void when_getComputersByManufacturer_then_returnCorrectList() {
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(new Computer("Dell", "A1", 1500.0));
        computerManager.addComputer(new Computer("HP", "HP1", 1900.0));
        computerManager.addComputer(new Computer("Asus", "ASS1", 2300.0));

        List<Computer> expected = computerManager.getComputersByManufacturer("Asus");
        List<Computer> actual = new ArrayList<>();
        actual.add(new Computer("Asus", "ASS1", 2300.0));

        Assert.assertEquals(expected.size(), actual.size());
    }

    @Test
    public void when_removeComputer_then_removeCorrectOne() {
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(new Computer("Dell", "A1", 1500.0));
        computerManager.addComputer(new Computer("HP", "HP1", 1900.0));
        computerManager.addComputer(new Computer("Asus", "ASS1", 2300.0));

        Computer actualRemovedComputer = computerManager.removeComputer("Asus", "ASS1");
        String expectedRemovedComputer = "ASS1";
        Assert.assertEquals(expectedRemovedComputer, actualRemovedComputer.getModel());
    }
}