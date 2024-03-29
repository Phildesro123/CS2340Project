package screens;
import javax.swing.*;

import models.*;
import models.enums.ItemType;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Map {
    private Player player;
    private Travel travel;
    private JFrame frame;
    private RegionDisplay disp;
    private TravelDisplay trav;
    private JPanel cont = new JPanel();
    public Map(Game game) {
        JPanel panel = new JPanel();
        frame = new JFrame("Map *scaled by 3x*");

        player = game.getPlayer();
        travel = new Travel(game.getDifficulty().modifier(), player.getSkillSet());
        Region[] regions = new Region[game.getRegions().length - 1];
        Random rand = new Random();
        int win = rand.nextInt(10);
        if (win <= 3) {
            Item[] newItems = game.getRegions()[6].getMarket().getItems();
            newItems[6] = new Item(3000, ItemType.REGALIA,
                    game.getPlayer().getName() + "'s Universe",
                    "Ultima Weapon");
            game.getRegions()[6].getMarket().setItems(newItems);
        }
        int cnt = 0;
        for (Region region: game.getRegions()) {
            if (!region.equals(player.getCurrentRegion())) {
                regions[cnt] = region;
                cnt++;
            }
        }
        Ship ship = player.getShip();
        JPanel fuelDisp = new JPanel();
        JLabel fuel = new JLabel("Current fuel: " + ship.getFuel() + "/" + ship.getMaxFuel());
        JLabel health = new JLabel("Current health " + ship.getHealth());
        JLabel currentCredit = new JLabel("Current credits " + player.getCredits());
        fuelDisp.add(fuel);
        fuelDisp.add(health);
        fuelDisp.add(currentCredit);
        JButton currentRegion = new JButton(new AbstractAction("You are here") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegionDisplay(game);
                hide();
            }
        });
        JButton firstRegion = buttons(0, game);
        JButton secondRegion = buttons(1, game);
        JButton thirdRegion = buttons(2, game);
        JButton fourthRegion = buttons(3, game);
        JButton fifthRegion = buttons(4, game);
        JButton sixthRegion = buttons(5, game);
        JButton seventhRegion = buttons(6, game);
        JButton eighthRegion = buttons(7, game);
        JButton ninthRegion = buttons(8, game);
        showButtons(currentRegion, player.getCurrentRegion());
        showButtons(firstRegion, regions[0]);
        showButtons(secondRegion, regions[1]);
        showButtons(thirdRegion, regions[2]);
        showButtons(fourthRegion, regions[3]);
        showButtons(fifthRegion, regions[4]);
        showButtons(sixthRegion, regions[5]);
        showButtons(seventhRegion, regions[6]);
        showButtons(eighthRegion, regions[7]);
        showButtons(ninthRegion, regions[8]);
        JButton[] buttons = {firstRegion, secondRegion, thirdRegion,
            fourthRegion, fifthRegion, sixthRegion, seventhRegion, eighthRegion,
            ninthRegion, currentRegion};
        for (JButton button : buttons) {
            panel.add(button);
        }
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(1366, 768));
        cont.add(fuelDisp);
        cont.add(panel);
        frameStuff();
    }
    private JButton buttons(int n, Game game) {
        player = game.getPlayer();
        Region[] regions = new Region[game.getRegions().length - 1];
        int cnt = 0;
        for (Region region: game.getRegions()) {
            if (!region.equals(player.getCurrentRegion())) {
                regions[cnt] = region;
                cnt++;
            }
        }
        double dist = player.distance(regions[n]);
        return new JButton(new AbstractAction(String.format("<html> %s <br> "
                        + "Distance from you: %.2f<br>"
                        + "Fuel cost: %d</html>",
                regions[n].getName(), dist,
                travel.fuelCost(dist))) {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.getShip().getHealth() <= 0) {
                    hide();
                    GameOver end = new GameOver(false);
                } else if (travel.canTravel(player.getShip(), dist)) {
                    Random rand = new Random();
                    int encounterChance = rand.nextInt(100);
                    if (20 * game.getDifficulty().modifier() > 1) {
                        hide();
                        Encounter newEncounter =
                                new Encounter(game);
                        EncounterDisplay encounterDisplay
                                = new EncounterDisplay(newEncounter, game);
                        travel.traveling(player.getShip(), dist);
                        player.setCurrentRegion(regions[n]);
                        game.setPlayer(player);
                        disp = new RegionDisplay(game);
                        hide();
                    } else {
                        player.setCurrentRegion(player.getCurrentRegion());
                        game.setPlayer(player);
                        trav = new TravelDisplay(game, dist);
                        hide();
                    }
                }
            }
        });
    }
    private void hide() {
        frame.setVisible(false);
        frame.dispose();
    }

    private void showButtons(JButton button, Region region) {
        button.setFont(new Font("Calibri (Body)", Font.BOLD, 12));
        button.setSize(200, 100);
        button.setLocation((int) (region.getX() * 3.0) + 50,
                (int) (region.getY() * 3.0) + 50);

        button.setBackground(region.getColor());
    }

    private void frameStuff() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(cont);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}