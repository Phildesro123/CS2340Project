package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import models.*;
import models.enums.ShipType;

public class CustomizationPage {
    private Game game;
    private JFrame frame = new JFrame("Character Customization");
    private Player player;
    private String[] infoTxt = {"Pilot: ", "Fighter: ", "Merchant: ", "Engineer: "};

    //Panels
    private JPanel container = new JPanel(new BorderLayout());
    private JPanel centerPanel = new JPanel();
    private JPanel professionPanel = new JPanel();
    private JPanel difficultyPanel = new JPanel();
    private JPanel northPanel = new JPanel(); // Name & Difficulty
    private JPanel southPanel = new JPanel(); // Confirmation
    private JPanel leftPanel = new JPanel(); // Add Buttons here
    private JPanel rightPanel = new JPanel(); // Remove Buttons here

    /**
     * This creates the GUI and shows it.
     */
    public CustomizationPage() {
        game = new Game("EASY", "");
        player = game.getPlayer();
        JTextField characterName = new JTextField(30);
        JLabel currCredits = new JLabel("" + player.getCredits());
        JLabel currPoints = new JLabel("Current skill points: " + player.getSkillPoints());
        JLabel charNameLabel = new JLabel("Character Name: ");
        JLabel incEngineer = new JLabel("Engineer: 0");
        JLabel incPilot = new JLabel("Pilot: 0");
        JLabel incFighter = new JLabel("Fighter: 0");
        JLabel incMerchant = new JLabel("Merchant: 0");
        JLabel[] infoArray = {incPilot, incFighter, incMerchant, incEngineer};
        //Buttons
        JButton confirm = new JButton(new AbstractAction("Confirm") {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.startGame();
                player.setName(characterName.getText());
                if (player.getName().equals("Dimitri")) {
                    player.setShip(new Ship(ShipType.KINGDOMCCO));
                } else if (player.getName().equals("Edelgard")) {
                    player.setShip(new Ship(ShipType.EMPIREWCORP));
                } else if (player.getName().equals("Claude")) {
                    player.setShip(new Ship(ShipType.ALLIANCEDCO));
                }
                charNameLabel.setText("Character Name: " + player.getName());
                game.setPlayer(player);
                DisplayScreen disp = new DisplayScreen(game);
                hide();
            }
        });
        JButton addPilot = new JButton(new AbstractAction("+") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Increase value, decrease points
                player.addToSkillSet(0);
                incPilot.setText("Pilot: " + player.getSkillSet()[0]);
                currPoints.setText("Current skill points: " + player.getSkillPoints());
            }
        });
        JButton remPilot = new JButton(new AbstractAction("-") {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.removeFromSkillSet(0);
                incPilot.setText("Pilot: " + player.getSkillSet()[0]);
                currPoints.setText("Current skill points: " + player.getSkillPoints());
            }
        });
        JButton addEngineer = new JButton(new AbstractAction("+") {
            //Increase value, decrease points
            @Override
            public void actionPerformed(ActionEvent e) {
                player.addToSkillSet(3);
                incEngineer.setText("Engineer: " + player.getSkillSet()[3]);
                currPoints.setText("Current skill points: " + player.getSkillPoints());
            } });
        JButton remEngineer = new JButton(new AbstractAction("-") {
            //Increase value, decrease points
            @Override
            public void actionPerformed(ActionEvent e) {
                player.removeFromSkillSet(3);
                incEngineer.setText("Engineer: " + player.getSkillSet()[3]);
                currPoints.setText("Current skill points: " + player.getSkillPoints());
            } });
        JButton addFighter = new JButton(new AbstractAction("+") {
            //Increase value, decrease points
            @Override
            public void actionPerformed(ActionEvent e) {
                player.addToSkillSet(1);
                incFighter.setText("Fighter: " + player.getSkillSet()[1]);
                currPoints.setText("Current skill points: " + player.getSkillPoints());
            } });
        JButton remFighter = new JButton(new AbstractAction("-") {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.removeFromSkillSet(1);
                incFighter.setText("Fighter: " + player.getSkillSet()[1]);
                currPoints.setText("Current skill points: " + player.getSkillPoints());
            } });
        JButton addMerchant = new JButton(new AbstractAction("+") {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.addToSkillSet(2);
                incMerchant.setText("Merchant: " + player.getSkillSet()[2]);
                currPoints.setText("Current skill points: " + player.getSkillPoints());
            } });
        JButton remMerchant = new JButton(new AbstractAction("-") {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.removeFromSkillSet(2);
                incMerchant.setText("Merchant: " + player.getSkillSet()[2]);
                currPoints.setText("Current skill points: " + player.getSkillPoints());
            } });
        JRadioButton easy = new JRadioButton(new AbstractAction("Easy") {
            @Override
            public void actionPerformed(ActionEvent e) {
                game = new Game("EASY", "");
                player = game.getPlayer();
                resetDifficulty(infoArray);
                currPoints.setText("Current skill points: " + player.getSkillPoints());
                currCredits.setText("Current credits: " + player.getCredits());
            } });
        easy.setSelected(true);
        JRadioButton normal = new JRadioButton(new AbstractAction("Normal") {
            @Override
            public void actionPerformed(ActionEvent e) {
                game = new Game("MEDIUM", "");
                player = game.getPlayer();
                resetDifficulty(infoArray);
                currPoints.setText("Current skill points: " + player.getSkillPoints());
                currCredits.setText("Current credits: " + player.getCredits());
            } });
        JRadioButton hard = new JRadioButton(new AbstractAction("Hard") {
            @Override
            public void actionPerformed(ActionEvent e) {
                game = new Game("HARD", "");
                player = game.getPlayer();
                resetDifficulty(infoArray);
                currPoints.setText("Current skill points: " + player.getSkillPoints());
                currCredits.setText("Current credits: " + player.getCredits());
            }
        });
        BoxLayout diffBoxLayout = new BoxLayout(difficultyPanel, BoxLayout.X_AXIS);
        BoxLayout profBoxLayout = new BoxLayout(professionPanel, BoxLayout.Y_AXIS);
        BoxLayout cBoxLayout = new BoxLayout(centerPanel, BoxLayout.Y_AXIS);
        BoxLayout nBoxLayout = new BoxLayout(northPanel, BoxLayout.Y_AXIS);
        BoxLayout lBoxLayout = new BoxLayout(leftPanel, BoxLayout.Y_AXIS);
        BoxLayout rBoxLayout = new BoxLayout(rightPanel, BoxLayout.Y_AXIS);
        layoutPanels(diffBoxLayout, profBoxLayout, cBoxLayout, nBoxLayout, lBoxLayout, rBoxLayout);
        buildNorthPanel(charNameLabel, characterName);
        buildRightPanel(remEngineer, remFighter, remMerchant, remPilot);
        Component[] comps = {incEngineer, addEngineer, incFighter, addFighter,
            incMerchant, addMerchant, incPilot, addPilot};
        buildLeftPanel(comps);
        southPanel.add(confirm);
        difficultyPanel.add(easy);
        difficultyPanel.add(normal);
        difficultyPanel.add(hard);
        professionPanel.add(incEngineer);
        professionPanel.add(incFighter);
        professionPanel.add(incMerchant);
        professionPanel.add(incPilot);
        buildCentralPanel(currPoints, currCredits);
        ButtonGroup group = new ButtonGroup();
        buildButtons(group, easy, normal, hard);
        fillContainer();
        containerStuff();
    }

    private void buildLeftPanel(Component[] comps) {
        for (Component i : comps) {
            leftPanel.add(i);
        }
    }
    private void buildRightPanel(JButton r1, JButton r2, JButton r3, JButton r4) {
        rightPanel.add(r1);
        rightPanel.add(r2);
        rightPanel.add(r3);
        rightPanel.add(r4);
    }

    private void layoutPanels(BoxLayout d, BoxLayout p, BoxLayout c,
                              BoxLayout n, BoxLayout l, BoxLayout r) {
        difficultyPanel.setLayout(d);
        professionPanel.setLayout(p);
        centerPanel.setLayout(c);
        northPanel.setLayout(n);
        leftPanel.setLayout(l);
        rightPanel.setLayout(r);
    }

    private void buildCentralPanel(JLabel p, JLabel c) {
        centerPanel.add(difficultyPanel);
        centerPanel.add(p);
        centerPanel.add(professionPanel);
        centerPanel.add(c);
    }

    private void buildNorthPanel(JLabel l, JTextField t) {
        northPanel.add(l);
        northPanel.add(t);
    }

    public Game getGame() {
        return game;
    }

    private void hide() {
        frame.setVisible(false);
        frame.dispose();
    }

    private void fillContainer() {
        container.add(centerPanel, BorderLayout.CENTER);
        container.add(northPanel, BorderLayout.NORTH);
        container.add(southPanel, BorderLayout.SOUTH);
        container.add(leftPanel, BorderLayout.WEST);
        container.add(rightPanel, BorderLayout.EAST);
    }

    private void containerStuff() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(container);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void buildButtons(ButtonGroup g, JRadioButton e, JRadioButton n, JRadioButton h) {
        g.add(e);
        g.add(n);
        g.add(h);
    }

    private void resetDifficulty(JLabel[] infoArray) {
        int i = 0;
        for (JLabel txt : infoArray) {
            txt.setText(infoTxt[i] + "0");
            i++;
        }
    }
}