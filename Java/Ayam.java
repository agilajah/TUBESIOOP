import java.util.Random;

class Ayam extends Hewan {		//Descendant from hewan
	private	int delay;
	private	int timer;
	
	//lahir langsung harus menghasilkan koordinat
	// Karakter Ayam adalah A
	Ayam(int id, int x, int y) {
		super(x, y, 'A', id);
		timer = 0;
		Random rand;
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		min = 1; 
		max = 3;
		delay = rand.nextInt((max - min) + 1) + min;
	}

	public void gerak() {
			int xx, yy;

			timer++;

			if (timer == delay) {
					timer = 0;
					xx = getX();
					yy = getY();
					Random rand;
					min = 1;
					max = 8; 
					int random = rand.nextInt((max - min) + 1) + min;
					switch(random){
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
							default :
								break;
					}

					if (xx >= 145)
						xx=144;
					else if (xx < 0)
						xx=1;
					if (yy >= 39)
						yy=38;
					else if (yy < 0)
						yy=1;
					SetPoint(xx,yy);

			} else {
				//do nothing

			}
	}
}
