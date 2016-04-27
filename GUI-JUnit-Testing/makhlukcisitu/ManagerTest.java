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
public class ManagerTest {
    
    public ManagerTest() {
    }

    /**
     * Test of spawn method, of class Manager.
     */
    @Test
    public void testSpawn() {
        System.out.println("spawn");
        Manager instance = new Manager(1);
        int c = instance.getCountEmptySlot();
        instance.spawn();
        int f = instance.getCountEmptySlot();
        assert(c!=f);
    }

    /**
     * Test of spawnRumput method, of class Manager.
     */
    @Test
    public void testSpawnRumput() {
        System.out.println("spawnRumput");
        Manager instance = new Manager(1);
        int c = instance.getCountEmptySlot();
        instance.spawnRumput();
        int f = instance.getCountEmptySlot();
        assert(c!=f);
    }

    /**
     * Test of spawnRandomAmount method, of class Manager.
     */
    @Test
    public void testSpawnRandomAmount() {
        System.out.println("spawnRandomAmount");
        Manager instance = new Manager(1);
        int c = instance.getCountEmptySlot();
        int f = 0;
        do{
            instance.spawnRandomAmount();
            f = instance.getCountEmptySlot();
            System.out.println("tes SpawnRandomAmount");
        }while(c==f);
        
        assert(c!=f);
    }

    /**
     * Test of moveAll method, of class Manager.
     */
    @Test
    public void testMoveAll() {
        System.out.println("moveAll");
        Manager instance = new Manager(23);
        instance.moveAll();
    }

    /**
     * Test of displayListOfMakhluk method, of class Manager.
     */
    @Test
    public void testDisplayListOfMakhluk() {
        System.out.println("displayListOfMakhluk");
        Manager instance = new Manager(2);
        instance.displayListOfMakhluk();
    }

    /**
     * Test of resolveConflict method, of class Manager.
     */
    @Test
    public void testResolveConflict() {
        System.out.println("resolveConflict");
        Manager instance = new Manager(2);
        instance.resolveConflict();
    }

    /**
     * Test of kill method, of class Manager.
     */
    @Test
    public void testKill() {
        System.out.println("kill");
        int ID = 3;
        Manager instance = new Manager(2);
        instance.kill(ID);
    }
    
}
