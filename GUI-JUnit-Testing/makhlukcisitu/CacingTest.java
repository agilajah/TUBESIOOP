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
public class CacingTest {
    /**
     * Test of isDirectionsNotInitialized method, of class Cacing.
     */
    @Test
    public void testIsDirectionsNotInitialized() {
        System.out.println("isDirectionsNotInitialized");
        Cacing instance = new Cacing(1,2,3);
        boolean expResult = true;
        boolean result = instance.isDirectionsNotInitialized();
        assertEquals(expResult, result);
    }

    /**
     * Test of isYHitTheWall method, of class Cacing.
     */
    @Test
    public void testIsYHitTheWall() {
        System.out.println("isYHitTheWall");
        int yy = 0;
        Cacing instance = new Cacing(1,2,3);
        boolean expResult = true;
        boolean result = instance.isYHitTheWall(yy);
        assertEquals(expResult, result);
    }

    /**
     * Test of gerak method, of class Cacing.
     */
    @Test
    public void testGerak() {
        System.out.print("gerak ");
        Cacing instance =  new Cacing(1,2,3);
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
        System.out.println("");
        assert(test[0]!=jawab[0] || test[1]!=jawab[1]);
    }
    
}
