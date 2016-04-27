/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import javax.swing.ImageIcon;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Ghifari
 */
public class MakhlukTest {
    /**
     * constant value of one.
     */
    private static final int ONE = 1;
    /**
     * constant value of two.
     */
    private static final int TWO = 2;
    /**
     * constant value of three.
     */
    private static final int THREE = 3;
    /**
     * Test of SetID method, of class Makhluk.
     */
    @Test
    public final void testSetID() {
        System.out.println("SetID");
        int id = 0;
        //Makhluk(int id, int x, int y, char karakter, int kekuatan)
        Makhluk instance = new Ayam(id, id, id);
        instance.setId(ONE);
        assertEquals(ONE, instance.getId());
    }

    /**
     * Test of SetPoint method, of class Makhluk.
     */
    @Test
    public final void testSetPoint() {
        System.out.println("SetPoint");
        int id = 0;
        int x = TWO;
        int y = THREE;
        Makhluk instance = new Elang(id, id, id);
        instance.setPoint(x, y);
        assertEquals(x, instance.getX());
        assertEquals(y, instance.getY());
    }

    /**
     * Test of SetKarakter method, of class Makhluk.
     */
    @Test
    public final void testSetKarakter() {
        System.out.println("SetKarakter");
        int id = 2;
        char karakter = 'E';
        Makhluk instance = new Ayam(id, id, id);
        instance.setKarakter(karakter);
        assertEquals(karakter, instance.getKarakter());
    }

    /**
     * Test of SetKekuatan method, of class Makhluk.
     */
    @Test
    public final void testSetKekuatan() {
        System.out.println("SetKekuatan");
        int id = TWO;
        int kekuatan = THREE;
        Makhluk instance = new Elang(id, id, id);
        instance.setKekuatan(kekuatan);
        assertEquals(kekuatan, instance.getKekuatan());
    }

    /**
     * Test of GetID method, of class Makhluk.
     */
    @Test
    public final void testGetID() {
        System.out.println("GetID");
        int id = ONE;
        Makhluk instance = new Elang(id, id, id);
        int expResult = TWO;
        instance.setId(expResult);
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getX method, of class Makhluk.
     */
    @Test
    public final void testGetX() {
        System.out.println("getX");
        Makhluk instance = new Elang(ONE, TWO, THREE);
        int expResult = TWO;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getY method, of class Makhluk.
     */
    @Test
    public final void testGetY() {
        System.out.println("getY");
        Makhluk instance = new Elang(ONE, TWO, THREE);
        int expResult = THREE;
        int result = instance.getY();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetPoint method, of class Makhluk.
     */
    @Test
    public final void testGetPoint() {
        System.out.println("GetPoint");
        Makhluk instance = new Elang(ONE, TWO, THREE);;
        Point expResult = new Point(TWO, THREE);
        int ex = expResult.getX();
        int ey = expResult.getY();
        Point result = instance.getPoint();
        assertEquals(ex, result.getX());
        assertEquals(ey, result.getY());
    }

    /**
     * Test of GetKarakter method, of class Makhluk.
     */
    @Test
    public final void testGetKarakter() {
        System.out.println("GetKarakter");
        Makhluk instance = new Cacing(ONE, TWO, THREE);
        char expResult = 'C';
        char result = instance.getKarakter();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetKekuatan method, of class Makhluk.
     */
    @Test
    public final void testGetKekuatan() {
        System.out.println("GetKekuatan");
        Makhluk instance = new Elang(ONE, TWO, THREE);;
        instance.setKekuatan(THREE);
        int expResult = THREE;
        int result = instance.getKekuatan();
        assertEquals(expResult, result);
    }

    /**
     * Test of PrintPos method, of class Makhluk.
     */
    @Test
    public final void testPrintPos() {
        System.out.println("PrintPos");
        Makhluk instance = new Elang(ONE, TWO, THREE);;
        instance.printPos();
    }

    /**
     * Test of gerak method, of class Makhluk.
     */
    @Test
    public final void testGerak() {
        System.out.print("--gerak ");
        Makhluk instance = new Elang(ONE, TWO, THREE);
        System.out.println("(" + instance.getX() + ","
                + instance.getY() + ")");
        int i = 0;
        while (instance.getX() == TWO && instance.getY() == THREE) {
            System.out.println("call gerak at " + i);
            instance.gerak();
            i++;
        }
        int[] test = {TWO, THREE};
        int[] jawab = {instance.getX(), instance.getY()};
        System.out.println("--result Gerak :(" + instance.getX()
                            + "," + instance.getY() + ")");
        assert (test[0] != jawab[0] || test[1] != jawab[1]);
        System.out.println("");
    }
}
