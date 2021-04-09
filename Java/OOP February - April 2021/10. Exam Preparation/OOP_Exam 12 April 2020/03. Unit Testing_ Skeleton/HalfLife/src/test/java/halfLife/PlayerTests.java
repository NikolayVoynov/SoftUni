package halfLife;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayerTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Player

    @Test(expected = NullPointerException.class)
    public void testConstructor_then_throwException1() {
        Player player = new Player(null, 10);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_then_throwException2() {
        Player player = new Player("Nikolay", -10);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetList_throwException() {
        Player player = new Player("Nikolay", 100);
        player.addGun(new Gun("A1", 10));
        player.addGun(new Gun("A2", 10));
        player.addGun(new Gun("pistol", 30));

        player.getGuns().add(new Gun("pistol2", 50));
    }

    @Test
    public void when_getGun_then_returnCorrectGun() {
        Player player = new Player("Nikolay", 100);
        player.addGun(new Gun("A1", 10));
        player.addGun(new Gun("A2", 10));
        player.addGun(new Gun("pistol", 30));

        Gun expected = new Gun("pistol", 30);
        Gun actual = player.getGun("pistol");

        Assert.assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void when_getGun_then_returnNull() {
        Player player = new Player("Nikolay", 100);
        player.addGun(new Gun("A1", 10));
        player.addGun(new Gun("A2", 10));
        player.addGun(new Gun("pistol", 30));

        Gun expected = null;
        Gun actual = player.getGun("rifle");

        Assert.assertNull(actual);
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
        Gun gun1 = new Gun("G1", 20);
        player.addGun(gun1);

        Assert.assertTrue(player.removeGun(gun1));
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

        Assert.assertEquals(100, actual);
    }

    @Test(expected = NullPointerException.class)
    public void when_addGunNull_then_throwException() {
        Player player = new Player("Nikolay", 100);
        player.addGun(null);
    }

}
