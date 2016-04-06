import java.io.FileWriter;
import java.io.BufferedWriter;

class Viewer{
		private Board board;
		private long speed;
		
		public Viewer(Board board){
			this.board = board;
			speed = 9000000;
		}
		
		public String convertBoardToString(){
			String tmp= "";
			
			for (int i=0; i<40; i++){
				for (int j=0; i<146; j++){
					if (board.getKarakter(j,i)==0){
						tmp += '-';
					} else {
						tmp += board.getKarakter(j,i);
					}
				}
			}
			return tmp;
		}
		
		public void displayToScreen(){
			System.out.println(convertBoardToString());
			delay();
		}
		
		public void delay(){
			for (long i=1; i<=speed; i++);
		}
		
		public void displayToFile(){
			String data = "";
			try{
				FileWriter fstream = new FileWriter("output.txt", true);
				BufferedWriter out = new BufferedWriter(fstream);
			
				for (int i=0 ; i<40; i++) {
					for (int j=0; j<146 ;j++ ){
						if (board.getKarakter(j,i) == '0') {
							data += '-';
						} else {
							data += board.getKarakter(j,i);
						}
					}
					out.write(data);
					data = "";
				}	
				out.close();
			} catch (Exception e){
				System.err.println("Error: " + e.getMessage());
			}
		}
		
		public void increaseRefreshRate(){
			speed += 1000000;
		}
		
		public void decreaseRefresRate(){
			speed -= 1000000;
		}
}