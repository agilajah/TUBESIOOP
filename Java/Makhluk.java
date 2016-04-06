public abstract class Makhluk{
	private int id;
	private int kekuatan;
	private Point P;
	private char karakter;
	
	Makhluk(int id, int x, int y, char karakter, int kekuatan){
		SetID(id);
		P = new Point(x,y);
		SetPoint(x,y);
		SetKarakter(karakter);
		SetKekuatan(kekuatan);
	}

	Makhluk(int id, int x, int y, char karakter){
		SetID(id);
		SetPoint(x,y);
		SetKarakter(karakter);
		SetKekuatan(0);
	}

	public void SetID(int id){
		this.id = id;
	}
	
	public void SetPoint(int x, int y){
		P.SetXY(x,y);
	}

	public void SetKarakter(char karakter){
		this.karakter = karakter;
	}
		
	public void SetKekuatan(int kekuatan){
		this.kekuatan = kekuatan;
	}
	
	public int GetID(){
		return id;
	}

	public int getX(){
		return P.GetX();
	}
	
	public int getY(){
		return P.GetY();
	}

	public Point GetPoint(){
		return P;
	}
	
	public int GetKarakter(){
		return karakter;	
	}
	
	public int GetKekuatan(){
		return kekuatan;
	}
	
	public void PrintPos(){
		P.Print();
	}
	
	public abstract void gerak();
}
