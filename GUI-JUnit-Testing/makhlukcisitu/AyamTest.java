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
public class AyamTest {
    /**
     * Test of gerak method, of class Ayam.
     */
    @Test
    public void testGerak() {
        System.out.print("gerak ");
        Ayam instance = new Ayam(11,2,3);
        System.out.println("("+instance.getX()+","+instance.getY()+")");
        int i = 0;
        while(instance.getX()==2 && instance.getY()==3){
            System.out.println("call gerak at "+i);
            instance.gerak();
            i++;
        }
        
        int [] test = {2,3};
        int [] jawab = {instance.getX(),instance.getY()};
        
        System.out.println("result :("+instance.getX()+","+instance.getY()+")");
        assert(test[0]!=jawab[0] || test[1]!=jawab[1]);
        System.out.println("");
    }
    
}
