package models.NPC;


import models.Player;

import java.util.Random;

public class Bandit extends NPC {
    private double demand;
    Random gen = new Random();
    public Bandit(Player player) {
        super("Flayn", "assets/img/bandit.png", player);
        demand = gen.nextInt(51) + 50;
    }


    @Override
    public void interact() {
        System.out.println("Vibe check");
        //choose between paying credits, fleeing, or fighting
    }

    /**
     * Fight the Bandit
     */
    public void fight() {
        //fighter skill check
        //bandit's fighter skill is random between 0-15
        int num = gen.nextInt(16);
        //if player loses
        if (num > player.getSkillSet()[1]) {
            //lose the fight
            //lose ALL credits
            player.setCredits(0);
            //lose health
            player.getShip().setHealth(player.getShip().getHealth() - (gen.nextInt(201) + 100));
            //continue to travel (or don't, it's optional)
        } else {
            //win
            //gain credits
            player.setCredits(player.getCredits() + gen.nextInt(26) + 25); 
            //continue to travel successfully
        }
    }

    /**
     * Run away from the Bandit
     */
    public void flee() {
        //pilot skill check
        int num = gen.nextInt(16);
        //if player loses
        if (num > player.getSkillSet()[0]) {
            //fail to flee
            //lose ALL credits
            player.setCredits(0.0);
            //lose health
            player.getShip().setHealth(player.getShip().getHealth() - (gen.nextInt(201) + 100));
            //continue to travel (or don't, it's optional)
        } else {
            //dip out
            //return to original region, while still using up the same amount of fuel as if they traveled to the destination
            //keep all credits
        }
    }

    /**
     * Give in to the Bandit's demands
     */
    public void pay() {
        //if you can afford to pay the bandit
        double num = player.getCredits() - demand;
        //num is the amount you'd have after paying the bandit
        if (num >= 0.0) {
            //pay bandit
            player.setCredits(num);
        } else {
            //cannot afford to pay bandit
            //if you have items that the bandit can take
            if (player.getShip().getCargo().size() > 0) {
                //bandit takes them all
                player.getShip().clearCargo();
            } else {
                //bandit damages ship
                player.getShip().setHealth(player.getShip().getHealth() - (gen.nextInt(201) + 100));
            }
        }
        //continue travel no matter what happened
    }
}

