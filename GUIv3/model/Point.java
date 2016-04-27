package model;

/**
 * .<h1> Point </h1>
 * Kelas point digunakan sebagai adt point koordinat makhluk hidup
 * @author Farhan Ghifari / 13515602
 */
public class Point {
    /**
     * .variabel point x
     */
    private int x;
    /**
     * .variabel point y
     */
    private int y;
    
    /**
     * .Konstruktor dengan parameter
     * @param x untuk input nilai x
     * @param y untuk input nilai y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * .getter x
     * @return mengembalikan x
     */
    int getX() {
        return x;
    }

    /**
     * .Setter x
     * @param x melakukan input ke x
     */
    void setX(int x) {
        this.x = x;
    }

    /**
     * .getter y
     * @return mengembalikan nilai y
     */
    int getY() {
        return y;
    }

    /**
     * .setter y
     * @param y melakukan input ke nilai y
     */
    void setY(int y ) {
        this.y = y;
    }

    /**
     * .setter x y
     * @param x untuk input nilai x
     * @param y untuk input nilai y
     */
    void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * .untuk mencetak point (x,y)
     */
    void Print() {
        System.out.println("(" + x + "," + y + ")");
    }
    
}