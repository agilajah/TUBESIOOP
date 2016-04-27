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
public class TumbuhanTest {
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
     * Test of getGrowTime method, of class Tumbuhan.
     */
    @Test
    public final void testGetGrowTime() {
        System.out.println("getGrowTime");
        Tumbuhan instance = new Rumput(ONE, TWO, THREE);
        int expResult = TWO;
        instance.setGrowTime(TWO);
        int result = instance.getGrowTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGrowTime method, of class Tumbuhan.
     */
    @Test
    public final void testSetGrowTime() {
        System.out.println("getGrowTime");
        Tumbuhan instance = new Rumput(ONE, TWO, THREE);
        int expResult = TWO;
        instance.setGrowTime(TWO);
        int result = instance.getGrowTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of gerak method, of class Tumbuhan.
     */
    @Test
    public final void testGerak() {
        System.out.println("gerak");
        Rumput instance = new Rumput(ONE, TWO, THREE);
        assert ('R' == instance.getKarakter());
        while (instance.getKarakter() == 'R') {
            instance.gerak();
        }
        assert ('R' != instance.getKarakter());
    }
}
