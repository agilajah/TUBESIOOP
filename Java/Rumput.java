class Rumput extends Tumbuhan{
	private	int age;
	
	Rumput(int id, int x, int y) {
			super(id, x, y, 'R');
			age = 0;
			growTime= 500;
	}
	
	public	void gerak() {
		//do nothing
		age++;
		if ( age > growTime) {
			SetKarakter('X');
		}
	}
}
