package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {
    private Spaceship spaceship;

    @Before
    public void setUp() {
        this.spaceship = new Spaceship("Eleanor", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_addAndSpaceshipCapacityFull_then_throwException() {
        Spaceship spaceship = new Spaceship("Eleanor", 1);
        spaceship.add(new Astronaut("Nikolay", 20));
        spaceship.add(new Astronaut("Ivan", 30));
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_addSameAstronautTwice_then_throwException() {
        spaceship.add(new Astronaut("Nikolay", 20));
        spaceship.add(new Astronaut("Nikolay", 20));
    }


    @Test
    public void when_removeNonExistingAstronaut_then_returnFalse() {
        this.spaceship.add(new Astronaut("Nikolay", 100));
        Assert.assertFalse(this.spaceship.remove("Ivan"));
    }

    @Test
    public void when_removeExistingAstronaut_then_returnTrue() {
        this.spaceship.add(new Astronaut("Nikolay", 100));
        Assert.assertTrue(this.spaceship.remove("Nikolay"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_setCapacityLessThanZero_then_throwException() {
        new Spaceship("Eleanor", -1);
    }

    @Test(expected = NullPointerException.class)
    public void when_setNameNull_then_throwException() {
        new Spaceship(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void when_setNameEmpty_then_throwException() {
        new Spaceship("   ", 10);
    }

}
