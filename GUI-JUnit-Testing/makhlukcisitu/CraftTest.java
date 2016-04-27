/*
 *  This is a game from Cisitu Corps
 *  The name of this game is Ricefield Battle
 *  @CopyRight 2016
 */
package makhlukcisitu;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ghifari
 */
public class CraftTest {
    
    public CraftTest() {
    }

    /**
     * Test of changeCraft method, of class Craft.
     */
    @Test
    public void testChangeCraft() {
        System.out.println("changeCraft");
        Craft instance = new Craft();
        String name = instance.getImage().toString();
        assertEquals(true, instance.getImage().toString().equals(name));
        instance.changeCraft();
        assertEquals(false, instance.getImage().toString().equals(name));
    }

    /**
     * Test of move method, of class Craft.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        Craft instance = new Craft();
        int x = instance.getX();
        int y = instance.getY();
        instance.move();
        assertEquals(x,instance.getX());
        assertEquals(y,instance.getY());
    }

    /**
     * Test of getX method, of class Craft.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Craft instance = new Craft();
        int expResult = 40;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getY method, of class Craft.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Craft instance = new Craft();
        int expResult = 60;
        int result = instance.getY();
        assertEquals(expResult, result);
    }

    /**
     * Test of getImage method, of class Craft.
     */
    @Test
    public void testGetImage() {
        System.out.println("getImage");
        Craft instance = new Craft();
        ImageIcon ii = new ImageIcon("search.png");
        Image expResult = ii.getImage();
        Image result = instance.getImage();
        assertEquals(expResult, result);
    }

    /**
     * Test of keyPressed method, of class Craft.
     */
    @Test
    public void testKeyPressed() {
        System.out.println("keyPressed");
        KeyEvent e = null;
        Craft instance = new Craft();
        try{
            instance.keyPressed(e);
        }catch(Exception ee){
            System.out.println(ee);
        }
    }

    /**
     * Test of keyReleased method, of class Craft.
     */
    @Test
    public void testKeyReleased() {
        System.out.println("keyReleased");
        KeyEvent e = null;
        Craft instance = new Craft();
        try{
            instance.keyReleased(e);
        }catch(Exception ee){
            System.out.println(ee);
        }
    }
    
}
