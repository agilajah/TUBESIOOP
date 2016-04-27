package controller;

import model.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;

/**
 * .<h1> Manager </h1>
 * Kelas Manager digunakan untuk mengatur segala aktivitas yang 
 * terjadi di papan / Board yang ditampilkan
 * @author Farhan Ghifari / 13515602
 */
public class Manager {
    /**
     * .ListOfMakhluk adalah variabel list generik gertipe makhluk
     * digunakan untuk menyimpan list makhluk
     */
    public static List<Makhluk> ListOfMakhluk = new ArrayList<Makhluk>();
    /**
     * .Board Manager
     */
    Board board = new Board();
    /**
    * .Jumlah makhluk yang telah dimunculkan
    */
    int nSpawned;
    /**
     *.Jumlah makhluk yang masih ada di board
     */
    int nLife;

    private Timer timer;
    private Craft craft;
    private int DELAY;
    private boolean isPlayerDead;
    private int counter;


    /**
     * konstruktor kelas manager.
     * @param x parameter untuk membuat makhluk sebanyak x
     */
    public Manager(int x) {
        nSpawned = 0;
        nLife = 0;
        counter = 0;

        for (int i = 1; i <= x;i++) {
            spawn();
        }
        spawnRumput();   
    }
    
    /**
     * .spawn adalah prosedur untuk memunculkan satu makhluk
     */
    void spawn() {
        boolean isCoordinateAvailable = false;
        Makhluk t;
        t = new Elang(0, 0, 0);
        int[] coordinate;

        /// cek apakah berjalan baik disini saat passing parameter
        coordinate = board.getAvailableCoordinate();
        nSpawned++;
        nLife++;

        int id = nSpawned;
        int classType;
        Random rand = new Random();
        classType = rand.nextInt(4) + 1;
        switch (classType) {
            case 1:
                t = new Elang(id, coordinate[0], coordinate[1]);
                break;
            case 2:
                t = new Ayam(id, coordinate[0], coordinate[1]);
                break;
            case 3:
                t = new Cacing(id, coordinate[0], coordinate[1]);
                break;
            case 4:
                t = new Rumput(id, coordinate[0], coordinate[1]);
                break;
            default:
                assert false;
        }
        ListOfMakhluk.add(t);
        board.setPoint(coordinate[0], coordinate[1], t.getKarakter(), id);
    }

    public void spawnRumput() {

        int classType;
        int[] coordinate;
        boolean isCoordinateAvailable = false;
        Random rand = new Random();
        Makhluk t;
        t = new Elang(0,0,0);
            
        /// cek apakah berjalan baik disini saat passing parameter
        coordinate = board.getAvailableCoordinate();
        nSpawned++;
        nLife++;
        int id = nSpawned;


        t = new Rumput(id,coordinate[0],coordinate[1]);

        ListOfMakhluk.add(t);
        board.setPoint(coordinate[0],coordinate[1], t.getKarakter(), id);
    }
    
    
    /**
     * .prosedur untuk memunculkan makhluk dengan banyaknya random
     */
    public void spawnRandomAmount() {
        Random rand = new Random();
        int amount = rand.nextInt(7) + 1;
        assert amount>0: "random amount = " + amount;
        for (int i = 1 ; i < amount ; i++) { 
            spawn(); 
        }
    }
    
    /**
     * .moveAll adalah prosedur untuk membuat semua makhluk bergerak / berpindah
     */
    public void moveAll() {
        boolean isCoordinateAvailable ;
  
        for (int i = 0; i < ListOfMakhluk.size() ; i++) {
            Iterator makluk = ListOfMakhluk.listIterator(i);
            int oldX = ListOfMakhluk.get(i).getX();
            int oldY = ListOfMakhluk.get(i).getY();
            isCoordinateAvailable = false;

            ListOfMakhluk.get(i).gerak();
            int newX = ListOfMakhluk.get(i).getX();
            int newY = ListOfMakhluk.get(i).getY();
            if (board.isCoordinateAvailable(newX,newY) == 1) {
                isCoordinateAvailable = true;
                board.clearPoint(oldX,oldY,ListOfMakhluk.get(i).getId());
                board.setPoint(newX,newY,ListOfMakhluk.get(i)
                      .getKarakter(),ListOfMakhluk.get(i).getId());
            } else {
                ListOfMakhluk.get(i).setPoint(oldX,oldY);
            }
            
    
        }
        resolveConflict();
    }

    /**
     * .prosedur untuk menampilkan semua makhluk yang ada di dalam list
     */
    void displayListOfMakhluk() {
        for (int i = 0; i < ListOfMakhluk.size() ; i++) {
            System.out.println("ID : " + ListOfMakhluk.get(i).getId() 
                    + " position " + ListOfMakhluk.get(i).getX() + " + "
                    + ListOfMakhluk.get(i).getY());
        }
    }

    /**
     * .resolveConflict adalah prosedur untuk menyelesaikan masalah tabrakan yang terjadi di board
     */
    void resolveConflict() {
        int[] id;
        char[] ch;


        for (int y  = 0 ; y < 30 ; y++) {
            for (int x = 0 ; x < 80 ;x++ ) {
                if (board.isConflictArea(x,y) ) {
                    id = board.getFighterID(x,y);
                    ch = board.getFighterClass(x,y);
                    char C1 = ch[0];
                    char C2 = ch[1];
                    int ID1 = id[0];
                    int ID2 = id[1];
                    
                    if (((C1 == 'E') && (C2 == 'A')) 
                        || (C1 == C2) || ((C1 == 'A') && (C2 == 'C'))
                        || ((C1 == 'E') && (C2 == 'C')) || (C2 == 'R') 
                        || ((C1 == 'X') && (C2 == 'E'))) {
                        board.clearPoint(x,y,ID2);
                        kill(ID2);
                    } else {
                        board.clearPoint(x,y,ID1);
                        kill(ID1);
                    }
                    nLife--;
                }
            }
        }

    }

    /**
     * .kill adalah prosedur untuk membunuh makhluk dengan id = ID
     * @param ID adalah parameter untuk membuat makhluk yang memiliki id = ID terbunuh
     */
    void kill(int ID) {
        boolean done = false;
        int i = 0;
        Iterator<Makhluk> ci = ListOfMakhluk.iterator();

        while (ci.hasNext() && (!done)) {
            int IDtarget = ListOfMakhluk.get(i).getId();
            if (IDtarget == ID) {
                ListOfMakhluk.remove(i);
                done = true;
            } else {
                ci.next();
            }
            i++;
        }   

    }
    
    /**
    * Untuk menghitung jumlah element board yang kosong ada berapa
    * Element dikatakan kosong jika slot satu dan slot dua kosong.
    * @return jumlah slot kosong
    */
    public int getCountEmptySlot(){
        return board.getEmptySlot();
    }
}
