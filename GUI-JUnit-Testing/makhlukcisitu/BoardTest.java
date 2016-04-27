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
public class BoardTest {
    
    /**
     * Test of testBoard constructor of class Board;
     */
    @Test
    public void testBoard(){
        System.out.println("Board Constructor Test");
        Board a = new Board();
        assertEquals(-1,a.getIDElement(0, 0));
    }
    
    /**
     * Test of getIDElement method of class Board
     */
    @Test
    public void testgetIDElement(){
        System.out.println("getIDElement Test");
        Board a = new Board();
        assertEquals(-1,a.getIDElement(0, 0));
    }
    
    /**
     * Test of isCoordinateAvailable method, of class Board.
     */
    @Test
    public void testIsCoordinateAvailable() {
        System.out.println("isCoordinateAvailable");
        int x = 0;
        int y = 0;
        Board instance = new Board();
        int expResult = 1;
        int result = instance.isCoordinateAvailable(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCharacter method, of class Board.
     */
    @Test
    public void testGetCharacter() {
        System.out.println("getCharacter");
        int x = 0;
        int y = 0;
        Board instance = new Board();
        char expResult = 0;
        char result = instance.getCharacter(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of setPoint method, of class Board.
     */
    @Test
    public void testSetPoint() {
        System.out.println("setPoint");
        int x = 0;
        int y = 0;
        char element = 'R';
        int id = 23;
        Board instance = new Board();
        instance.setPoint(x, y, element, id);
        assertEquals('R',instance.getCharacter(x, y));
        assertEquals(23, instance.getIDElement(x, y));
    }

    /**
     * Test of clearPoint method, of class Board.
     */
    @Test
    public void testClearPoint() {
        System.out.println("clearPoint");
        int x = 0;
        int y = 0;
        int id = 23;
        Board instance = new Board();
        instance.setPoint(x, y, 'R', id);
        assertEquals('R',instance.getCharacter(x, y));
        assertEquals(23, instance.getIDElement(x, y));
        instance.clearPoint(x, y, id);
        assertEquals(0,instance.getCharacter(x, y));
        assertEquals(-1, instance.getIDElement(x, y));
        
    }

    /**
     * Test of isConflictArea method, of class Board.
     */
    @Test
    public void testIsConflictArea() {
        System.out.println("isConflictArea");
        int x = 0;
        int y = 0;
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isConflictArea(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFighterID method, of class Board.
     */
    @Test
    public void testGetFighterID() {
        System.out.println("getFighterID");
        int x = 0;
        int y = 0;
        Board instance = new Board();
        int[] expResult = {-1,-1};
        int[] result = instance.getFighterID(x, y);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getFighterClass method, of class Board.
     */
    @Test
    public void testGetFighterClass() {
        System.out.println("getFighterClass");
        int x = 0;
        int y = 0;
        Board instance = new Board();
        char[] expResult = {0,0};
        char[] result = instance.getFighterClass(x, y);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getAvailableCoordinate method, of class Board.
     */
    @Test
    public void testGetAvailableCoordinate() {
        System.out.println("getAvailableCoordinate");
        Board instance = new Board();
        int[] result = instance.getAvailableCoordinate();
        int available = instance.isCoordinateAvailable(result[0], result[1]);
        assertEquals(1, available);
    }
    
}
