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
public class RumputTest {
    
    public RumputTest() {
    }

    /**
     * Test of gerak method, of class Rumput.
     */
    @Test
    public void testGerak() {
        System.out.println("gerak");
        Rumput instance = new Rumput(1,2,3);
        assert('R'==instance.GetKarakter());
        while(instance.GetKarakter()=='R')
            instance.gerak();
        assert('R'!=instance.GetKarakter());
    }
    
}
