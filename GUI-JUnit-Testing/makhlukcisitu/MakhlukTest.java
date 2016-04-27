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
public class MakhlukTest {

    /**
     * Test of SetID method, of class Makhluk.
     */
    @Test
    public void testSetID() {
        System.out.println("SetID");
        int id = 0;
        //Makhluk(int id, int x, int y, char karakter, int kekuatan)
        Makhluk instance = new Ayam(id, id, id);
        instance.SetID(23);
        assertEquals(23, instance.GetID());
    }

    /**
     * Test of SetPoint method, of class Makhluk.
     */
    @Test
    public void testSetPoint() {
        System.out.println("SetPoint");
        int id = 0;
        int x = 2;
        int y = 3;
        Makhluk instance = new Elang(id, id, id);
        instance.SetPoint(x, y);
        assertEquals(x, instance.getX());
        assertEquals(y, instance.getY());
    }

    /**
     * Test of SetKarakter method, of class Makhluk.
     */
    @Test
    public void testSetKarakter() {
        System.out.println("SetKarakter");
        int id = 2;
        char karakter = 'E';
        Makhluk instance = new Ayam(id, id, id);
        instance.SetKarakter(karakter);
        assertEquals(karakter, instance.GetKarakter());
    }

    /**
     * Test of SetKekuatan method, of class Makhluk.
     */
    @Test
    public void testSetKekuatan() {
        System.out.println("SetKekuatan");
        int id = 5;
        int kekuatan = 10;
        Makhluk instance = new Elang(id, id, id);
        instance.SetKekuatan(kekuatan);
        assertEquals(kekuatan, instance.GetKekuatan());
    }

    /**
     * Test of GetID method, of class Makhluk.
     */
    @Test
    public void testGetID() {
        System.out.println("GetID");
        int id = 19;
        Makhluk instance = new Elang(id, id, id);
        int expResult = 20;
        instance.SetID(expResult);
        int result = instance.GetID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getX method, of class Makhluk.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Makhluk instance = new Elang(1, 2, 3);
        int expResult = 2;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getY method, of class Makhluk.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Makhluk instance = new Elang(1, 2, 3);
        int expResult = 3;
        int result = instance.getY();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetPoint method, of class Makhluk.
     */
    @Test
    public void testGetPoint() {
        System.out.println("GetPoint");
        Makhluk instance = new Elang(1, 2, 3);;
        Point expResult = new Point(2, 3);
        int ex = expResult.GetX();
        int ey = expResult.GetY();
        Point result = instance.GetPoint();
        assertEquals(ex, result.GetX());
        assertEquals(ey, result.GetY());
    }

    /**
     * Test of GetKarakter method, of class Makhluk.
     */
    @Test
    public void testGetKarakter() {
        System.out.println("GetKarakter");
        Makhluk instance = new Cacing(1, 2, 3);;
        char expResult = 'C';
        char result = instance.GetKarakter();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetKekuatan method, of class Makhluk.
     */
    @Test
    public void testGetKekuatan() {
        System.out.println("GetKekuatan");
        Makhluk instance = new Elang(1, 2, 3);;
        instance.SetKekuatan(234);
        int expResult = 234;
        int result = instance.GetKekuatan();
        assertEquals(expResult, result);
    }

    /**
     * Test of PrintPos method, of class Makhluk.
     */
    @Test
    public void testPrintPos() {
        System.out.println("PrintPos");
        Makhluk instance = new Elang(1, 2, 3);;
        instance.PrintPos();
    }

    /**
     * Test of gerak method, of class Makhluk.
     */
    @Test
    public void testGerak() {
        System.out.print("--gerak ");
        Makhluk instance = new Elang(1, 2, 3);
        System.out.println("("+instance.getX()+","+instance.getY()+")");
        int i = 0;
        while(instance.getX()==2 && instance.getY()==3){
            System.out.println("call gerak at "+i);
            instance.gerak();
            i++;
        }
        int [] test = {2,3};
        int [] jawab = {instance.getX(),instance.getY()};
        System.out.println("--result Gerak :("+instance.getX()+","+instance.getY()+")");
        assert(test[0]!=jawab[0] || test[1]!=jawab[1]);
        System.out.println("");
    }

}
