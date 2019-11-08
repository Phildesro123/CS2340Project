package screens;

import models.Encounter;
import models.Game;
import models.Item;
import models.NPC.Bandit;
import models.NPC.NPC;
import models.NPC.Police;
import models.NPC.Trader;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class EncounterDisplay {
    private Random gen;
    private Encounter encounter;
    protected JFrame f = new JFrame("Display Page");
    protected JPanel disp = new JPanel();
    private NPC npc;
    private int selectedValue;
    private Game game;
    public EncounterDisplay(Encounter encounter, Game game) {
        gen = new Random();
        this.encounter = encounter;
        this.game = game;
        npc = encounter.getNpc();
        String[] banditOptions = {"Pay", "Flee", "Fight"};
        String[] traderOptions = {"Buy", "Rob", "Negotiate"};
        String[] policeOptions = {"Forfeit", "Flee", "Fight"};
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
                selectedValue = JOptionPane.showOptionDialog(null,
                        "How about a trade?",
                        "Encounter",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        trader.getIcon(),
                        newTraderOptions, newTraderOptions[0]);
                break;
            default:
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
            }
        }
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
