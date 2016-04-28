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
 * Kelas Manager digunakan untuk mengatur segala aktivitas yang terjadi
 * di papan / Board yang ditampilkan.
 * @author Farhan Ghifari / 13515602
 */

public class ViewerGUI extends JPanel implements ActionListener {
    /**
     * constant value of ten.
     */
    private static final int TEN = 10;
    /**
     * constant value of fourty.
     */
    private static final int FOURTY = 40;
    /**
     * constant value of sixty.
     */
    private static final int SIXTY = 60;
    /**
     * constant value of thirty.
     */
    private static final int THIRTY = 30;
    /**
     * constant value of five.
     */
    private static final int FIVE = 5;
    /**
     * constant value of two.
     */
    private static final int TWO = 2;
    /**
     * constant value of three.
     */
    private static final int THREE = 3;
    /**
     * constant value of zero.
     */
    private static final int ZERO = 0;
    /**
     * constant value of fiveteen.
     */
    private static final int FIVETEEN = 15;
    /**
     * timer untuk menghitung waktu.
     */
    private Timer timer;
    /**
     * variabel craft.
     */
    private Craft craft1;
    /**
     * variabel craft.
     */
    private Craft craft2;
    /**
     * delay untuk delay.
     */
    private int DELAY;
    /**
     * boolean apakah player mati.
     */
    private boolean isPlayerDead;
    /**
     * counter untuk menghitung.
     */
    private int counter;
    /**
     * myManager untuk memanage.
     */
    private Manager myManager;
    /**
     * point.
     */
    private int points;
    private boolean isGameStart;
    private boolean isSinglePlayer;
    private boolean isPlayer1Dead;
    private boolean isPlayer2Dead;
    private boolean isBothPlayerDead;

    /**
     * konstruktor kelas viewer versi grafis.
     */
    public ViewerGUI() {
        myManager = new Manager(TEN);
        DELAY = FIVE;
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

    /**
     * Returns an ImageIcon, or throwing exceptions if the path was invalid.
     * @param imagename
     * @return image
     * @throws ImageException
     */
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
    /**
     * untuk mewarnai background.
     * @param g
     */
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
        try {
            if (isSinglePlayer) {
                ii = createImageIcon("start_1.jpg");
            } else {
                    ii = createImageIcon("start_2.jpg");
            }

            Image image = ii.getImage();
            g2d.drawImage(image, 0, 0, this);
        } catch (ImageException e) {
            System.out.println("Error occured when trying"
                    + "to get image for start screen: " + e.getMessage());
        }
    }

    private void drawGameOverScreen(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        try {
            ImageIcon ii = createImageIcon("go.png");
            Image image = ii.getImage();
            g2d.drawImage(image, 0, 0,this);
        } catch (ImageException e) {
            System.out.println("Error occured when trying"
                    + "to get image for Game Over : " + e.getMessage());
        }

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

    /**
     * mulai menggambar.
     * @param g
     */
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

            if ((makhluk.getKarakter() == 'R')
                    || (makhluk.getKarakter() == 'X')) {
                isEatable = true;
            }

            try {
                ImageIcon ii = createImageIcon("ayam.png");
                Image image = ii.getImage();
            } catch (ImageException e){
                System.out.println("Error occured when trying"
                        + "to get image for Ayam : " + e.getMessage());
            }


            g2d.drawImage(makhluk.getImage(), makhluk.getX(),
                            makhluk.getY(), this);
            Rectangle enemy;

            if (makhluk.getKarakter() == 'X') {
                enemy = new Rectangle(makhluk.getX(),
                                        makhluk.getY(), THREE, THREE);
            } else {
                enemy = new Rectangle(makhluk.getX(), makhluk.getY(), TEN, TEN);
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

                } else {
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

    /**
     * actionPerformed.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        craft1.move();
        craft2.move();
        repaint();
    }

    /**
     * TAdapter.
     */
    private class TAdapter extends KeyAdapter {
        /**
         * saat key di release.
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
            if (!isPlayerDead) {
                craft1.keyReleased(e);
            }
            if(!isPlayer2Dead) {
                craft2.keyReleased(e);
            }
        }

        /**
         * saat key di tekan.
         * @param e
         */
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