public class Point{
      private int x;
      private int y;

      // Constrtuctor
      public Point(){
	  // Set titik mula-mula ke (0, 0)	
		  x = 0;
		  y = 0;
	  }

      public Point(int x, int y){
	  // Set titik mula-mula ke (0, 0)	
		  SetAbsis(x);
		  SetOrdinat(y);
	  }

      // Getter
      public int GetX(){
		  return x;
	  }
	  
      public int GetY(){
		  return y;
	  }

	  
      // Setter
      public void SetAbsis(int _x){
			x = _x;
	  }

      public void SetOrdinat(int _y){
			y = _y;
	  }

 
      // Predikat      
      public int IsOrigin(){
      // Menghasilkan 1 jika titik (x, y) berada di (0, 0) dan 0 apabila sebaliknya
			if (x==0 && y==0) return 1;
			else return 0;
	  }
 
      // Operator Relasional
      public int IsEqual(Point P){
	  // Menghasilkan 1 jika titik pada argumen sama dengan dirinya (nilainya x dan y sama) dan 0 apabila sebaliknya
		  if (x==P.x && y==P.y) return 1;
		  else return 0;
	  }

      
      // Operator aritmetika, operator overloading
      public Point Add(Point P1, Point P2){
      // Menghasilkan sebuah Point yang memiliki atribut hasil penjumlahan dari atribut argumen kedua titik
		  Point pHasil = new Point();
		  
		  pHasil.x = P1.x + P2.x;
		  pHasil.y = P1.y + P2.y;
		  
		  return pHasil;
	  }
	  
      public Point Add(Point P){
	  // menghasilkan current objek+P
		  Point pAdded = new Point();
		  pAdded.x = this.x + P.x;
		  pAdded.y = this.y + P.y;
		  
		  return pAdded;
	  } 

      public Point Add(int x, int y){
      // Menghasilkan sebuah Point dengan translasi (x, y)
			Point pTrans = new Point();
			pTrans.x = this.x + x;
			pTrans.y = this.y + y;
			
			return pTrans;
	  }



      public void AddToMe(Point P){
      // Mengubah titik dengan penambahan Point argumen  
			this.x += P.x;
			this.y += P.y;
	  }

      public void AddToMe(int x, int y){
      // Mentranslasikan titik sebesar (x, y) 
			this.x += x;
			this.y += y;
	  }

      public void Mirror(){
      // Mengubah titik yang merupakan hasil mirror dengan garis y = x
			int tmp;
			
			tmp = x;
			y = y;
			y = tmp;
	  }


      // Fungsi lain

      public int Kuadran(){
      // Menghasilkan nomor kuadran dari titik sekarang
		  if(x>0 && y>0) return 1;
		  else if (x>0 && y<0) return 4;
		  else if (x<0 && y>0) return 2;
		  else if (x<0 && y<0) return 3;
		  else return 0;
	  }

      public Point MirrorOfMe(){
      // Menghasilkan sebuah titik yang merupakan hasil mirror dengan garis y = x
		Point PMirror = new Point();
		
		PMirror.x = y;
		PMirror.y = x;
		
		return PMirror;
	  }

	  public void SetXY(int x, int y){
		  SetAbsis(x);
		  SetOrdinat(y);
	  }
	  
	  public void Print(){
		  System.out.println("(" + x + "," + y + ")");
	  }

}
