package rpg_lab;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class HeroTest {

    @Test
    public void testHeroGainsExperienceWhenTargetIsDead() {

        Weapon weapon = Mockito.mock(Weapon.class);

        Target target = Mockito.mock(Target.class);

        Hero hero = new Hero("Thor", weapon);

        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.giveExperience()).thenReturn(13);

        hero.attack(target);

        assertEquals(13, hero.getExperience());

    }

}