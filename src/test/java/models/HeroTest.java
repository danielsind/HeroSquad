package models;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest{
    @Test
    public void newHeroObjectGetCorrectlyCreated_true() throws Exception{
        Hero testHero = new Hero ("SuperMan",28,"SuperStrength","purpleStone");
        assertEquals(true,testHero instanceof Hero);

    }
}