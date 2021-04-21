package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Squad.clearAllSquads();
    }

    public Squad setUpNewSquad() {
        return new Squad("Fast",5,"Cause");
    }

    @Test
    public void squadInstantiatesCorrectly_true() throws Exception {
        Squad newSquad = setUpNewSquad();
        assertTrue(newSquad instanceof Squad);
    }

    @Test
    public void squadGetsNameCorrectly_String() {
        Squad newSquad = setUpNewSquad();
        assertEquals("Fast",newSquad.getName());
    }

    @Test
    public void getMaxSize_getsSquadSize_5() {
        Squad newSquad = setUpNewSquad();
        assertEquals(5,newSquad.getMaxSize());
    }

    @Test
    public void getCause_getsSquadCause_String() {
        Squad newSquad  = setUpNewSquad();
        assertEquals("Cause",newSquad.getCause());
    }

    @Test
    public void getAll_returnsAllSquads_true() {
        Squad newSquad = setUpNewSquad();
        Squad otherSquad = new Squad("",7,"");
        assertEquals(2,Squad.getAll().size());
    }

    @Test
    public void getAll_containsAllSquads_true() {
        Squad newSquad =setUpNewSquad();
        Squad otherSquad = new Squad("",8,"");
        assertTrue(Squad.getAll().contains(newSquad));
        assertTrue(Squad.getAll().contains(otherSquad));
    }

    @Test
    public void getId_squadInstantiatesWithId_true() {
        Squad newSquad = setUpNewSquad();
        assertEquals(1,newSquad.getId());

    }

    @Test
    public void findById_returnsCorrectSquad_true() {
        Squad newSquad = setUpNewSquad();
        assertEquals(1,Squad.findById(newSquad.getId()).getId());
    }

    @Test
    public void findById_returnsCorrectSquadWhenMoreThan2_true() {
        Squad newSquad = setUpNewSquad();
        Squad otherSquad = new Squad("",5,"");
        assertEquals(2, Squad.findById(otherSquad.getId()).getId());
    }
}