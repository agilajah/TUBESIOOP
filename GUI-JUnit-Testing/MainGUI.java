/*
 *  This is a game from Cisitu Corps
 *  The name of this game is Ricefield Battle
 *  @CopyRight 2016
 */
package Main;
import java.awt.EventQueue;
import javax.swing.JFrame;
import makhlukcisitu.Settings;
import makhlukcisitu.ViewerGUI;

public class MainGUI extends JFrame {

    public MainGUI() {
        initUI();
    }
    
    private void initUI() {
        add(new ViewerGUI());
        setSize(Settings.BOARD_WIDTH+200, Settings.BOARD_HEIGHT);
        setResizable(false);
        setTitle("Ricefield : Rumble Arena");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainGUI ex = new MainGUI();
                ex.setVisible(true);
            }
        });
    }
}