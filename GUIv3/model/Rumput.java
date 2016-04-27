package model;

import javax.swing.ImageIcon;

/**
 * Kelas Rumput turunan dari tumbuhan.
 * @author Febi Agil / 13514010
 */
public class Rumput extends Tumbuhan {
    /**
     * constant value of five hundreds.
     */
    private static final int FIVEHUNDREDS = 500;
    /**
     * variabel umur hidup rumput bertipe integer.
     */
    private int age;

    /**
     * konstruktor rumput.
     * @param id parameter input id rumput
     * @param x parameter input koordinat x rumput
     * @param y parameter input koordinat y rumput
     */
    public Rumput(int id, int x, int y) {
        super(id, x, y, 'R');
        age = 0;
        setGrowTime(FIVEHUNDREDS);
        try {
            ImageIcon ii = createImageIcon("img2.png");
            image = ii.getImage();
        } catch (ImageException e) {
            System.out.println("Error occured when trying to get image"
                    + " for Rumput class: " + e.getMessage());
        }

    }

    /**
     * prosedur untuk menambah umur cacing dan
     * mengubah karakternya dari R menjadi X apabila age > growTime.
     */
    public void gerak() {
        age++;
        if (age > getGrowTime()) {
            setKarakter('X');
            try {
                ImageIcon ii = createImageIcon("oldrmpt.png");
                image = ii.getImage();
            } catch (ImageException e) {
                System.out.println("Error occured when trying to"
                        + "get image for Rumput class: " + e.getMessage());
            }
        }
    }
}
