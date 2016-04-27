/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 *
 * @author Ghifari
 */
public class CacingTest {
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
     * Test of isDirectionsNotInitialized method, of class Cacing.
     */
    @Test
    public final void testIsDirectionsNotInitialized() {
        System.out.println("isDirectionsNotInitialized");
        Cacing instance = new Cacing(ONE, TWO, THREE);
        boolean expResult = true;
        boolean result = instance.isDirectionsNotInitialized();
        assertEquals(expResult, result);
    }

    /**
     * Test of isYHitTheWall method, of class Cacing.
     */
    @Test
    public final void testIsYHitTheWall() {
        System.out.println("isYHitTheWall");
        int yy = 0;
        Cacing instance = new Cacing(ONE, TWO, THREE);
        boolean expResult = true;
        boolean result = instance.isYHitTheWall(yy);
        assertEquals(expResult, result);
    }

    /**
     * Test of gerak method, of class Cacing.
     */
    @Test
    public final void testGerak() {
        System.out.print("gerak ");
        Cacing instance =  new Cacing(ONE, TWO, THREE);
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

        System.out.println("result :(" + instance.getX()
                + "," + instance.getY() + ")");
        System.out.println("");
        assert (test[0] != jawab[0] || test[1] != jawab[1]);
    }
}
