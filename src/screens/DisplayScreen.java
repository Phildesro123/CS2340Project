package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import models.*;
import screens.RegionDisplay;
import models.enums.Difficulty;


public class DisplayScreen {
    private Player player;
    private JLabel text;
    protected JFrame f = new JFrame("SpaceTrader Stats");
    protected JPanel disp = new JPanel();

    public DisplayScreen(Game game) {
        text = new JLabel("Display Page");
        disp.setLayout(new BoxLayout(disp, BoxLayout.Y_AXIS));
        player = game.getPlayer();
        int[] skillpoints = player.getSkillSet();
        JLabel difficulty = new JLabel("Difficulty: ");
        if (game.getDifficulty() == Difficulty.EASY) {
            difficulty.setText("Difficulty: Easy");
        } else if (game.getDifficulty() == Difficulty.MEDIUM) {
            difficulty.setText("Difficulty: Medium");
        } else if (game.getDifficulty() == Difficulty.HARD) {
            difficulty.setText("Difficulty: Hard");
        }
        JLabel playerName = new JLabel("Name: " + player.getName() + "\n");
        JLabel startingCredits = new JLabel("Starting credits: " + player.getCredits() + "\n");
        JLabel pilotSkill = new JLabel("Pilot: " + skillpoints[0]);
        JLabel fighterSkills = new JLabel("Fighter: " + skillpoints[1]);
        JLabel merchantSkills = new JLabel("Merchant: " + skillpoints[2]);
        JLabel engineerSkills = new JLabel("Engineer: " + skillpoints[3]);
        JButton nextPage = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegionDisplay display = new RegionDisplay(game);
                hide();
            }
        });
        nextPage.setText("Confirm and start");


        disp.setPreferredSize(new Dimension(640, 480));
        disp.add(text, BorderLayout.CENTER);
        disp.add(playerName);
        disp.add(difficulty);
        disp.add(startingCredits);
        disp.add(pilotSkill);
        disp.add(fighterSkills);
        disp.add(merchantSkills);
        disp.add(engineerSkills);
        disp.add(playerName);
        disp.add(nextPage);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(getMainComponent());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private void hide() {
        f.setVisible(false);
        f.dispose();
    }

    public JComponent getMainComponent() {
        return disp;
    }
}
