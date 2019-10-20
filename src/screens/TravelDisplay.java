package screens;

import models.Game;
import models.Travel;
import models.Ship;


import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class TravelDisplay {
    private Travel travel;
    //private Player player;
    private Ship ship;
    protected JPanel panel = new JPanel();
    protected JFrame f = new JFrame("Current Region");

    public TravelDisplay(Game game, double dist) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //Universe universe = game.getUniverse();
        //player = game.getPlayer();
        travel = game.getTravel();
        ship = game.getShip();
        int cost = travel.fuelCost(dist);
        int currFuel = ship.getFuel();
        JLabel fuelCost = new JLabel("Fuel need to travel: " + cost + "\n");
        JLabel currShipFuel = new JLabel("Current amount of fuel" + currFuel
                + "\n");
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
        panel.setPreferredSize(new Dimension(640, 480));

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(getMainComponent());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public JComponent getMainComponent() {
        return panel;
    }

    public void hide() {
        f.setVisible(false);
        f.dispose();
    }
}
