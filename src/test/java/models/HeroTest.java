package models;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;
public class HeroTest{
    public Hero setupNewHero(){
        return new Hero("SuperMan",28,"SuperStrength","purpleStone");
    }
    @After
        public void tearDown(){
        Hero.clearAll();
    }
    Hero testHero = new Hero("SuperMan",28,"SuperStrength","purpleStone");
    @Test
    public void newHeroObjectGetCorrectlyCreated_true() throws Exception{
        assertEquals(true,testHero instanceof Hero);
    }
    @Test
    public void theGettersReturnProperty_true() throws Exception{
        assertEquals("SuperMan",testHero.getName());
        assertEquals(28,testHero.getAge());
        assertEquals("SuperStrength",testHero.getAbility());
        assertEquals("purpleStone",testHero.getWeakness());
    }
    @Test
    public void testForReturnId_getMethod()throws Exception{
        Hero.clearAll();
        assertEquals(1,testHero.getId());
    }

    @Test
    public void checkFor_getInstancesand_ifAllherosContainAllHeros() throws Exception {
        assertEquals(1,Hero.getInstances().size());
        assertTrue(Hero.getInstances().contains(testHero));
    }
    @Test
    public void check_ifHeroPosted_is_instantiatedasFalse()throws Exception{
        assertEquals(false,testHero.getCreated());
    }
    @Test
    public void getCreatedatWhatTime_InstantiatesWithCurrentTime()throws Exception{
        Hero testHero = setupNewHero();
        assertEquals(LocalDateTime.now().getDayOfWeek(),testHero.getCreatedAt().getDayOfWeek());
    }
}