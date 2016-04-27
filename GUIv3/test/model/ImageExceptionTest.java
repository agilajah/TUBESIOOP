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
public class ImageExceptionTest {
    /**
     * Test of getMessage method, of class ImageException.
     */
    @Test
    public final void testGetMessage() {
        System.out.println("getMessage");
        ImageException instance = new ImageException("Halo Pak");
        String expResult = "Halo Pak";
        String result = instance.getMessage();
        assertEquals(expResult, result);
    }
}
