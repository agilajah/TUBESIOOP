import java.util.Random;

class Elang extends Hewan { 	//Descendant from Hewan
	private	int delay;
	private	int timer;
	private int arah;
	//lahir harus langsung punya koordinat
	// karakter elang adalah E
	Elang(int id, int x, int y) {
			super(x, y, 'E', id);
			timer = 0;
			getArahRandom();
			Random rand;
			// nextInt is normally exclusive of the top value,
			// so add 1 to make it inclusive
			min = 1; 
			max = 3;
			delay = rand.nextInt((max - min) + 1) + min;
	}
	
	
	private void getArahRandom() {
			min = 1;
			max = 8;
			Random rand;
			arah = rand.nextInt((max - min) +1) + min;
	}
	
	
	private bool isCollision(int x, int y) {
			// return true is coordinate is on boundaries defined
			if (xx>0 && xx<145 && yy>0 && yy<39){
				return false;
			}else {
				return true;
			}	
	}
	
	
	private bool isSameDirection(int) {
			//return true if the direction is same
			//korelasi arah :
			//// dinding kanan 	: 1, 5, 6
			//// dinding kiri	: 3, 7, 8
			//// dinding atas 	: 2, 5, 6
			//// dinding bawah 	: 4, 6, 8	
			if (((temp==1 || temp==5 || temp==6) && (arah==1 || arah==5 || arah==6)) ||
				((temp==3 || temp==7 || temp==8) && (arah==3 || arah==7 || arah==8)) ||
				((temp==2 || temp==5 || temp==6) && (arah==2 || arah==5 || arah==6)) ||
				((temp==4 || temp==6 || temp==8) && (arah==4 || arah==6 || arah==8)) )
				return true;
			else
				return false;
	}
	
	public void gerak() {
			int xx, yy;
			xx = getX();
			yy = getY();

			timer++;

			if(timer == delay) {
				timer = 0;

				if (!isCollision(xx,yy)){
					switch(arah){
						case 1 : xx++;
							break;
						case 2 : yy++;
							break;
						case 3 : xx--;
							break;
						case 4 : yy--;
							break;
						case 5 : xx++;
								 yy++;
							break;
						case 6 : xx++;
								 yy--;
							break;
						case 7 : xx--;
								 yy++;
							break;
						case 8 : xx--;
								 yy--;
							break;
					}
				} else {
						if (xx >= 145)
							xx=144;
						else if (xx <= 0)
							xx=1;
						if (yy >= 39)
							yy=38;
						else if (yy <= 0)
							yy=1;
						int temp = arah;
						bool cek = true;
						min = 1;
						max = 8;
						Random rand;
						arah = rand.nextInt((max - min) + 1) + min;
					
						while(cek){
							if (isSameDirection(temp)){
								min = 1;
								max = 8;
								Random rand;
								arah = rand.nextInt((max - min) + 1) + min;
							}else{
								cek = false;
							}
						}
				}
				SetPoint(xx,yy);
		}
	}	
		
}
