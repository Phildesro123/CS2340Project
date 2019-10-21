package screens;

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
    //Will handle price calculation(?)
    private Player player;
    protected Region region;
    protected JPanel container = new JPanel();
    protected JPanel info = new JPanel();
    protected JPanel marketDisp = new JPanel();
    protected JPanel buttons = new JPanel();
    protected JFrame frame = new JFrame("Current Region");

    public RegionDisplay(Game game) {
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        //Make a method that returns a panel and add it to buttons
        this.player = game.getPlayer();
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
        System.out.println("Buttons?");
        buttons.add(inventory);
        buttons.add(playerCreds);
        for (Item i : region.getMarket().getItems()) {
            JPanel tempPanel = new JPanel();
            tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.X_AXIS));
            tempPanel.add(createMarketBttn(i, true, playerCreds, inventory));
            tempPanel.add(new JLabel(i.getName()));
            tempPanel.add(createMarketBttn(i, false, playerCreds, inventory));
            System.out.println(tempPanel);
            buttons.add(tempPanel);
        }
        openMap.setText("Open Map");
        info.add(regionName);
        info.add(xCoor);
        info.add(yCoor);
        info.add(techLevel);
        info.add(openMap);
        container.add(info);
        container.add(buttons);
        container.setPreferredSize(new Dimension(1280, 860));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(getMainComponent());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    public JComponent getMainComponent() {
        return container;
    }

    public void hide() {
        frame.setVisible(false);
        frame.dispose();
    }

    private double priceSellCalculator(Item item) {
        if (player.getSkillSet()[3] > 0) {
            return item.price(item.price(region.getInflationS()),
                    player.getSkillSet()[3] * 0.2);
        } else {
            return item.price(region.getInflationS());
        }
    }

    private double priceBuyCalculator(Item item) {
        if (player.getSkillSet()[3] > 0) {
            return item.price(item.price(region.getInflationB()),
                    1 / player.getSkillSet()[3]);
        } else {
            return item.price(region.getInflationB());
        }
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
                        if (player.getCredits() - priceBuyCalculator(item) > 0) {
                            player.setCredits(player.getCredits()
                                    - priceBuyCalculator(item));
                            player.getShip().addCargo(item);
                            cargoDisp.setText("");
                            creds.setText("Current Credits: " + player.getCredits());
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
                    if (player.getShip().getCargo().contains(item)) {
                        player.setCredits(player.getCredits()
                                + priceSellCalculator(item));
                        player.getShip().removeCargo(item);
                        cargoDisp.setText("");
                        creds.setText("Current Credits: " + player.getCredits());
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
