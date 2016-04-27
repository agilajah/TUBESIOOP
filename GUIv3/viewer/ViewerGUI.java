package viewer;

import model.Settings;
import model.Makhluk;
import controller.Manager;
import model.Craft;
import model.ImageException;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.net.URL;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * .<h1> Manager </h1>
 * Kelas Manager digunakan untuk mengatur segala aktivitas yang terjadi 
 * di papan / Board yang ditampilkan
 * @author Farhan Ghifari / 13515602
 */

public class ViewerGUI extends JPanel implements ActionListener {
    /**
     * .ListOfMakhluk adalah variabel bertipe List of Makhluk
     * untuk menyimpan list makhluk
     * Board Manager
     */
   
    private Timer timer;
    private Craft craft;
    private int DELAY;
    private boolean isPlayerDead;
    private int counter;
    private Manager myManager;
    private int points;
    
    /**
     * .konstruktor kelas viewer versi grafis
     */
    public ViewerGUI() {
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

    /** Returns an ImageIcon, or throwing exceptions if the path was invalid. */
    private ImageIcon createImageIcon(String imagename) throws ImageException {
        String path = "/gambar/" + imagename;
        //URL imgURL = new URL(path);
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            throw new ImageException("Image not found!");
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        myManager.moveAll();
        if (isPlayerDead) {
            doDrawing(g);
            overDrawing(g);
        } else {
            doDrawing(g);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    private void overDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        try {
            ImageIcon ii = createImageIcon("go.png");
            Image image = ii.getImage();
            g2d.drawImage(image, Settings.BOARD_WIDTH / 2, Settings.BOARD_HEIGHT / 2,this);
        }
        catch (ImageException e) {
            System.out.println("Error occured when trying to get image for ViewGUI class: " + e.getMessage());
        }

    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
        FontMetrics fm = g.getFontMetrics();
        String msg = Integer.toString(points);
        int msgWidth = fm.stringWidth(msg);
        int msgAscent = fm.getAscent();
        g2d.drawString(msg, Settings.BOARD_WIDTH + 30, 60);

        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);  
        Rectangle player = new Rectangle(craft.getX(), craft.getY(),15,15);

        Iterator it  =  Manager.ListOfMakhluk.iterator();

        while (it.hasNext()) {
            Makhluk makhluk = (Makhluk) it.next();
            boolean isEatable = false;
            int counterRumput = 0;

            if ( (makhluk.getKarakter() == 'R') || (makhluk.getKarakter() == 'X') ) {
                isEatable = true;
            }
            
           
            ImageIcon ii = new ImageIcon("ayam.png");
            Image image = ii.getImage();
           
            g2d.drawImage(makhluk.getImage(), makhluk.getX(), makhluk.getY(), this); 
            Rectangle enemy;

            if ( makhluk.getKarakter() == 'X') {
                enemy = new Rectangle(makhluk.getX(), makhluk.getY(),3,3);
            } else {
                enemy = new Rectangle(makhluk.getX(), makhluk.getY(),10,10);
            }

            if ( enemy.intersects(player)) {
                if (isEatable) {
                        Manager.ListOfMakhluk.remove(makhluk);
                        myManager.spawnRumput();
                        myManager.spawnRandomAmount();
                        counter++;
                        points++;
                        if (counter == 5) {
                            if ( DELAY >= 2) {
                                DELAY--;
                                counter = 0;
                            }

                        }
                    
                } else {
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
            if ( !isPlayerDead) {
                craft.keyReleased(e);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (!isPlayerDead) {
                craft.keyPressed(e);
            }
        }
    }
}