package screens;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.*;


public class DisplayScreen {
    Game game;
    Player player;
    JLabel text = new JLabel("Display Page");
    protected JPanel disp = new JPanel();
    public DisplayScreen(Game game) {
        disp.setPreferredSize(new Dimension(640, 480));
        disp.add(text);

        JFrame f = new JFrame("SpaceTrader");

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(getMainComponent());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    public JComponent getMainComponent() {
        return disp;
    }
}
