/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Ghifari
 */
public class BoardElementTest {
    /**
     * constant value of twelve.
     */
    private static final int TWELVE = 12;
    /**
     * constant value of twenty three.
     */
    private static final int TWENTYTHREE = 23;
    /**
     * constant value of twenty four.
     */
    private static final int TWENTYFOUR = 24;
    /**
     * constant value of one.
     */
    private static final int ONE = 1;
    /**
     * constant value of zero.
     */
    private static final int ZERO = 0;
    /**
     * Test of setBoardElement method, of class BoardElement.
     */
    @Test
    public final void testSetBoardElement() {
        System.out.println("setBoardElement");
        int idx = 0;
        char element = 'R';
        BoardElement instance = new BoardElement();
        instance.setBoardElement(idx, TWENTYTHREE, element);
        assertEquals(TWENTYTHREE, instance.getID(idx));
        assertEquals(element, instance.getCharacter(idx));
    }

    /**
     * Test of getID method, of class BoardElement.
     */
    @Test
    public final void testGetID() {
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
    public final void testGetCharacter() {
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
    public final void testIsConflict() {
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
    public final void testIsConflict2() {
        System.out.println("isConflict 2");
        BoardElement instance = new BoardElement();
        instance.setBoardElement(ZERO, TWENTYTHREE, 'E');
        instance.setBoardElement(ONE, TWENTYFOUR, 'R');
        int expResult = 1;
        int result = instance.isConflict();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAvailable method, of class BoardElement.
     */
    @Test
    public final void testIsAvailable() {
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
    public final void testIsSlotOneAvailable() {
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
    public final void testIsSlotTwoAvailable() {
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
    public final void testClearBoardElement() {
        System.out.println("clearBoardElement");
        int idx = 0;
        BoardElement instance = new BoardElement();
        instance.setBoardElement(idx, TWELVE, 'R');
        instance.clearBoardElement(idx);
        assertEquals(-1, instance.getID(idx));
        assertEquals(0, instance.getCharacter(idx));
    }

    /**
     * Test of downgradeElement method, of class BoardElement.
     */
    @Test
    public final void testDowngradeElement() {
        System.out.println("downgradeElement");
        BoardElement instance = new BoardElement();
        instance.downgradeElement();
        instance.setBoardElement(ONE, TWELVE, 'A');
        assert ('A' == instance.getCharacter(1))
                : "Wrong Character testDowngradeElement on test 1.\n"
                + "The right answer is A but your method answer "
                + instance.getCharacter(1);
        assert (TWELVE == instance.getID(1))
                : "Wrong ID testDowngradeElement on test 1.\n"
                + "The right answer is 12 but your method answer"
                + instance.getID(1);

        instance.downgradeElement();
        assert ('A' == instance.getCharacter(0))
                : "Wrong Character testDowngradeElement on test 2.\n"
                + "The right answer is A but your method answer "
                + instance.getCharacter(0);
        assert (TWELVE == instance.getID(0))
                : "Wrong ID testDowngradeElement on test 2.\n"
                + "The right answer is 122 but your method answer "
                + instance.getID(0);
    }
}
