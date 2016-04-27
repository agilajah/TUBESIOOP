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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <h1> Manager </h1>
 * Kelas Manager digunakan untuk mengatur segala aktivitas yang terjadi di papan / Board yang ditampilkan
 * @author Farhan Ghifari / 13515602
 */
public class ViewerGUI extends JPanel implements ActionListener{
    /**
     * ListOfMakhluk adalah variabel bertipe List<Makhluk>
     * untuk menyimpan list makhluk

    /**
     * Board Manager
     */
   

    private Timer timer;
    private Craft craft1;
    private Craft craft2;
    private int DELAY;
    private int counter;
    private Manager myManager;
    private int points;
    private boolean isGameStart;
    private boolean isSinglePlayer;
    private boolean isPlayer1Dead;
    private boolean isPlayer2Dead;
    private boolean isBothPlayerDead;
    
    /**
     * 
     * @param x parameter untuk membuat makhluk sebanyak x
     * @param _board parameter inisialisasi board
     */
    public ViewerGUI(){
        myManager = new Manager(10);
        DELAY = 5;  
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        craft1 = new Craft(1);
        craft2 = new Craft(2);
        timer = new Timer(DELAY, this);
        timer.start();       
        isPlayer1Dead = false;
        isPlayer2Dead = false;
        isBothPlayerDead = false;
        points = 0;
        isGameStart = false;
        isSinglePlayer = true;

    }
    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (!isGameStart){
            drawStartScreen(g);
        }
        else {
            myManager.moveAll();
            if (isPlayer1Dead && isPlayer2Dead){
                drawGameOverScreen(g);
                doDrawing(g);
                
                drawScore(g);
            }
            else {
                doDrawing(g);
                drawScore(g);
            }
    
        }   
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawStartScreen(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        ImageIcon ii;
        if (isSinglePlayer) {
            ii = new ImageIcon("start_1.jpg");
        }
        else {
            ii = new ImageIcon("start_2.jpg");
        }
        Image image = ii.getImage();
        g2d.drawImage(image,0,0,this);
    }

    private void drawGameOverScreen(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        ImageIcon ii = new ImageIcon("go.png");
        Image image = ii.getImage();
        g2d.drawImage(image,0,0,this);
    }

    private void drawScore(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Helvetica", Font.BOLD, 40));
        FontMetrics fm = g.getFontMetrics();
        String msg = Integer.toString(points);
        int msgWidth = fm.stringWidth(msg);
        int msgAscent = fm.getAscent();
        g2d.drawString(msg, Settings.BOARD_WIDTH+30, 60);

    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        
        g2d.drawImage(craft1.getImage(), craft1.getX(), craft1.getY(), this); 
        g2d.drawImage(craft2.getImage(), craft2.getX(), craft2.getY(), this); 

        Rectangle player1 = new Rectangle(craft1.getX(), craft1.getY(),15,15);
        Rectangle player2 = new Rectangle(craft2.getX(), craft2.getY(),15,15);

        Iterator it  =  Manager.ListOfMakhluk.iterator();

        while (it.hasNext()) {
            Makhluk makhluk = (Makhluk) it.next();
            boolean isEatable = false;
            int counter_rumput = 0;

            if( (makhluk.GetKarakter() == 'R') || (makhluk.GetKarakter() == 'X') ){
                isEatable = true;
            }
            
           
            ImageIcon ii = new ImageIcon("ayam.png");
            Image image = ii.getImage();
           
            g2d.drawImage(makhluk.getImage(), makhluk.getX(), makhluk.getY(), this); 
            Rectangle enemy;

            if ( makhluk.GetKarakter() == 'X') {
                enemy = new Rectangle(makhluk.getX(), makhluk.getY(),3,3);
            }
            else {
                enemy = new Rectangle(makhluk.getX(), makhluk.getY(),10,10);
            }

            if (((enemy.intersects(player1)) || (enemy.intersects(player2)))) {
                if(isEatable){
                        Manager.ListOfMakhluk.remove(makhluk);
                        myManager.spawnRumput();
                        myManager.spawnRandomAmount();
                        counter++;
                        points++;
                        if (counter == 5){
                            if ( DELAY >= 2){
                                DELAY--;
                                counter = 0;
                            }

                        }
                    
                }
                else {
                    if (enemy.intersects(player1)) {
                        craft1.changeCraft();   
                        
                        isPlayer1Dead = true;
                    }
                    else if (enemy.intersects(player2)){
                        craft2.changeCraft();
                        
                        isPlayer2Dead = true;
                    }

                    if (isPlayer1Dead && isPlayer2Dead) {
                        isBothPlayerDead = true;
                    }
                   

                }
            }
        }



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        craft1.move();
        craft2.move();
        repaint();  
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            if(!isPlayer1Dead){
                craft1.keyReleased(e);
            }
            if(!isPlayer2Dead){
                craft2.keyReleased(e);
            }

           
        
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if(!isPlayer1Dead){
                craft1.keyPressed(e);
            }
            if(!isPlayer2Dead){
                craft2.keyPressed(e);
            }
             if (!isGameStart) {
                if (isSinglePlayer && key == KeyEvent.VK_RIGHT) {
                    isSinglePlayer = false;
                }
                else if (!isSinglePlayer && key == KeyEvent.VK_LEFT){
                    isSinglePlayer = true;
                }
                else if ( key == KeyEvent.VK_ENTER){
                    isGameStart = true;
                    if (isSinglePlayer == true){
                        craft2.hide();
                        isPlayer2Dead = true; 
                    }
                }
            }

            if(isBothPlayerDead && ( key == KeyEvent.VK_ENTER)){
                    isGameStart = true;
                     craft1.initCraft();
                     craft2.initCraft();
                     isBothPlayerDead = false;
                     isPlayer1Dead = false;
                     points = 0;
                        
                    if (isSinglePlayer == true){
                        craft2.hide();
                        isPlayer2Dead = true; 
                    }
                    else {
                        isPlayer2Dead = false;
                    }


            }

        }
    }
}