/*
 *  This is a game from Cisitu Corps
 *  The name of this game is Ricefield Battle
 *  @CopyRight 2016
 */
package makhlukcisitu;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.ComparisonFailure;

/**
 *
 * @author Ghifari
 */
public class BoardElementTest {
    /**
     * Test of setBoardElement method, of class BoardElement.
     */
    @Test
    public void testSetBoardElement() {
        System.out.println("setBoardElement");
        int idx = 0;
        int ID = 23;
        char element = 'R';
        BoardElement instance = new BoardElement();
        instance.setBoardElement(idx, ID, element);
        assertEquals(ID, instance.getID(idx));
        assertEquals(element, instance.getCharacter(idx));        
    }

    /**
     * Test of getID method, of class BoardElement.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        int idx = 0;
        BoardElement instance = new BoardElement();
        int expResult = -1;
        int result = instance.getID(idx);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCharacter method, of class BoardElement.
     */
    @Test
    public void testGetCharacter() {
        System.out.println("getCharacter");
        int idx = 0;
        BoardElement instance = new BoardElement();
        char expResult = 0;
        char result = instance.getCharacter(idx);
        assertEquals(expResult, result);
    }

    /**
     * Test of isConflict method, of class BoardElement.
     */
    @Test
    public void testIsConflict() {
        System.out.println("isConflict 1");
        BoardElement instance = new BoardElement();
        int expResult = 0;
        int result = instance.isConflict();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isConflict 2 method, of class BoardElement.
     */
    @Test
    public void testIsConflict2() {
        System.out.println("isConflict 2");
        BoardElement instance = new BoardElement();
        instance.setBoardElement(0, 23, 'E');
        instance.setBoardElement(1, 24, 'R');
        int expResult = 1;
        int result = instance.isConflict();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAvailable method, of class BoardElement.
     */
    @Test
    public void testIsAvailable() {
        System.out.println("isAvailable");
        BoardElement instance = new BoardElement();
        int expResult = 1;
        int result = instance.isAvailable();
        assertEquals(expResult, result);
    }

    /**
     * Test of isSlotOneAvailable method, of class BoardElement.
     */
    @Test
    public void testIsSlotOneAvailable() {
        System.out.println("isSlotOneAvailable");
        BoardElement instance = new BoardElement();
        boolean expResult = true;
        boolean result = instance.isSlotOneAvailable();
        assertEquals(expResult, result);
    }

    /**
     * Test of isSlotTwoAvailable method, of class BoardElement.
     */
    @Test
    public void testIsSlotTwoAvailable() {
        System.out.println("isSlotTwoAvailable");
        BoardElement instance = new BoardElement();
        boolean expResult = true;
        boolean result = instance.isSlotTwoAvailable();
        assertEquals(expResult, result);
    }

    /**
     * Test of clearBoardElement method, of class BoardElement.
     */
    @Test
    public void testClearBoardElement() {
        System.out.println("clearBoardElement");
        int idx = 0;
        BoardElement instance = new BoardElement();
        instance.setBoardElement(idx, 12, 'R');
        instance.clearBoardElement(idx);
        assertEquals(-1,instance.getID(idx) );
        assertEquals(0,instance.getCharacter(idx));
    }

    /**
     * Test of downgradeElement method, of class BoardElement.
     */
    @Test
    public void testDowngradeElement() {
        System.out.println("downgradeElement");
        BoardElement instance = new BoardElement();
        instance.downgradeElement();
        instance.setBoardElement(1, 12, 'A');
        
        assert('A'==instance.getCharacter(1)): "Wrong Character testDowngradeElement on test 1.\n"
                + "The right answer is A but your method answer "+instance.getCharacter(1);
        assert(12==instance.getID(1)): "Wrong ID testDowngradeElement on test 1.\n"
                + "The right answer is 12 but your method answer "+instance.getID(1);
        
        instance.downgradeElement();
        assert('A'==instance.getCharacter(0)) : "Wrong Character testDowngradeElement on test 2.\n"
                + "The right answer is A but your method answer "+instance.getCharacter(0);
        assert(12==instance.getID(0)) : "Wrong ID testDowngradeElement on test 2.\n"
                + "The right answer is 122 but your method answer "+instance.getID(0);
    }
    
}
