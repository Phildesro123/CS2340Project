package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import models.*;
import models.enums.Difficulty;


public class DisplayScreen {
    private Player player;
    protected JFrame f = new JFrame("Display Page");
    protected JPanel disp = new JPanel();

    public DisplayScreen(Game game) {
        disp.setLayout(new BoxLayout(disp, BoxLayout.Y_AXIS));
        player = game.getPlayer();
        Ship ship = player.getShip();
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
        JLabel engineerSkills = new JLabel("<html>Engineer: " + skillpoints[3] + "<br></html>");
        JButton nextPage = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegionDisplay display = new RegionDisplay(game);
                hide();
            }
        });
        JLabel shipName = new JLabel("Ship Type: " + ship.getShipType().getName() + "\n");
        JLabel shipDesc = new JLabel("<html> <i>" + ship.getShipType().getDesc()
                + "</i><br>" + "</html>");
        JLabel shipStats = new JLabel("<html>Health: " + ship.getShipType().shipHealth()
                + "<br>Fuel: " + ship.getShipType().shipFuel()
                + "<br>Cargo Space: " + ship.getShipType().cargoSpace() + "</html>");
        nextPage.setText("Confirm and start");


        disp.setPreferredSize(new Dimension(640, 480));
        disp.add(playerName);
        disp.add(difficulty);
        disp.add(startingCredits);
        disp.add(pilotSkill);
        disp.add(fighterSkills);
        disp.add(merchantSkills);
        disp.add(engineerSkills);
        disp.add(shipName);
        disp.add(shipDesc);
        disp.add(shipStats);
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

    private JComponent getMainComponent() {
        return disp;
    }
}
