package screens;

import models.Game;
import models.Player;
import models.Region;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class RegionDisplay {
    //This will display the region's market and stuff
    //Should display player's fuel
    //Will handle price calculation(?)
    private Player player;
    protected Region region;
    protected JPanel panel = new JPanel();
    protected JFrame f = new JFrame("Current Region");

    public RegionDisplay(Game game) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.player = game.getPlayer();
        System.out.println(player);
        region = player.getCurrentRegion();
        System.out.println(region);
        System.out.println(region.getName());
        System.out.println(region.getMarket());
        JLabel regionName = new JLabel("Region: " + region.getName() + "\n");
        JLabel xCoor = new JLabel("X Coordinate: " + region.getX() + "\n");
        JLabel yCoor = new JLabel("Y Coordinate: " + region.getY() + "\n");
        JLabel techLevel = new JLabel("Tech Level: "
                + region.getTechLevel() + "\n");
        JButton openMap = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map map = new Map(game);
                hide();
            }
        });
        openMap.setText("Open Map");
        panel.add(regionName);
        panel.add(xCoor);
        panel.add(yCoor);
        panel.add(techLevel);
        panel.add(openMap);
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

<<<<<<< HEAD
    private void hide() {
        f.setVisible(false);
        f.dispose();
    }

//    public static void main(String[] args) {
//        RegionDisplay rg = new RegionDisplay();
//    }
=======
>>>>>>> Region display in branch
}
