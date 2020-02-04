package models;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;
public class HeroTest{
    @Before
    public void setUp() throws Exception{
        Hero.clearAll();
    }
    @After
        public void tearDown()throws Exception{
        }
    @Test
    public void newHeroObjectGetCorrectlyCreated_true() throws Exception{
        Hero testHero = new Hero ("SuperMan",28,"SuperStrength","purpleStone");
        assertEquals(true,testHero instanceof Hero);
    }
    @Test
    public void theGettersReturnProperty_true() throws Exception{
        Hero testHero = new Hero("SuperMan",28,"SuperStrength","purpleStone");
        assertEquals("SuperMan",testHero.getName());
        assertEquals(28,testHero.getAge());
        assertEquals("SuperStrength",testHero.getAbility());
        assertEquals("purpleStone",testHero.getWeakness());
    }
}