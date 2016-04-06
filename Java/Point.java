
/**
 *
 * @author Ghifari
 */
public class Point {
    /**
     * variabel point x
     */
    private int x;
    /**
     * variabel point y
     */
    private int y;
    
    /**
     * Konstruktor dengan parameter
     * @param x untuk input nilai x
     * @param y untuk input nilai y
     */
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    /**
     * getter x
     * @return mengembalikan x
     */
    int GetX(){
	return x;
    }

    /**
     * Setter x
     * @param x melakukan input ke x
     */
    void SetX(int x){
	this.x = x;
    }

    /**
     * getter y
     * @return mengembalikan nilai y
     */
    int GetY(){
	return y;
    }

    /**
     * setter y
     * @param y melakukan input ke nilai y
     */
    void SetY(int y) {
	this.y = y;
    }

    /**
     * setter x y
     * @param x untuk input nilai x
     * @param y untuk input nilai y
     */
    void SetXY(int x, int y) {
	this.x = x;
	this.y = y;
    }

    /**
     * untuk mencetak point (x,y)
     */
    void Print(){
        System.out.println("("+x+","+y+")");
    }
    
}