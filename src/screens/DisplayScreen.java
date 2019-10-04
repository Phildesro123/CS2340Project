package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.*;


public class DisplayScreen {
    private Game game;
    private Player player;
    JLabel text = new JLabel("Display Page");
    protected JPanel disp = new JPanel();

    public DisplayScreen(Game game) {
        disp.setLayout(new BoxLayout(disp, BoxLayout.Y_AXIS));
        this.game = game;
        player = game.getPlayer();
        int[] skillpoints = player.getSkillSet();
        JLabel difficulty = new JLabel("Difficulty: ");
        if (game.getDifficulty() == 16) {
            difficulty.setText("Difficulty: Easy");
        } else if (game.getDifficulty() == 12) {
            difficulty.setText("Difficulty: Medium");
        } else if (game.getDifficulty() == 8) {
            difficulty.setText("Difficulty: Hard");
        }
        JLabel playerName = new JLabel("Name: " + player.getName() + "\n");
        JLabel startingCredits = new JLabel("Starting credits: " + player.getCredits() + "\n");
        JLabel pilotSkill = new JLabel("Pilot: " + skillpoints[0]);
        JLabel fighterSkills = new JLabel("Fighter: " + skillpoints[1]);
        JLabel merchantSkills = new JLabel("Merchant: " + skillpoints[2]);
        JLabel engineerSkills = new JLabel("Engineer: " + skillpoints[3]);


        disp.setPreferredSize(new Dimension(640, 480));
        disp.add(text, BorderLayout.CENTER);
        disp.add(playerName);
        disp.add(difficulty);
        disp.add(startingCredits);
        disp.add(pilotSkill);
        disp.add(fighterSkills);
        disp.add(merchantSkills);
        disp.add(engineerSkills);
        JFrame f = new JFrame("SpaceTrader Stats");
        disp.add(playerName);
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
