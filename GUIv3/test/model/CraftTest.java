/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Ghifari
 */
public class CraftTest {
    /**
     * constant value of fourty.
     */
    private static final int FOURTY = 40;
    /**
     * constant value of SIXTY.
     */
    private static final int SIXTY = 60;
    /**
     * Konstruktor CraftTest.
     */
    public CraftTest() {
    }

    /**
     * Test of changeCraft method, of class Craft.
     */
    @Test
    public final void testChangeCraft() {
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
    public final void testMove() {
        System.out.println("move");
        Craft instance = new Craft();
        int x = instance.getX();
        int y = instance.getY();
        instance.move();
        assertEquals(x, instance.getX());
        assertEquals(y, instance.getY());
    }

    /**
     * Test of getX method, of class Craft.
     */
    @Test
    public final void testGetX() {
        System.out.println("getX");
        Craft instance = new Craft();
        int expResult = FOURTY;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getY method, of class Craft.
     */
    @Test
    public final void testGetY() {
        System.out.println("getY");
        Craft instance = new Craft();
        int expResult = SIXTY;
        int result = instance.getY();
        assertEquals(expResult, result);
    }

    /**
     * Test of getImage method, of class Craft.
     */
    @Test
    public final void testGetImage() {
        System.out.println("getImage");
        Craft instance = new Craft();
        String path = "RiceField/src/gambar/search.png";
        ImageIcon ii = new ImageIcon(path);
        Image expResult = ii.getImage();
        Image result = instance.getImage();
        assert (result != expResult);
    }

    /**
     * Test of keyPressed method, of class Craft.
     */
    @Test
    public final void testKeyPressed() {
        System.out.println("keyPressed");
        KeyEvent e = null;
        Craft instance = new Craft();
        try {
            instance.keyPressed(e);
        } catch (Exception ee) {
            System.out.println(ee);
        }
    }

    /**
     * Test of keyReleased method, of class Craft.
     */
    @Test
    public final void testKeyReleased() {
        System.out.println("keyReleased");
        KeyEvent e = null;
        Craft instance = new Craft();
        try {
            instance.keyReleased(e);
        } catch (Exception ee) {
            System.out.println(ee);
        }
    }
}
