package screens;

import models.Game;
import models.Travel;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class TravelDisplay {
    private Travel travel;
    private JPanel panel = new JPanel();
    private JFrame f = new JFrame("Failed to Travel");

    public TravelDisplay(Game game, double dist) {
        Font font;
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        travel = new Travel(game.getDifficulty().modifier(), game.getPlayer().getSkillSet());
        int cost = travel.fuelCost(dist);
        double currFuel = game.getPlayer().getShip().getFuel();
        System.out.println(game.getPlayer().getShip().getFuel());
        System.out.println(game.getPlayer().getShip().getFuel());
        JLabel fuelCost = new JLabel("Fuel need to travel: " + cost + "\n",
                SwingConstants.CENTER);
        JLabel currShipFuel = new JLabel("Current amount of fuel: " + currFuel
                + "\n", SwingConstants.CENTER);
        font = new Font("Calibri (Body)", Font.BOLD, 15);
        fuelCost.setFont(font);
        currShipFuel.setFont(font);
        JButton openMap = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map map = new Map(game);
                hide();
            }
        });
        openMap.setText("Open Map");
        panel.add(fuelCost);
        panel.add(currShipFuel);
        panel.add(openMap);
        panel.setPreferredSize(new Dimension(320, 120));

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(getMainComponent());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private JComponent getMainComponent() {
        return panel;
    }

    private void hide() {
        f.setVisible(false);
        f.dispose();
    }
}
