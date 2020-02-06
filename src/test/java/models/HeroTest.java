package models;
import org.junit.After;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class HeroTest{
    @After
        public void tearDown(){
        Hero.clearAll();
    }
    @Test
    public void newHeroObjectGetCorrectlyCreated_true() throws Exception{
        Squad testSquad = new Squad("Avengers", "Kill Thanos", 1);
        Hero testHero = new  Hero("SuperMan",28,"SuperStrength","purpleStone", testSquad.getId());
        assertEquals(true,testHero instanceof Hero);
    }
    @Test
    public void theGettersReturnProperty_true() throws Exception{
        Squad testSquad = new Squad("Avengers", "Kill Thanos", 1);
        Hero testHero = new  Hero("SuperMan",28,"SuperStrength","purpleStone", testSquad.getId());
        Squad testSquad1 = new Squad("Avengers", "Kill Thanos", 1);
        assertEquals("SuperMan",testHero.getName());
        assertEquals(28,testHero.getAge());
        assertEquals("SuperStrength",testHero.getAbility());
        assertEquals("purpleStone",testHero.getWeakness());
    }
    @Test
    public void testForReturnId_getMethod()throws Exception{
        Squad testSquad = new Squad("Avengers", "Kill Thanos", 1);
        Hero testHero = new  Hero("SuperMan",28,"SuperStrength","purpleStone", testSquad.getId());
        Hero.clearAll();
        assertEquals(1,testHero.getId());
    }
    @Test
    public void getIdOfEachSquad_toEachHero(){
        Squad testSquad = new Squad("Avengers","Kill All",1);
        Hero testHero = new Hero("Jonah",12,"Eating","Girls",testSquad.getId());
        testSquad.addHero(testHero);
        assertEquals(testSquad.getId(),testHero.getSquadId());
    }

    @Test
    public void checkFor_getInstancesand_ifAllherosContainAllHeros() throws Exception {
        Squad testSquad = new Squad("Avengers", "Kill Thanos", 1);
        Hero testHero = new  Hero("SuperMan",28,"SuperStrength","purpleStone", testSquad.getId());
        assertEquals(1,Hero.getInstances().size());
        assertTrue(Hero.getInstances().contains(testHero));
    }
    @Test
    public void check_ifHeroPosted_is_instantiatedasFalse()throws Exception{
        Squad testSquad = new Squad("Avengers", "Kill Thanos", 1);
        Hero testHero = new  Hero("SuperMan",28,"SuperStrength","purpleStone", testSquad.getId());
        assertEquals(false,testHero.getCreated());
    }
    @Test
    public void getCreatedatWhatTime_InstantiatesWithCurrentTime()throws Exception{
        Squad testSquad = new Squad("Avengers", "Kill Thanos", 1);
        Hero testHero = new  Hero("SuperMan",28,"SuperStrength","purpleStone", testSquad.getId());
        assertEquals(LocalDateTime.now().getDayOfWeek(),testHero.getCreatedAt().getDayOfWeek());
    }
    @Test
    public void find_returning_InstancesOfHeroes(){
        Squad testSquad = new Squad("Avengers", "Kill Thanos", 1);
        Hero testHero = new  Hero("SuperMan",28,"SuperStrength","purpleStone", testSquad.getId());
        List<Hero> expectedOutPut = new ArrayList<>();
        expectedOutPut.add(testHero);
        assertEquals(expectedOutPut.get(0),Hero.getInstances().get(0));
    }
    @Test
    public void findThatReturnsCorrectWhenOneHeroExist() throws Exception{
        Squad testSquad = new Squad("Avengers", "Kill Thanos", 1);
        Hero testHero = new  Hero("SuperMan",28,"SuperStrength","purpleStone", testSquad.getId());
        assertEquals(testHero,Hero.findById(1));
    }
}