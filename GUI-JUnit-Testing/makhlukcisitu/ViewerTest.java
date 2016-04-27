/*
 *  This is a game from Cisitu Corps
 *  The name of this game is Ricefield Battle
 *  @CopyRight 2016
 */
package makhlukcisitu;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ghifari
 */
public class ViewerTest {
    
    public ViewerTest() {
    }

    /**
     * Test of paintComponent method, of class Viewer.
     */
    @Test
    public void testPaintComponent() {
    }

    /**
     * Test of actionPerformed method, of class Viewer.
     */
    @Test
    public void testActionPerformed() {
    }

    /**
     * Test of convertBoardToString method, of class Viewer.
     */
    @Test
    public void testConvertBoardToString() {
        System.out.println("convertBoardToString");
        Board board = new Board();
        Viewer instance = new Viewer(board);
        String expResult = instance.convertBoardToString();
        board.setPoint(1, 1, 'E', 34);
        String result = instance.convertBoardToString();
        assert(expResult!=result);
    }

    /**
     * Test of displayToScreen method, of class Viewer.
     */
    @Test
    public void testDisplayToScreen() {
        System.out.println("displayToScreen");
        Board b = new Board();
        Viewer instance = new Viewer(b);
        instance.displayToScreen();
    }

    /**
     * Test of delay method, of class Viewer.
     */
    @Test
    public void testDelay() {
        System.out.println("delay");
        Board b = new Board();
        Viewer instance = new Viewer(b);
        instance.delay();
    }

    /**
     * Test of displayToFile method, of class Viewer.
     */
    @Test
    public void testDisplayToFile() {
        System.out.println("displayToFile");
        Board b = new Board();
        Viewer instance = new Viewer(b);
        instance.displayToFile();
    }
    
}
