/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ghifari
 */
public class PointTest {
    /**
     * constant value of two.
     */
    private static final int TWO = 2;
    /**
     * constant value of three.
     */
    private static final int THREE = 3;
    /**
     * constant value of four.
     */
    private static final int FOUR = 4;
    /**
     * Test of GetX method, of class Point.
     */
    @Test
    public final void testGetX() {
        System.out.println("GetX");
        Point instance = new Point(TWO, THREE);
        int expResult = TWO;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of SetX method, of class Point.
     */
    @Test
    public final void testSetX() {
        System.out.println("SetX");
        int x = 0;
        Point instance = new Point(TWO, FOUR);
        instance.setX(x);
        assert (2 != instance.getX()) : "absis is still 2";
        assert (0 == instance.getX()) : "absis is not 0";
    }

    /**
     * Test of GetY method, of class Point.
     */
    @Test
    public final void testGetY() {
        System.out.println("GetY");
        Point instance = new Point(TWO, FOUR);
        int expResult = FOUR;
        int result = instance.getY();
        assertEquals(expResult, result);
    }

    /**
     * Test of SetY method, of class Point.
     */
    @Test
    public final void testSetY() {
        System.out.println("SetY");
        int y = 0;
        Point instance = new Point(TWO, FOUR);
        instance.setY(y);
        assert (FOUR != instance.getY()) : "ordinat is still 4";
        assert (0 == instance.getY()) : "ordinat is not 0";
    }

    /**
     * Test of SetXY method, of class Point.
     */
    @Test
    public void testSetXY() {
        System.out.println("SetXY");
        int x = 0;
        int y = 0;
        Point instance = new Point(TWO, FOUR);
        instance.setXY(x, y);
        assert (2 != instance.getX()) : "absis is still 2";
        assert (0 == instance.getX()) : "absis is not 0";
        assert (FOUR != instance.getY()) : "ordinat is still 4";
        assert (0 == instance.getY()) : "ordinat is not 0";
    }

    /**
     * Test of Print method, of class Point.
     */
    @Test
    public final void testPrint() {
        System.out.println("Print");
        Point instance = new Point(TWO, FOUR);
        instance.Print();
    }
}
