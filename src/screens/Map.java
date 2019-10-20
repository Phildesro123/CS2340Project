package screens;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import models.Game;
import models.Player;
import models.Region;
import models.Universe;
import models.Travel;

import java.awt.*;
import java.awt.event.ActionEvent;

public class Map {
    private Player player;
    private Travel travel;
    protected JFrame frame = new JFrame("Map *scaled by 3x*");
    protected JPanel panel = new JPanel();
    protected RegionDisplay disp;
    protected TravelDisplay trav;

    public Map(Game game) {
        Universe universe = game.getUniverse();
        player = game.getPlayer();
        travel = game.getTravel();
        Region[] regions = new Region[universe.getRegions().length - 1];
        int cnt = 0;
        for (Region region: universe.getRegions()) {
            if (!region.equals(player.getCurrentRegion())) {
                regions[cnt] = region;
                cnt++;
            }
        }
        JButton currentRegion = new JButton("You are here");
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
        frameStuff();
    }
    private JButton buttons(int n, Game game) {
        Universe universe = game.getUniverse();
        player = game.getPlayer();
        travel = game.getTravel();
        Region[] regions = new Region[universe.getRegions().length - 1];
        int cnt = 0;
        for (Region region: universe.getRegions()) {
            if (!region.equals(player.getCurrentRegion())) {
                regions[cnt] = region;
                cnt++;
            }
        }
        double dist = player.distance(regions[n]);
        JButton region = new JButton(new AbstractAction(String.format("<html> %s <br> "
                        + "Distance from you: %.2f<br>"
                        + "Fuel cost: %d</html>",
                regions[n].getName(),
                dist,
                travel.fuelCost(dist))) {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (travel.canTravel(dist)) {
                    travel.traveling(dist);
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
        });
        return region;
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
        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
