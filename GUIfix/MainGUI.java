import java.awt.EventQueue;
import javax.swing.JFrame;

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