/*
 *  This is a game from Cisitu Corps
 *  The name of this game is Ricefield Battle
 *  @CopyRight 2016
 */
package makhlukcisitu;

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
    */
    
    //* Board Manager
     
   

    private Timer timer;
    private Craft craft;
    private int DELAY;
    private boolean isPlayerDead;
    private int counter;
    private Manager myManager;
    private int points;
    
    
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
        craft = new Craft();
        timer = new Timer(DELAY, this);
        timer.start();       
        isPlayerDead = false;
        points = 0;
    }
    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        myManager.moveAll();
        if (isPlayerDead){
            doDrawing(g);
            overDrawing(g);
        }
        else {
            doDrawing(g);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    private void overDrawing (Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        ImageIcon ii = new ImageIcon("go.png");
        Image image = ii.getImage();
        g2d.drawImage(image,Settings.BOARD_WIDTH/2,Settings.BOARD_HEIGHT/2,this);
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
        FontMetrics fm = g.getFontMetrics();
        String msg = Integer.toString(points);
        int msgWidth = fm.stringWidth(msg);
        int msgAscent = fm.getAscent();
        g2d.drawString(msg, Settings.BOARD_WIDTH+30, 60);

        


        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);  
        Rectangle player = new Rectangle(craft.getX(), craft.getY(),15,15);

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

            if( enemy.intersects(player)){
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
}