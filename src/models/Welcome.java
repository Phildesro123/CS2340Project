import javax.swing.*;
import java.awt.*;
public class Welcome {
    JPanel wel = new JPanel();
    JLabel text = new JLabel("Welcome");
    Font font = new Font("Calibri (Body)", Font.BOLD, 100);
    Welcome() {
       text.setFont(font);
       wel.setPreferredSize(new Dimension(640, 480));
       wel.add(text);
    }
    public JComponent getMainComponent() {
      return wel;
    }
    private static void cASGUI(){
        Welcome screen = new Welcome();
        JFrame f = new JFrame("SpaceTrader");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(screen.getMainComponent());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() 
          {
             public void run() 
             {
                cASGUI();
             }
          });
     }
}