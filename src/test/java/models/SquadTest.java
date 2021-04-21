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
}