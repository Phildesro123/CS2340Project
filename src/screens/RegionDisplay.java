package screens;

import models.Player;
import models.Region;

import java.awt.*;
import javax.swing.*;


public class RegionDisplay {
    private Player player;
    protected Region region;
    protected JPanel panel = new JPanel();

    public RegionDisplay(Player player) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.player = player;
        region = player.getCurrentRegion();
        JLabel regionName = new JLabel("Region: " + region.getName() + "\n");
        JLabel xCoor = new JLabel("X Coordinate: " + region.getX() + "\n");
        JLabel yCoor = new JLabel("Y Coordinate: " + region.getY() + "\n");
        JLabel techLevel = new JLabel("Tech Level: " + region.getTechLevel() + "\n");
        panel.add(regionName);
        panel.add(xCoor);
        panel.add(yCoor);
        panel.add(techLevel);
        panel.setPreferredSize(new Dimension(640, 480));
        JFrame f = new JFrame("Current Region");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(getMainComponent());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }
    public JComponent getMainComponent() {
        return panel;
    }

}
