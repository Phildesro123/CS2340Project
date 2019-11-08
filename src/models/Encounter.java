package models;
import java.util.Random;
import java.util.ArrayList;
import models.NPC.*;
public class Encounter {
    private double credits;
    private double diff;
    private Player player;
    Random gen = new Random();
    public Encounter(double credits, double diff, Player player) {
        this.credits = credits;
        this.diff = diff;
        this.player = player;
    }

    public NPC startEncounter() {
        return generateNPC();
    }
    private NPC generateNPC() {
        int npc = gen.nextInt(1001);
        if (player.getShip().getCargo().size() > 0) {
            if (npc <= (100 + 50 * diff)) {
                return createPolice();
            } else if (npc >= (800 - 50 * diff)) {
                return createBandit();
            } else if (npc <= (300 + 50 * diff)
                    || npc >= (700 - 50 * diff)) {
                return createTrader();
            }
        } else {
            if (npc >= (800 - 50 * diff)) {
                return createBandit();
            } else if (npc <= (300 + 50 * diff)
                    || npc >= (700 - 50 * diff)) {
                return createTrader();
            }
        }
        return null;
    }


    private Police createPolice() {
        return new Police(player.getShip().getCargo(), credits, player);
    }

    private Bandit createBandit() {
        return new Bandit(player);
    }

    //We have to add this player to encounter somehow
    private Trader createTrader() {
        return new Trader(player);
    }

}
