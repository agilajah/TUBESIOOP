public abstract class Hewan extends Makhluk{
	public Hewan(int id, int x, int y, char karakter){
		super(id, x, y, karakter, 0);
	}

	public abstract void gerak();
}