package screens;

import models.CalculatorController;
import models.Game;
import models.Item;
import models.Player;
import models.Region;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class RegionDisplay {
    //This will display the region's market and stuff
    //Should display player's fuel


    //Getting rid of player instance variable soon
    //Should not have an instance of player, just get it from the game
    private CalculatorController calc;
    private Player player;
    private Region region;
    private JPanel holder = new JPanel();
    private JFrame frame = new JFrame("Current Region");

    public RegionDisplay(Game game) {
        calc = new CalculatorController();
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        holder.setLayout(new BoxLayout(holder, BoxLayout.Y_AXIS));
        //Make a method that returns a panel and add it to buttons
        player = game.getPlayer();
        region = player.getCurrentRegion();
        JLabel regionName = new JLabel("Region: " + region.getName() + "\n");
        JLabel xCoor = new JLabel("X Coordinate: " + region.getX() + "\n");
        JLabel yCoor = new JLabel("Y Coordinate: " + region.getY() + "\n");
        JLabel playerCreds = new JLabel("Credits: " + player.getCredits());
        JLabel inventory = new JLabel("Current cargo: ");
        for (Item i : player.getShip().getCargo()) {
            inventory.setText(inventory.getText() + i.getName() + ", ");
        }
        JLabel techLevel = new JLabel("Tech Level: "
                + region.getTechLevel() + "\n");
        JButton openMap = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map map = new Map(game);
                hide();
            }
        });
        holder.add(inventory);
        buttons.add(playerCreds);
        for (Item i : region.getMarket().getItems()) {
            JPanel tempPanel = new JPanel();
            tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.X_AXIS));
            tempPanel.add(new JLabel("Buying Price: "
                    + calc.priceBuyCalculator(player, region, i)));
            tempPanel.add(Box.createRigidArea(new Dimension(5, 20)));
            tempPanel.add(createMarketBttn(i, true, playerCreds, inventory));
            tempPanel.add(Box.createRigidArea(new Dimension(5, 20)));
            tempPanel.add(new JLabel(i.getName()));
            tempPanel.add(Box.createRigidArea(new Dimension(5, 20)));
            tempPanel.add(createMarketBttn(i, false, playerCreds, inventory));
            tempPanel.add(Box.createRigidArea(new Dimension(5, 20)));
            tempPanel.add(new JLabel("Selling Price: "
                    + calc.priceSellCalculator(player, region, i)));
            tempPanel.add(Box.createRigidArea(new Dimension(5, 20)));
            buttons.add(tempPanel);
        }
        openMap.setText("Open Map");
        info.add(regionName);
        info.add(xCoor);
        info.add(yCoor);
        info.add(techLevel);
        info.add(openMap);
        container.add(Box.createRigidArea(new Dimension(10, 0)));
        container.add(info);
        container.add(Box.createRigidArea(new Dimension(5, 10)));
        container.add(buttons);
        holder.add(container);
        holder.setPreferredSize(new Dimension(640, 500));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(getMainComponent());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    private JComponent getMainComponent() {
        return holder;
    }

    private void hide() {
        frame.setVisible(false);
        frame.dispose();
    }

    /**
     * Creates a new market button
     * @param item item to look at
     * @param buy whether or not you're buying or selling
     * @param creds credit JLabel
     * @param cargoDisp inventory JLabel
     * @return a new JButton
     */
    private JButton createMarketBttn(Item item, boolean buy, JLabel creds,
                                     JLabel cargoDisp) {
        if (buy) {
            //Buying
            return new JButton(new AbstractAction("Buy") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (player.getShip().canAddCargo()) {
                        double price = calc.priceBuyCalculator(player, region, item);
                        if (player.getCredits() - price > 0) {
                            player.setCredits(player.getCredits() - price);
                            player.getShip().addCargo(item);
                            cargoDisp.setText("Current Cargo: ");
                            creds.setText("Current Credits: " + player.getCredits()
                                + " (-" + price + ")");
                            for (Item i : player.getShip().getCargo()) {
                                String txt = cargoDisp.getText();
                                System.out.println(txt);
                                cargoDisp.setText(cargoDisp.getText()
                                        + i.getName() + ", ");
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "You "
                                    + "don't have enough money!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "You "
                                + "don't have any space!");
                    }
                }
            });
        } else {
            //Sell
            return new JButton(new AbstractAction("Sell") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //If the arraylist has the item, then sell, otherwise error
                    if (player.getShip().findItemToRemove(item) != null) {
                        Item sItem = player.getShip().findItemToRemove(item);
                        double price = calc.priceSellCalculator(player, region, sItem);
                        player.setCredits(player.getCredits()
                                + price);
                        player.getShip().removeCargo(sItem);
                        cargoDisp.setText("Current Cargo: ");
                        creds.setText("Current Credits: " + player.getCredits()
                                + " (+" + price + ")");
                        for (Item i : player.getShip().getCargo()) {
                            cargoDisp.setText(cargoDisp.getText()
                                    + i.getName() + ", ");
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "You "
                                + "don't have this item!");
                    }
                }
            });
        }
    }

}
