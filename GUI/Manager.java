import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Rectangle;


/**
 * <h1> Manager </h1>
 * Kelas Manager digunakan untuk mengatur segala aktivitas yang terjadi di papan / Board yang ditampilkan
 * @author Farhan Ghifari / 13515602
 */
public class Manager extends JPanel implements ActionListener{
    /**
     * ListOfMakhluk adalah variabel bertipe List<Makhluk>
     * untuk menyimpan list makhluk
     */
    static List<Makhluk> ListOfMakhluk = new ArrayList<Makhluk>();
    /**
     * Board Manager
     */
    Board board = new Board();
    /**
    *   Jumlah makhluk yang telah dimunculkan
    */
    int nSpawned;
    /**
     *  Jumlah makhluk yang masih ada di board
     */
    int nLife;

    private Timer timer;
    private Craft craft;
    private int DELAY;
    private boolean isPlayerDead;
    private int counter;
    
    
    /**
     * 
     * @param x parameter untuk membuat makhluk sebanyak x
     * @param _board parameter inisialisasi board
     */
    public Manager(int x){
       
        nSpawned = 0;
        nLife = 0;
        for (int i=1;i<=x;i++) {
            spawn();
        }
        spawnRumput();
        DELAY = 10;
        counter = 0;
        addKeyListener(new TAdapter());
        setFocusable(true);
        isPlayerDead = false;
        setBackground(Color.BLACK);

        craft = new Craft();
        timer = new Timer(DELAY, this);
        timer.start();       
    }
    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        moveAll();
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);  
        Rectangle player = new Rectangle(craft.getX(), craft.getY(),5,5);

        Iterator it  =  ListOfMakhluk.iterator();



        while (it.hasNext()) {
            Makhluk makhluk = (Makhluk) it.next();
            boolean isEatable = false;
            if( (makhluk.GetKarakter() == 'R') || (makhluk.GetKarakter() == 'X')){
                isEatable = true;
            }

            Image image;
            ImageIcon ii = new ImageIcon("ayam.png");
            image = ii.getImage();
            g2d.drawImage(makhluk.getImage(), makhluk.getX(), makhluk.getY(), this); 
            Rectangle enemy = new Rectangle(makhluk.getX(), makhluk.getY(),10,10);
            if( enemy.intersects(player)){
                if(isEatable){
                    ListOfMakhluk.remove(makhluk);
                    spawnRumput();
                    spawnRandomAmount();
                    counter++;
                    if (counter == 5){
                        if ( DELAY >= 2){
                            DELAY--;
                            counter = 0;
                        }

                    }
                }
                else {
                    craft.changeCraft();   
                    isPlayerDead = true;   
                }
            }
        }



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        craft.move();
        repaint();  
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            if( !isPlayerDead){
                craft.keyReleased(e);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (!isPlayerDead){
                craft.keyPressed(e);
            }
        }
    }






    /**
     * spawn adalah prosedur untuk memunculkan satu makhluk
     */
    void spawn(){
        int id,classType;
        int coordinate[];
        boolean isCoordinateAvailable = false;
        Random rand = new Random();
        Makhluk t;
        t = new Elang(0,0,0);
            
            /// cek apakah berjalan baik disini saat passing parameter
        coordinate = board.getAvailableCoordinate();

        nSpawned++;
        nLife++;
        id = nSpawned;

        classType = rand.nextInt(4) + 1;
        switch (classType) {
            case 1  :   t = new Elang(id,coordinate[0],coordinate[1]);
                                break;
            case 2  :   t = new Ayam(id,coordinate[0],coordinate[1]);
                                break;
            case 3  :   t = new Cacing(id,coordinate[0],coordinate[1]);
                                break;
            case 4  :   t = new Rumput(id,coordinate[0],coordinate[1]);
                                break;
        }
        ListOfMakhluk.add(t);
        board.setPoint(coordinate[0],coordinate[1], t.GetKarakter(), id);
    }

    void spawnRumput(){

        int id,classType;
        int coordinate[];
        boolean isCoordinateAvailable = false;
        Random rand = new Random();
        Makhluk t;
        t = new Elang(0,0,0);
            
            /// cek apakah berjalan baik disini saat passing parameter
        coordinate = board.getAvailableCoordinate();

        nSpawned++;
        nLife++;
        id = nSpawned;

     
        t = new Rumput(id,coordinate[0],coordinate[1]);
                              
        ListOfMakhluk.add(t);
        board.setPoint(coordinate[0],coordinate[1], t.GetKarakter(), id);


    }
    
    
    /**
     * spawnRandomAmount adalah prosedur untuk memunculkan makhluk dengan banyaknya random
     */
    void spawnRandomAmount(){
        Random rand = new Random();
        int amount = rand.nextInt(7) + 1;
        for (int i = 1 ; i<amount ; i++) spawn(); 
    }
    
    /**
     * moveAll adalah prosedur untuk membuat semua makhluk bergerak / berpindah
     */
    void moveAll(){
        int oldX,oldY,newX,newY;
        boolean isCoordinateAvailable ;
        
        for (int i=0; i < ListOfMakhluk.size() ; i++) {
            Iterator makluk = ListOfMakhluk.listIterator(i);
            oldX = ListOfMakhluk.get(i).getX();
            oldY = ListOfMakhluk.get(i).getY();
            isCoordinateAvailable = false;

            ListOfMakhluk.get(i).gerak();
            newX = ListOfMakhluk.get(i).getX();
            newY = ListOfMakhluk.get(i).getY();
            if (board.isCoordinateAvailable(newX,newY)==1) {
                isCoordinateAvailable = true;
                board.clearPoint(oldX,oldY,ListOfMakhluk.get(i).GetID());
                board.setPoint(newX,newY,ListOfMakhluk.get(i).GetKarakter(),ListOfMakhluk.get(i).GetID());
            }
            else {
                ListOfMakhluk.get(i).SetPoint(oldX,oldY);
            }
            
    
        }
        resolveConflict();
    }

    /**
     * prosedur untuk menampilkan semua makhluk yang ada di dalam list
     */
    void displayListOfMakhluk(){
        for (int i=0; i < ListOfMakhluk.size() ; i++) {
            System.out.println("ID : " + ListOfMakhluk.get(i).GetID() +
                    " position " + ListOfMakhluk.get(i).getX() + " + " +
                    ListOfMakhluk.get(i).getY());
        }
    }

    /**
     * resolveConflict adalah prosedur untuk menyelesaikan masalah tabrakan yang terjadi di board
     */
    void resolveConflict(){
        int id[];
        char ch[];


        for (int y  = 0 ; y <30 ; y++) {
            for (int x = 0 ; x<80 ;x++ ){
                if (board.isConflictArea(x,y) ){
                    id = board.getFighterID(x,y);
                    ch = board.getFighterClass(x,y);
                    char C1 = ch[0];
                    char C2 = ch[1];
                    int ID1 = id[0];
                    int ID2 = id[1];
                    
                    if (((C1 == 'E') && (C2=='A')) || (C1 == C2) || ((C1 == 'A') && (C2 == 'C'))
                    || ((C1 == 'E') && (C2=='C')) || (C2 == 'R') || ((C1=='X') && (C2=='E'))){
                        board.clearPoint(x,y,ID2);
                        kill(ID2);
                    }
                    else {
                        board.clearPoint(x,y,ID1);
                        kill(ID1);
                    }
                    nLife--;
                }
            }
        }

    }

    
    /**
     * kill adalah prosedur untuk membunuh makhluk dengan id = ID
     * @param ID adalah parameter untuk membuat makhluk yang memiliki id = ID terbunuh
     */
    void kill(int ID){
        boolean done = false;
        int IDtarget, i=0;
        Iterator<Makhluk> ci = ListOfMakhluk.iterator();

        while (ci.hasNext() && (!done)) {
            IDtarget = ListOfMakhluk.get(i).GetID();
            if (IDtarget == ID) {
                ListOfMakhluk.remove(i);
                done = true;
            }
            else {
                ci.next();
            }
            i++;
        }   

    }
    
    
}
