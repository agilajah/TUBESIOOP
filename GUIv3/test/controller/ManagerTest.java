/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Ghifari
 */
public class ManagerTest {
    /**
     * constant value of ten.
     */
    private static final int TEN = 10;
    /**
     * Test of spawn method, of class Manager.
     */
    @Test
    public final void testSpawn() {
        System.out.println("spawn");
        Manager instance = new Manager(1);
        int c = instance.getCountEmptySlot();
        instance.spawn();
        int f = instance.getCountEmptySlot();
        assert (c != f);
    }

    /**
     * Test of spawnRumput method, of class Manager.
     */
    @Test
    public final void testSpawnRumput() {
        System.out.println("spawnRumput");
        Manager instance = new Manager(1);
        int c = instance.getCountEmptySlot();
        instance.spawnRumput();
        int f = instance.getCountEmptySlot();
        assert (c != f);
    }

    /**
     * Test of spawnRandomAmount method, of class Manager.
     */
    @Test
    public final void testSpawnRandomAmount() {
        System.out.println("spawnRandomAmount");
        Manager instance = new Manager(1);
        int c = instance.getCountEmptySlot();
        int f = 0;
        do {
            instance.spawnRandomAmount();
            f = instance.getCountEmptySlot();
            System.out.println("tes SpawnRandomAmount");
        } while (c == f);
        assert (c != f);
    }

    /**
     * Test of moveAll method, of class Manager.
     */
    @Test
    public final void testMoveAll() {
        System.out.println("moveAll");
        Manager instance = new Manager(TEN);
        instance.moveAll();
    }

    /**
     * Test of displayListOfMakhluk method, of class Manager.
     */
    @Test
    public final void testDisplayListOfMakhluk() {
        System.out.println("displayListOfMakhluk");
        Manager instance = new Manager(TEN);
        instance.displayListOfMakhluk();
    }

    /**
     * Test of resolveConflict method, of class Manager.
     */
    @Test
    public final void testResolveConflict() {
        System.out.println("resolveConflict");
        Manager instance = new Manager(2);
        instance.resolveConflict();
    }

    /**
     * Test of kill method, of class Manager.
     */
    @Test
    public final void testKill() {
        System.out.println("kill");
        int id = TEN;
        Manager instance = new Manager(TEN);
        instance.kill(id);
    }

    /**
     * Test of getCountEmptySlot method, of class Manager.
     */
    @Test
    public final void testGetCountEmptySlot() {
        System.out.println("getCountEmptySlot");
        Manager instance = new Manager(TEN);
        int expResult = 0;
        int result = instance.getCountEmptySlot();
        assert (expResult != result);
    }
}
