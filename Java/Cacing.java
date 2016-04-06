class Cacing extends Hewan {
	private bool up;
	private bool down;
	private bool right;
	private bool left;
	
	// karakter cacing adalah 'C'
	
	Cacing(int id, int x, int y) {
		super(x, y, 'C', id);
		up = false;
		down = false;
		right = false;
		left = false;
	}

	public void gerak();
	public bool isDirectionsNotInitialized() {				
			// return true if unitialized
			if (!up && !down && !right && !left)
				return true;
			else
				return false;
	}

	public bool isYHitTheWall(int) {
		//return ture if hit the bottom and upper wall
		if (yy<=0 || yy>=39) 
			return true;
		else
			return false;
	}

	public gerak() {
		int xx, yy;
		xx = getX();
		yy = getY();

		if (isDirectionsNotInitialized()){
			up=true;
			right=true;
		}
		
		if (!isYHitTheWall(yy)){
			if (up && !down){
				yy--;
			}else if (!up && down){
				yy++;
			}
		}else{
			if (right && !left){
				xx++;
			}else if (!right && left){
				xx--;
			}

			if (xx>=145){
				xx=144;
				right = false;
				left = true;
			}else if (xx<=0){
				xx=1;
				right = true;
				left = false;
			}


			if (up && !down){
				yy++;
				up = false;
				down = true;
			}else if (!up && down){
				yy--;
				up = true;
				down = false;
			}
		}
		SetPoint(xx,yy); //SetPoint is method from its class parent, eh? idk
	}
}
