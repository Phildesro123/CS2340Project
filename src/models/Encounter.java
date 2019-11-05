package models;
import java.util.Random;
import java.util.ArrayList;


public class Encounter {
    private ArrayList<Item> cargo;
    private double credits;
    private double diff;
    private Police police;
    private Bandit bandit;
    private Trader trader;
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
                createTrader();
            }
        } else {
            if (npc >= (800 - 50 * diff)) {
                createBandit();
            } else if (npc <= (300 + 50 * diff)
                    || npc >= (700 - 50 * diff)) {
                createTrader();
            }
        }
    }
    private Police createPolice() {
        police = new Police(cargo, credits);
        return police;
    }
    private Bandit createBandit() {
        bandit = new Bandit();
        return bandit;
    }
    private Trader createTrader() {
        trader = new Trader();
        return trader;
    }

}
