import java.io.FileWriter;
import java.io.BufferedWriter;

/**
 *
 * @author Amal Qurany / 13514078
 */
class Viewer{
    /**
     * variabel board bertipe Board
     */
    private Board board;
    /**
     * variabel speed dengan tipe long
     */
    private long speed;

    /**
     * konstruktor Viewer
     * @param board parameter inputan board
     */
    public Viewer(Board board){
        this.board = board;
        speed = 9000000;
    }

    /**
     * fungsi untuk mengubah board ke string
     * @return mengembalikan tmp bertipe String
     */
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
    
    /**
     * prosedur untuk menampilkan board ke layar
     */
    public void displayToScreen(){
        System.out.println(convertBoardToString());
        delay();
    }

    /**
     * prosedur untuk delay
     */
    public void delay(){
        for (long i=1; i<=speed; i++);
    }

    /**
     * prosedur untuk menyimpan display ke file
     */
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

    /**
     * prosedur untuk menambah kecepatan (speed)
     */
    public void increaseRefreshRate(){
        speed += 1000000;
    }

    /**
     * prosedur untuk mengurangi kecepatan (speed)
     */
    public void decreaseRefresRate(){
        speed -= 1000000;
    }
}