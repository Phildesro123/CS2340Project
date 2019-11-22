package screens;

import javax.swing.*;
import java.awt.*;

public class GameOver {
    public GameOver(Boolean win) {
        if (win) {
            String[] options = {"Restart", "Nah I'm Good"};
            int selectedValue = JOptionPane.showOptionDialog(null,
                    "Congrats you won! Wannna play again?",
                    "Game Over",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options, options[0]);
            if (selectedValue == 0) {
                Welcome welcomeScreen = new Welcome();
            } else {
                JOptionPane.getRootFrame().dispose();
            }
        } else {
            String[] options = {"Restart", "Nah I'm Good"};
            int selectedValue = JOptionPane.showOptionDialog(null,
                    "Sorry Dude/ Dudette :( Wannna play again?",
                    "Game Over",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options, options[0]);
            if (selectedValue == 0) {
                Welcome welcomeScreen = new Welcome();
            } else {
                JOptionPane.getRootFrame().dispose();
            }
        }
    }
}
