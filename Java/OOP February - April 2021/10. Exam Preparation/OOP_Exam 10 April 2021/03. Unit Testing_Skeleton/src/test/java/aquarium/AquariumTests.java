package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AquariumTests {
    private Aquarium aquarium;

    @Before
    public void setUp() {
        aquarium = new Aquarium("Varna", 2);
        aquarium.add(new Fish("fish1"));
        aquarium.add(new Fish("fish2"));
    }


    @Test(expected = NullPointerException.class)
    public void testConstructor_then_throwException1() {
        Aquarium aquarium = new Aquarium(null, 100);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_then_throwException2() {
        Aquarium aquarium = new Aquarium("Varna", -4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFish_then_throwException() {
        aquarium.add(new Fish("fish3"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFish_then_throwException() {
        aquarium.sellFish("riba");
    }

    @Test
    public void testSellFish_then_returnCorrect() {
        Fish actual = aquarium.sellFish("fish2");
        Fish expected = new Fish("fish2");

        Assert.assertEquals(expected.getName(), actual.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFish_then_throwException() {
        aquarium.remove("riba");
    }

    @Test
    public void getCapacity_correct() {
        Assert.assertEquals(2, aquarium.getCapacity());
    }

    @Test
    public void getCount_correct() {
        Assert.assertEquals(2, aquarium.getCount());
    }

    @Test
    public void testReport_returnCorrect() {
        String actual = aquarium.report();

        String names = "fish1, fish2";
        String expected = String.format("Fish available at %s: %s", "Varna", names);

        Assert.assertEquals(expected.length(), actual.length());
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Varna", aquarium.getName());
    }


}

