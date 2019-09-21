package models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Game;

public class CustomizationPage {



    /**
     * This creates the GUI and shows it.
     *
     */

    public CustomizationPage() {
        Game game = new Game(16, "");
        Player player = game.getPlayer();

        JFrame frame = new JFrame("Character Customization");

        //Text Fields
        JTextField characterName = new JTextField(30);

        //Labels
        JLabel currCredits = new JLabel("" + player.getCredits());
        JLabel currPoints = new JLabel("Current skill points: "
                + player.getSkillPoints());
        JLabel charNameLabel = new JLabel("Character Name: ");
        JLabel incEngineer = new JLabel("Engineer: 0");
        JLabel incPilot = new JLabel("Pilot: 0");
        JLabel incFighter = new JLabel("Fighter: 0");
        JLabel incMerchant = new JLabel("Merchant: 0");

        //Buttons
        JButton confirm = new JButton(new AbstractAction("Confirm") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Load next page with information and game object
            }
        });

        JButton addPilot = new JButton(new AbstractAction("+") {
            /**
             * This increases the value of the point added to pilot
             * and decreases the points remaining to be allocated.
             * @param e Click
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //Increase value, decrease points
                player.addToSkillSet(0);
                incPilot.setText("Pilot: " + player.getSkillSet()[0]);
                currPoints.setText("Current skill points: "
                + player.getSkillPoints());
            }
        });

        JButton remPilot = new JButton(new AbstractAction("-") {
            //Increase value, decrease points
            @Override
            public void actionPerformed(ActionEvent e) {
                player.removeFromSkillSet(0);
                incMerchant.setText("Pilot: " + player.getSkillSet()[0]);
                currPoints.setText("Current skill points: "
                        + player.getSkillPoints());
            }
        });

        JButton addEngineer = new JButton(new AbstractAction("+") {
            //Increase value, decrease points
            @Override
            public void actionPerformed(ActionEvent e) {
                player.addToSkillSet(3);
                incEngineer.setText("Engineer: " + player.getSkillSet()[3]);
                currPoints.setText("Current skill points: "
                        + player.getSkillPoints());

            }
        });

        JButton remEngineer = new JButton(new AbstractAction("-") {
            //Increase value, decrease points
            @Override
            public void actionPerformed(ActionEvent e) {
                player.removeFromSkillSet(3);
                incEngineer.setText("Engineer: " + player.getSkillSet()[3]);
                currPoints.setText("Current skill points: "
                        + player.getSkillPoints());

            }
        });

        JButton addFighter = new JButton(new AbstractAction("+") {
            //Increase value, decrease points
            @Override
            public void actionPerformed(ActionEvent e) {
                player.addToSkillSet(1);
                incFighter.setText("Fighter: " + player.getSkillSet()[1]);
                currPoints.setText("Current skill points: "
                        + player.getSkillPoints());

            }
        });

        JButton remFighter = new JButton(new AbstractAction("-") {
            //Increase value, decrease points
            @Override
            public void actionPerformed(ActionEvent e) {
                player.removeFromSkillSet(1);
                incFighter.setText("Fighter: " + player.getSkillSet()[2]);
                currPoints.setText("Current skill points: "
                        + player.getSkillPoints());

            }
        });

        JButton addMerchant = new JButton(new AbstractAction("+") {
            //Increase value, decrease points
            @Override
            public void actionPerformed(ActionEvent e) {
                player.addToSkillSet(2);
                incMerchant.setText("Merchant: " + player.getSkillSet()[2]);
                currPoints.setText("Current skill points: "
                        + player.getSkillPoints());

            }
        });
        JButton remMerchant = new JButton(new AbstractAction("-") {
            //Increase value, decrease points
            @Override
            public void actionPerformed(ActionEvent e) {
                player.removeFromSkillSet(2);
                incMerchant.setText("Merchant: " + player.getSkillSet()[2]);
                currPoints.setText("Current skill points: "
                        + player.getSkillPoints());

            }
        });

        //Need to add action handlers to change upon selection
        JRadioButton easy = new JRadioButton("Easy");
        easy.setSelected(true);
        JRadioButton normal = new JRadioButton("Normal");
        JRadioButton hard = new JRadioButton("Hard");




        //Panels
        JPanel container = new JPanel(new BorderLayout());
        JPanel centerPanel = new JPanel();
        JPanel professionPanel = new JPanel();
        JPanel difficultyPanel = new JPanel();
        JPanel northPanel = new JPanel(); // Name & Difficulty
        JPanel sotuhPanel = new JPanel(); // Confirmation
        JPanel leftPanel = new JPanel(); // Add Buttons here
        JPanel rightPanel = new JPanel(); // Remove Buttons here

        //Layouts
        BoxLayout diffBoxLayout = new BoxLayout(difficultyPanel,
                BoxLayout.X_AXIS);
        BoxLayout profBoxLayout = new BoxLayout(professionPanel,
                BoxLayout.Y_AXIS);
        BoxLayout cBoxLayout = new BoxLayout(centerPanel,
                BoxLayout.Y_AXIS);
        BoxLayout nBoxLayout = new BoxLayout(northPanel,
                BoxLayout.Y_AXIS);
        BoxLayout lBoxLayout = new BoxLayout(leftPanel,
                BoxLayout.Y_AXIS);
        BoxLayout rBoxLayout = new BoxLayout(rightPanel,
                BoxLayout.Y_AXIS);

        difficultyPanel.setLayout(diffBoxLayout);
        professionPanel.setLayout(profBoxLayout);
        centerPanel.setLayout(cBoxLayout);
        northPanel.setLayout(nBoxLayout);
        leftPanel.setLayout(lBoxLayout);
        rightPanel.setLayout(rBoxLayout);

        //North Panel

        northPanel.add(charNameLabel);
        northPanel.add(characterName);

        //Right Panel

        rightPanel.add(remEngineer);
        rightPanel.add(remFighter);
        rightPanel.add(remMerchant);
        rightPanel.add(remPilot);
        //Left Panel

        leftPanel.add(incEngineer);
        leftPanel.add(addEngineer);
        leftPanel.add(incFighter);
        leftPanel.add(addFighter);
        leftPanel.add(incMerchant);
        leftPanel.add(addMerchant);
        leftPanel.add(incPilot);
        leftPanel.add(addPilot);

        //Bottom Panel
        sotuhPanel.add(confirm);

        //Center Panel
        difficultyPanel.add(easy);
        difficultyPanel.add(normal);
        difficultyPanel.add(hard);
        professionPanel.add(incEngineer);
        professionPanel.add(incFighter);
        professionPanel.add(incMerchant);
        professionPanel.add(incPilot);
        centerPanel.add(difficultyPanel);
        centerPanel.add(currPoints);
        centerPanel.add(professionPanel);
        centerPanel.add(currCredits);
        ButtonGroup group = new ButtonGroup();
        group.add(easy);
        group.add(normal);
        group.add(hard);

        //Container
        container.add(centerPanel, BorderLayout.CENTER);
        container.add(northPanel, BorderLayout.NORTH);
        container.add(sotuhPanel, BorderLayout.SOUTH);
        container.add(leftPanel, BorderLayout.WEST);
        container.add(rightPanel, BorderLayout.EAST);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(container);

        frame.pack();
        frame.setVisible(true);

    }

    public Game getGame(){
        return game;
    }

 /* public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShow();
            }
        });
    } */
}