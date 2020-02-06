package models;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class SquadTest {

    @Before
    public void setUp() {
    }
    @After
    public void tearDown() {
        Squad.clearSquads();
    }
    @Test
    public void checkForInstanceOfASquad_with_mission_SquadName()throws Exception{
        Squad testSquad = new Squad("Avengers","Kill Thanos",1);

        assertEquals(true,testSquad instanceof Squad);
    }
    @Test
    public void getSize_returnsInteger_1() {
        Squad testSquad = new Squad("Avengers","Kill Thanos",1);

        assertEquals(1,testSquad.getSize());
    }
    @Test
    public void getCause_returnsString_shoot() {
        Squad testSquad = new Squad("Avengers","Kill Thanos",1);

        assertEquals("Kill Thanos",testSquad.getMission());
        assertEquals("Avengers",testSquad.getName());
    }
    @Test
    public void getId_assignsUniqueId_1() {
        Squad testSquad = new Squad("Avengers","Kill Thanos",1);

        assertEquals(1,testSquad.getId());
    }
    @Test
    public void getSquads_returnsAllSquadsCreated_ArrayList() {
        Squad testSquad = new Squad("Avengers","Kill Thanos",1);
        assertTrue(Squad.getSquads().contains(testSquad));
    }
    @Test
    public void getHeroes_returnsListOfHeroes_List() {
        Squad testSquad = new Squad("Avengers","Kill Thanos",1);
        Hero testHero = new Hero("SuperMan",1,"SuperStregnth","purplerStone",testSquad.getId());
        testSquad.addHero(testHero);
        List<Hero> expected = new ArrayList<Hero>();
        expected.add(testHero);
        assertEquals(expected.get(0),testSquad.getHeroes().get(0));
    }
    @Test
    public void addHero_AddsHeroes_true() {
        Squad testSquad = new Squad("Avengers","Kill Thanos",1);
        Hero testHero = new Hero("SuperMan", 12, "SuperStregnth", "purplestone",testSquad.getId());
        testSquad.addHero(testHero);
        assertTrue(testSquad.getHeroes().contains(testHero));
    }
    @Test
    public void addHero_doesNotAddHeroesOnceSquadSizeIsExceeded_false() {
        Squad testSquad = new Squad("Avengers","Kill Thanos",1);
        Hero testHero = new Hero("Superman", 12, "SuperStrength", "purplestone",testSquad.getId());
        Hero testHero2 = new Hero("Superman", 12, "SuperStrength", "purplestone",testSquad.getId());

        testSquad.addHero(testHero);
        testSquad.addHero(testHero2);
        assertTrue(testSquad.getHeroes().contains(testHero));
        assertFalse(testSquad.getHeroes().contains(testHero2));
    }
    @Test
    public void removeHero_removesSingleInstanceOfHero_false() {
        Squad testSquad = new Squad("Avengers","Kill Thanos",1);
        Hero testHero = new Hero("Superman", 12, "SuperStrength", "purplestone",testSquad.getId());
        Hero testHero2 = new Hero("Superman", 12, "SuperStrength", "purplestone",testSquad.getId());
        testSquad.addHero(testHero);
        testSquad.addHero(testHero2);
        testSquad.removeHero(testHero2);
        assertFalse(testSquad.getHeroes().contains(testHero2));
    }
    @Test
    public void removeHeroes_removesSingleInstanceOfHero_false() {
        Squad testSquad = new Squad("Avengers","Kill Thanos",1);
        Hero testHero = new Hero("Superman", 12, "SuperStrength", "purplestone",testSquad.getId());
        Hero testHero2 = new Hero("Superman", 12, "SuperStrength", "purplestone",testSquad.getId());
        testSquad.addHero(testHero);
        testSquad.addHero(testHero2);
        testSquad.removeHeroes();
        assertFalse(testSquad.getHeroes().contains(testHero));
        assertFalse(testSquad.getHeroes().contains(testHero2));
    }
    @Test
    public void find_ReturnsAnInstanceOfSquad_Squad() {
        Squad testSquad = new Squad("Avengers","Kill Thanos",1);
        assertEquals(testSquad,Squad.find(1));
    }
    @Test
    public void find_returnsCorrectHeroWhenMoreThanOneExists_Hero() {
        Squad testSquad = new Squad("Avengers","Kill Thanos",2);
        Squad testSquad2 = new Squad("Wasafi","Tetema",1);
        assertEquals(testSquad2,Squad.find(2));
    }

}