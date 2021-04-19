package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayerTests {
    private Player player;

    @Before
    public void setUp() {
        player = new Player("Nikolay", 100);
        player.addGun(new Gun("A1", 10));
        player.addGun(new Gun("A2", 10));
        player.addGun(new Gun("pistol", 30));
    }

    @Test(expected = NullPointerException.class)
    public void when_testConstructorWithNull_then_throwException1() {
        player = new Player(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_testConstructorWithNegative_then_throwException2() {
        player = new Player("Nikolay", -10);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void when_GetListAndAdd_then_throwException() {
        player.getGuns().add(new Gun("pistol2", 50));
    }

    @Test
    public void when_getGun_then_returnCorrectGun() {
        Gun expected = new Gun("pistol", 30);
        Gun actual = player.getGun("pistol");
        Assert.assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void when_getGun_then_returnNull() {
        Gun gun = player.getGun("rifle");
        Assert.assertNull(gun);
    }


    @Test(expected = IllegalStateException.class)
    public void when_takeDamage_then_throwException() {
        Player player = new Player("Ivan", 5);
        player.takeDamage(3);
        player.takeDamage(2);
        player.takeDamage(5);
    }

    @Test
    public void when_takeDamage_then_reduceHealth() {
        Player player = new Player("Ivan", 5);
        player.takeDamage(3);
        int actual = player.getHealth();
        Assert.assertEquals(2, actual);
    }


    @Test
    public void when_removeExistingGun_then_returnTrue() {
        Player player = new Player("Nikolay", 100);
        Gun gun = new Gun("G1", 20);
        player.addGun(gun);
        Assert.assertTrue(player.removeGun(gun));
    }

    @Test
    public void testGetUsername() {
        Player player = new Player("Nikolay", 100);
        String actual = player.getUsername();
        Assert.assertEquals("Nikolay", actual);
    }

    @Test
    public void testGetHealth() {
        Player player = new Player("Nikolay", 100);
        int actual = player.getHealth();
        int expected = 100;
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void when_addGunNull_then_throwException() {
        player.addGun(null);
    }

}
