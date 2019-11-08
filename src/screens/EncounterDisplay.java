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
    Random gen = new Random();
    private Encounter encounter;
    protected JFrame f = new JFrame("Display Page");
    protected JPanel disp = new JPanel();
    private NPC npc;
    private int selectedValue;
    public EncounterDisplay(Encounter encounter, Game game) {
        this.encounter = encounter;
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
                            break;
                        case 1:
                            bandit.flee();
                            break;
                        case 2:
                            bandit.fight();
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

        }
        if (npc instanceof Trader) {
            Trader trader = (Trader) npc;
            ImageIcon icon = new ImageIcon("src/assets.img/merchant.png");
            trader.setPlayer(game.getPlayer());
            selectedValue = JOptionPane.showOptionDialog(null,
                    "How about a trade?",
                    "Encounter",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    trader.getIcon(),
                    traderOptions, traderOptions[0]);
            switch (selectedValue) {
                case 0:
                    trader.sellItem((Item) trader.getCargo().get(0));
                    break;
                case 1:
                    trader.commitRobbery();
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
                    switch (selectedValue) {
                        case 0:
                            trader.sellItem((Item) trader.getCargo().get(0));
                            break;
                        case 1:
                            trader.commitRobbery();
                            break;
                    }
                    break;
            }
        }
    }
}
