package models.NPC;
import models.Item;
import models.Player;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Police extends NPC {

    private ArrayList<Item> cargo;
    private double credits;
    private List<Item> contraband;
    private Random gen = new Random();
    private Player player;

    public Police(Player player) {
        super("Seteth", "assets/img/cop.png", player);
        contraband = new ArrayList<>();
        this.player = player;
        this.cargo = player.getShip().getCargo();
        this.credits = player.getCredits();
    }

    /**
     * Ok you need a random gen for the
     * items so you will have to check how many i would say a max of 3
     * @return contraband that the police is tryna steal
     */
    public List<Item> whichItems() {
        if (cargo.size() == 1) {
            contraband.add(cargo.get(0));
        } else if (cargo.size() == 2) {
            for (int i = 0; i < cargo.size(); i++) {
                contraband.add(cargo.get(i));
            }
        } else {
            for (int i = 0; i < gen.nextInt(3) + 1; i++) {
                int num = gen.nextInt();
                contraband.add(cargo.get((i + num) % cargo.size()));
            }
        }
        return contraband;
    }

    @Override
    public void interact() {
        System.out.println("Wee woo wee woo");
        //displays whichItems() that the police think you stole
        //choose whether to forfeit items, flee from the police, or fight them off
    }

    /**
     * Forfeit your items to the police
     */
    public void forfeit() {
        for (Item i : contraband) { //I have no idea if this works for a map tbh
            player.getShip().removeCargo(i);
        }
        //continue traveling
    }

    /**
     * Fight the police
     */
    public void fight() {
        //fighter skill check
        //police's fighter skill is random between 0-15
        int num = gen.nextInt(16);
        //if player loses
        if (num > player.getSkillSet()[1]) {
            //lose the fight
            //the rubric doesn't say what to do if this happens so
            //you're gonna die
            player.getShip().setHealth(0);
            player.getShip().clearCargo();
            //player.setCurrentRegion(jail); or just go back to previous, or die
        } else {
            return;
            //win
            //continue to travel successfully
            //keep all items
        }
    }

    /**
     * Run away from the police
     */
    public void flee() {
        //pilot skill check
        int num = gen.nextInt(14) + 2;
        //if player loses
        if (num > player.getSkillSet()[0]) {
            //fail to flee
            //lose the "contraband"
            forfeit();
            //get evasion fined
            player.setCredits(player.getCredits() - 100);
            //lose health
            player.getShip().setHealth(player.getShip().getHealth() - (gen.nextInt(201) + 100));
            //return to previous region
        } else {
            return;
            //dip out
            //return to original region,
            // while still using up the same amount of fuel as if they traveled to the destination
            //keep all items
        }
    }
}
