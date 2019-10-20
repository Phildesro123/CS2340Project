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
        JButton firstRegion =
                new JButton(new AbstractAction(String.format("<html> %s <br> "
                                + "Distance from you: %.2f<br>"
                                + "Fuel cost: %d</html>",
                        regions[0].getName(),
                        player.distance(regions[0]),
                        travel.fuelCost(player.distance(regions[0])))) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player.setCurrentRegion(regions[0]);
                        game.setPlayer(player);
                        disp = new RegionDisplay(game);
                        hide();
                    }
                });
        JButton secondRegion =
                new JButton(new AbstractAction(String.format("<html> %s <br> "
                                + "Distance from you: %.2f</html>",
                        regions[1].getName(),
                        player.distance(regions[1]))) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player.setCurrentRegion(regions[1]);
                        game.setPlayer(player);
                        disp = new RegionDisplay(game);
                        hide();
                    }
                });
        JButton thirdRegion =
                new JButton(new AbstractAction(String.format("<html> %s <br> "
                                + "Distance from you: %.2f</html>",
                        regions[2].getName(),
                        player.distance(regions[2]))) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player.setCurrentRegion(regions[2]);
                        game.setPlayer(player);
                        disp = new RegionDisplay(game);
                        hide();
                    }
                });
        JButton fourthRegion =
                new JButton(new AbstractAction(String.format("<html> %s <br> "
                                + "Distance from you: %.2f</html>",
                        regions[3].getName(),
                        player.distance(regions[3]))) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player.setCurrentRegion(regions[3]);
                        game.setPlayer(player);
                        disp = new RegionDisplay(game);
                        hide();
                    }
                });
        JButton fifthRegion =
                new JButton(new AbstractAction(String.format("<html> %s <br> "
                                + "Distance from you: %.2f</html>",
                        regions[4].getName(),
                        player.distance(regions[4]))) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player.setCurrentRegion(regions[4]);
                        game.setPlayer(player);
                        disp = new RegionDisplay(game);
                        hide();
                    }
                });
        JButton sixthRegion =
                new JButton(new AbstractAction(String.format("<html> %s <br> "
                                + "Distance from you: %.2f</html>",
                        regions[5].getName(),
                        player.distance(regions[5]))) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player.setCurrentRegion(regions[5]);
                        game.setPlayer(player);
                        disp = new RegionDisplay(game);
                        hide();
                    }
                });
        JButton seventhRegion =
                new JButton(new AbstractAction(String.format("<html> %s <br> "
                                + "Distance from you: %.2f</html>",
                        regions[6].getName(),
                        player.distance(regions[6]))) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player.setCurrentRegion(regions[6]);
                        game.setPlayer(player);
                        disp = new RegionDisplay(game);
                        hide();
                    }
                });
        JButton eighthRegion =
                new JButton(new AbstractAction(String.format("<html> %s <br> " 
                                + "Distance from you: %.2f</html>", 
                        regions[7].getName(), 
                        player.distance(regions[7]))) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player.setCurrentRegion(regions[7]);
                        game.setPlayer(player);
                        disp = new RegionDisplay(game);
                        hide();
                    }
                });
        JButton ninthRegion =
                new JButton(new AbstractAction(String.format("<html> %s <br> "
                                + "Distance from you: %.2f</html>",
                        regions[8].getName(),
                        player.distance(regions[8]))) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player.setCurrentRegion(regions[8]);
                        game.setPlayer(player);
                        disp = new RegionDisplay(game);
                        hide();
                    }
                });
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
