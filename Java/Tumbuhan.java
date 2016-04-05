public abstract class Tumbuhan extends Makhluk{
	protected int growTime;

	public Tumbuhan(int id, int x, int y, char karakter){
		super(id, x, y, karakter, 0);
	}

	public abstract void gerak();
}