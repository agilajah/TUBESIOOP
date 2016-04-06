/**
 * Kelas Rumput turunan dari tumbuhan
 * @author Febi Agil / 13514010
 */
class Rumput extends Tumbuhan{
    /**
     * variabel umur hidup rumput bertipe integer
     */
    private int age;

    /**
     * konstruktor rumput
     * @param id parameter input id rumput
     * @param x parameter input koordinat x rumput
     * @param y parameter input koordinat y rumput
     */
    Rumput(int id, int x, int y) {
        super(id, x, y, 'R');
        age = 0;
        growTime= 500;
    }

    /**
     * prosedur untuk menambah umur cacing dan
     * mengubah karakternya dari R menjadi X apabila age > growTime
     */
    public void gerak() {
        age++;
        if ( age > growTime) {
            SetKarakter('X');
        }
    }
}
