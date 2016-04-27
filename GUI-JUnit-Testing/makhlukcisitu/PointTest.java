/*
 *  This is a game from Cisitu Corps
 *  The name of this game is Ricefield Battle
 *  @CopyRight 2016
 */
package makhlukcisitu;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ghifari
 */
public class PointTest {
    
    public PointTest() {
    }

    /**
     * Test of GetX method, of class Point.
     */
    @Test
    public void testGetX() {
        System.out.println("GetX");
        Point instance = new Point(2, 3);
        int expResult = 2;
        int result = instance.GetX();
        assertEquals(expResult, result);
    }

    /**
     * Test of SetX method, of class Point.
     */
    @Test
    public void testSetX() {
        System.out.println("SetX");
        int x = 0;
        Point instance = new Point(2, 4);
        instance.SetX(x);
        assert(2!=instance.GetX()) : "absis is still 2";
        assert(0==instance.GetX()) : "absis is not 0";
    }

    /**
     * Test of GetY method, of class Point.
     */
    @Test
    public void testGetY() {
        System.out.println("GetY");
        Point instance = new Point(2, 4);
        int expResult = 4;
        int result = instance.GetY();
        assertEquals(expResult, result);
    }

    /**
     * Test of SetY method, of class Point.
     */
    @Test
    public void testSetY() {
        System.out.println("SetY");
        int y = 0;
        Point instance = new Point(2, 4);
        instance.SetY(y);
        assert(4!=instance.GetY()) : "ordinat is still 4";
        assert(0==instance.GetY()) : "ordinat is not 0";
    }

    /**
     * Test of SetXY method, of class Point.
     */
    @Test
    public void testSetXY() {
        System.out.println("SetXY");
        int x = 0;
        int y = 0;
        Point instance = new Point(2, 4);
        instance.SetXY(x, y);
        assert(2!=instance.GetX()) : "absis is still 2";
        assert(0==instance.GetX()) : "absis is not 0";
        assert(4!=instance.GetY()) : "ordinat is still 4";
        assert(0==instance.GetY()) : "ordinat is not 0";
    }

    /**
     * Test of Print method, of class Point.
     */
    @Test
    public void testPrint() {
        System.out.println("Print");
        Point instance = new Point(2, 4);
        instance.Print();
    }
    
}
