package screens;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome {
    JPanel wel = new JPanel();
    JLabel text = new JLabel("Welcome");
    Font font = new Font("Calibri (Body)", Font.BOLD, 100);
    JButton button = new JButton("Start");

    public Welcome() {
       text.setFont(font);
       wel.setPreferredSize(new Dimension(640, 480));
       wel.add(text);
       wel.add(button);

        JFrame f = new JFrame("SpaceTrader");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomizationPage customizationPage = new CustomizationPage();
                f.setVisible(false);
            }
        });
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(getMainComponent());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    public JComponent getMainComponent() {
      return wel;
    }
}