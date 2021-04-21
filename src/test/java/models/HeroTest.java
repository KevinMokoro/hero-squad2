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
        Hero.clearAll();
    }


    public Hero setUpNewHero() {
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

    @Test
    public void getAll_returnsAllHeroes_true() throws Exception {
        Hero newHero = setUpNewHero();
        Hero otherHero = new Hero("",8,"","");
        assertEquals(2,Hero.getAll().size());
    }

    @Test
    public void getAll_containsAllHeroes_true() throws Exception{
        Hero newHero = setUpNewHero();
        Hero otherHero = new Hero("",4,"","");
        assertTrue(Hero.getAll().contains(newHero));
        assertTrue(Hero.getAll().contains(otherHero));
    }

    @Test
    public void getId_heroInstantiatesWithAnId_1() {
        Hero newHero = setUpNewHero();
        assertEquals(1,newHero.getId());
    }

    @Test
    public void findById_returnsCorrectHero_true() {
        Hero newHero = setUpNewHero();
        assertEquals(1, Hero.findById(newHero.getId()).getId());
    }

    @Test
    public void findById_returnsCorrectHeroWhenThereExistMoreThanOne_true() {
        Hero newHero = setUpNewHero();
        Hero otherHero = new Hero("",9,"","");
        assertEquals(2,Hero.findById(otherHero.getId()).getId());
    }

    @Test
    public void update_changesHeroDetails_true () {
        Hero newHero = setUpNewHero();
        String formerName = newHero.getName();
        int formerAge = newHero.getAge();
        String formerPower = newHero.getPower();
        String formerWeakness = newHero.getWeakness();
        int formerId = newHero.getId();

        newHero.update("Bat",6,"night","mask");

        assertEquals(formerId,newHero.getId());
        assertNotEquals(formerName,newHero.getName());
        assertNotEquals(formerAge,newHero.getAge());
        assertNotEquals(formerPower,newHero.getPower());
        assertNotEquals(formerWeakness,newHero.getWeakness());

    }

    @Test
    public void delete_deletesASpecificHero_true() {
        Hero newHero = setUpNewHero();
        Hero otherHero = new Hero("",8,"","");
        newHero.delete();
        assertEquals(1,Hero.getAll().size());
        assertEquals(2,Hero.getAll().get(0).getId());
    }

    @Test
    public void deleteAll_deletesAllHeroes_true() {
        Hero newHero = setUpNewHero();
        Hero otherHero = new Hero("",7,"","");

        Hero.clearAll();
        assertEquals(0,Hero.getAll().size());

    }
}