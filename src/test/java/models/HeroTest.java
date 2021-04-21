package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    private Hero setUpNewHero() {
        return new Hero("Spider",17,"hoping","water");
    }
    @Test
    public void newHeroInstantiatesCorrectly_true() throws Exception {
        Hero testHero = setUpNewHero();
        assertTrue(testHero instanceof Hero);
    }

    @Test
    public void newHero_getsName_String() throws Exception {
        Hero testHero = setUpNewHero();
        assertEquals("Spider",testHero.getName());
    }

    @Test
    public void getAge__getsHeroAge_17() throws Exception {
        Hero testHero = setUpNewHero();
        assertEquals(17,testHero.getAge());
    }

    @Test
    public void getPower_getsHeroPower_String() throws Exception{
        Hero testHero = setUpNewHero();
        assertEquals("hoping",testHero.getPower());
    }

    @Test
    public void getWeakness_getsHeroWeakness_String() throws Exception{
        Hero testHero = setUpNewHero();
        assertEquals("water",testHero.getWeakness());
    }
}