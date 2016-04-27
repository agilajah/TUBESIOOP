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
public class AyamTest {
    /**
     * constant value of eleven.
     */
    private static final int ELEVEN = 11;
    /**
     * constant value of two.
     */
    private static final int TWO = 2;
    /**
     * constant value of three.
     */
    private static final int THREE = 3;
    /**
     * Konstruktor Ayam.
     */
    public AyamTest() {
    }

    /**
     * Test of gerak method, of class Ayam.
     */
    @Test
    public final void testGerak() {
        System.out.print("gerak");
        Ayam instance = new Ayam(ELEVEN, TWO, THREE);
        System.out.println("(" + instance.getX() + "," + instance.getY() + ")");
        int i = 0;
        while (instance.getX() == 2 && instance.getY() == THREE) {
            System.out.println("call gerak at " + i);
            instance.gerak();
            i++;
        }

        int[] test = {TWO, THREE};
        int[] jawab = {instance.getX(), instance.getY() };

        System.out.println("result :(" + instance.getX()
                + "," + instance.getY() + ")");
        assert (test[0] != jawab[0] || test[1] != jawab[1]);
        System.out.println("");
    }
}
