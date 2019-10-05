package screens;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import models.Game;
import models.Player;
import models.Region;
import models.Universe;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class Map {
    private Player player;
    protected JFrame frame = new JFrame("Map *scaled by 3x*");
    protected JPanel panel = new JPanel();
    protected RegionDisplay disp;

    public Map(Game game) {
        Universe universe = game.getUniverse();
        player = game.getPlayer();
        Region[] regions = new Region[universe.getRegions().length - 1];

        int cnt = 0;
        for (Region region: universe.getRegions()) {
            if (!region.equals(player.getCurrentRegion())) {
                regions[cnt] = region;
                cnt++;
            }
        }
        //find a way to automate the buttons?
        JButton currentRegion =
                new JButton("You are here");
        JButton firstRegion =
                new JButton(new AbstractAction(regions[0].getName()) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player.setCurrentRegion(regions[0]);
                        game.setPlayer(player);
                        disp = new RegionDisplay(game);
                        hide();
                    }
                });
        JButton secondRegion =
                new JButton(new AbstractAction(regions[1].getName()) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player.setCurrentRegion(regions[1]);
                        game.setPlayer(player);
                        disp = new RegionDisplay(game);
                        hide();
                    }
                });
        JButton thirdRegion =
                new JButton(new AbstractAction(regions[2].getName()) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player.setCurrentRegion(regions[2]);
                        game.setPlayer(player);
                        disp = new RegionDisplay(game);
                        hide();
                    }
                });
        JButton fourthRegion =
                new JButton(new AbstractAction(regions[3].getName()) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player.setCurrentRegion(regions[3]);
                        game.setPlayer(player);
                        disp = new RegionDisplay(game);
                        hide();
                    }
                });
        JButton fifthRegion =
                new JButton(new AbstractAction(regions[4].getName()) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player.setCurrentRegion(regions[4]);
                        game.setPlayer(player);
                        disp = new RegionDisplay(game);
                        hide();
                    }
                });
        JButton sixthRegion =
                new JButton(new AbstractAction(regions[5].getName()) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player.setCurrentRegion(regions[5]);
                        game.setPlayer(player);
                        disp = new RegionDisplay(game);
                        hide();
                    }
                });
        JButton seventhRegion =
                new JButton(new AbstractAction(regions[6].getName()) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player.setCurrentRegion(regions[6]);
                        game.setPlayer(player);
                        disp = new RegionDisplay(game);
                        hide();
                    }
                });
        JButton eighthRegion =
                new JButton(new AbstractAction(regions[7].getName()) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player.setCurrentRegion(regions[7]);
                        game.setPlayer(player);
                        disp = new RegionDisplay(game);
                        hide();
                    }
                });
        JButton ninthRegion =
                new JButton(new AbstractAction(regions[8].getName()) {
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

        panel.setLayout(null);

        JButton[] buttons = {firstRegion, secondRegion, thirdRegion,
            fourthRegion, fifthRegion, sixthRegion, seventhRegion, eighthRegion,
            ninthRegion, currentRegion};

        for (JButton button : buttons) {
            panel.add(button);
        }

        panel.setPreferredSize(new Dimension(1366, 768));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private void hide() {
        frame.setVisible(false);
        frame.dispose();
    }

    private void showButtons(JButton button, Region region) {
        button.setSize(100, 50);
        button.setLocation((int) (region.getX() * 3.0) + 50,
                (int) (region.getY() * 3.0) + 50);
    }


}
