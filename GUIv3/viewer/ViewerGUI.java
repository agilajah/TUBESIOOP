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
    private Craft craft;
    /**
     * delay untuk delay.
     */
    private int delay;
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

    /**
     * konstruktor kelas viewer versi grafis.
     */
    public ViewerGUI() {
        myManager = new Manager(TEN);
        delay = FIVE;
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        craft = new Craft();
        timer = new Timer(delay, this);
        timer.start();
        isPlayerDead = false;
        points = 0;
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
        myManager.moveAll();
        if (isPlayerDead) {
            doDrawing(g);
            overDrawing(g);
        } else {
            doDrawing(g);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * overDrawing means after drawing done.
     * @param g
     */
    private void overDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        try {
            ImageIcon ii = createImageIcon("go.png");
            Image image = ii.getImage();
            g2d.drawImage(image, Settings.BOARD_WIDTH / 2,
                    Settings.BOARD_HEIGHT / 2, this);
        } catch (ImageException e) {
            System.out.println("Error occured when trying"
                    + "to get image for ViewGUI class: " + e.getMessage());
        }

    }

    /**
     * mulai menggambar.
     * @param g
     */
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font(Font.DIALOG, Font.BOLD, FOURTY));
        FontMetrics fm = g.getFontMetrics();
        String msg = Integer.toString(points);
        int msgWidth = fm.stringWidth(msg);
        int msgAscent = fm.getAscent();
        g2d.drawString(msg, Settings.BOARD_WIDTH + THIRTY, SIXTY);

        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
        Rectangle player = new Rectangle(craft.getX(),
                                        craft.getY(), FIVETEEN, FIVETEEN);

        Iterator it  =  Manager.ListOfMakhluk.iterator();

        while (it.hasNext()) {
            Makhluk makhluk = (Makhluk) it.next();
            boolean isEatable = false;
            int counterRumput = 0;

            if ((makhluk.getKarakter() == 'R')
                    || (makhluk.getKarakter() == 'X')) {
                isEatable = true;
            }

            ImageIcon ii = new ImageIcon("ayam.png");
            Image image = ii.getImage();

            g2d.drawImage(makhluk.getImage(), makhluk.getX(),
                            makhluk.getY(), this);
            Rectangle enemy;

            if (makhluk.getKarakter() == 'X') {
                enemy = new Rectangle(makhluk.getX(),
                                        makhluk.getY(), THREE, THREE);
            } else {
                enemy = new Rectangle(makhluk.getX(), makhluk.getY(), TEN, TEN);
            }

            if (enemy.intersects(player)) {
                if (isEatable) {
                        Manager.ListOfMakhluk.remove(makhluk);
                        myManager.spawnRumput();
                        myManager.spawnRandomAmount();
                        counter++;
                        points++;
                        if (counter == FIVE && delay >= TWO) {
                            delay--;
                            counter = ZERO;
                        }
                } else {
                    craft.changeCraft();
                    isPlayerDead = true;
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
        craft.move();
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
                craft.keyReleased(e);
            }
        }

        /**
         * saat key di tekan.
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {
            if (!isPlayerDead) {
                craft.keyPressed(e);
            }
        }
    }
}