package models;
import java.util.Random;
import java.util.ArrayList;
import models.NPC.*;
public class Encounter {
    private ArrayList<Item> cargo;
    private double credits;
    private double diff;
    Random gen = new Random();
    public Encounter(ArrayList<Item> cargo, double credits, double diff) {
        this.cargo = cargo;
        this.credits = credits;
        this.diff = diff;
    }
    public Object generateNPC() {
        int npc = gen.nextInt(1001);
        if (cargo.size() > 0) {
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
        return new Police(cargo, credits);
    }

    private Bandit createBandit() {
        return new Bandit();
    }

    private Trader createTrader() {
        return new Trader();
    }

}
