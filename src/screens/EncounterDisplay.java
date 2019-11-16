package screens;

import models.Encounter;
import models.Game;
import models.Item;
import models.NPC.*;

import javax.swing.*;
import java.util.Random;

public class EncounterDisplay {
    Random gen = new Random();
    private Encounter encounter;
    protected JFrame f = new JFrame("Display Page");
    protected JPanel disp = new JPanel();
    public EncounterDisplay(Encounter encounter, Game game) {
        this.encounter = encounter;
        //String[] options = {"Buy" , "Run"};
        //JOptionPane.showOptionDialog(null, "Click run", "Encounter", JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        this.game = game;
        npc = encounter.getNpc();
        npc.interact();
        /*
        String[] banditOptions = {"Pay", "Flee", "Fight"};
        String[] traderOptions = {"Buy", "Rob", "Negotiate"};
        String[] policeOptions = {"Forfeit", "Flee", "Fight"};
        

        ImageIcon icon = npc.getIcon();
        String[] interact = npc.interact();
        String[] options = {interact[1], interact[2], interact[3]};
        if (interact[0] == "Vibe check") {
            selectedValue = JOptionPane.showOptionDialog(null, 
                        interact[0],
                        "Encounter",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        icon,
                        options, options[0]);
            switch (selectedValue) {

            }
        }




        if (npc instanceof Bandit) {
            Bandit bandit = (Bandit) npc;
            ImageIcon icon = new ImageIcon("src/assets.img/bandit.png");
            bandit.setPlayer(game.getPlayer());
            selectedValue = JOptionPane.showOptionDialog(null,
                    "Gimme ya money clown!",
                    "Encounter",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    bandit.getIcon(),
                    banditOptions, banditOptions[0]);
            switch (selectedValue) {
            case 0:
                bandit.pay();
                showInventory();
                break;
            case 1:
                bandit.flee();
                showInventory();
                break;
            case 2:
                bandit.fight();
                showInventory();
                break;
            default:
                break;
            }
        }
        if (npc instanceof Police) {
            Police police = (Police) npc;
            ImageIcon icon = new ImageIcon("src/assets.img/cop.png");
            selectedValue = JOptionPane.showOptionDialog(null,
                    "This is the police",
                    "Encounter",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    police.getIcon(),
                    policeOptions, policeOptions[0]);
            switch (selectedValue) {
            case 0:
                police.forfeit();
                showInventory();
                break;
            case 1:
                police.flee();
                showInventory();
                break;
            case 2:
                police.fight();
                showInventory();
                break;
            default:
                break;
            }
        }

        if (npc instanceof Trader) {
            Trader trader = (Trader) npc;
            ImageIcon icon = new ImageIcon("src/assets.img/merchant.png");
            trader.setPlayer(game.getPlayer());
            String itemAndPrice = ((Item) trader.getCargo().get(0)).getName()
                    + ((Item) trader.getCargo().get(0)).getBasePrice();
            selectedValue = JOptionPane.showOptionDialog(null,
                    "How about a trade?\n" + itemAndPrice,
                    "Encounter",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    trader.getIcon(),
                    traderOptions, traderOptions[0]);
            switch (selectedValue) {
            case 0:
                trader.buyItem((Item) trader.getCargo().get(0));
                showInventory();
                break;
            case 1:
                trader.commitRobbery();
                showInventory();
                break;
            case 2:
                trader.negotiate();
                String[] newTraderOptions = {"Buy", "Rob"};
                itemAndPrice = ((Item) trader.getCargo().get(0)).getName()
                        + ((Item) trader.getCargo().get(0)).price(trader.getModifier());
                selectedValue = JOptionPane.showOptionDialog(null,
                        "How about a trade?\n" + itemAndPrice,
                        "Encounter",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        trader.getIcon(),
                        newTraderOptions, newTraderOptions[0]);
                switch (selectedValue) {
                case 0:
                    trader.buyItem((Item) trader.getCargo().get(0));
                    showInventory();
                    break;
                case 1:
                    trader.commitRobbery();
                    showInventory();
                    break;
                default:
                    break;
                }
                break;
            default:
                break;
            }
        }*/
    }


    public void showInventory() {
        String inventory = "";
        String credits = "Credits " + game.getPlayer().getCredits() + "\n";
        for (int i = 0; i < game.getPlayer().getShip().getCargo().size(); i++) {
            inventory += game.getPlayer().getShip().getCargo().get(i).getName() + "\n";
        }
        JOptionPane.showMessageDialog(null,
                inventory + credits, "Player Inventory", JOptionPane.INFORMATION_MESSAGE);
    }
}
