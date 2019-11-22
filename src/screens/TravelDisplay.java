package screens;

import models.Game;
import models.Travel;
<<<<<<< HEAD
import models.Ship;


=======
>>>>>>> 1f51a90e32352eaa87c1e2c7552b15131f7de36d
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class TravelDisplay {
    private Travel travel;
<<<<<<< HEAD
    //private Player player;
    private Ship ship;
    protected JPanel panel = new JPanel();
    protected JFrame f = new JFrame("Failed to Travel");
=======
    private JPanel panel = new JPanel();
    private JFrame f = new JFrame("Failed to Travel");
>>>>>>> 1f51a90e32352eaa87c1e2c7552b15131f7de36d

    public TravelDisplay(Game game, double dist) {
        Font font;
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
<<<<<<< HEAD
        //Universe universe = game.getUniverse();
        //player = game.getPlayer();
        travel = game.getTravel();
        ship = game.getShip();
        int cost = travel.fuelCost(dist);
        int currFuel = ship.getFuel();
=======
        travel = new Travel(game.getDifficulty().modifier(), game.getPlayer().getSkillSet());
        int cost = travel.fuelCost(dist);
        double currFuel = game.getPlayer().getShip().getFuel();
        System.out.println(game.getPlayer().getShip().getFuel());
        System.out.println(game.getPlayer().getShip().getFuel());
>>>>>>> 1f51a90e32352eaa87c1e2c7552b15131f7de36d
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

<<<<<<< HEAD
    public JComponent getMainComponent() {
        return panel;
    }

    public void hide() {
=======
    private JComponent getMainComponent() {
        return panel;
    }

    private void hide() {
>>>>>>> 1f51a90e32352eaa87c1e2c7552b15131f7de36d
        f.setVisible(false);
        f.dispose();
    }
}
