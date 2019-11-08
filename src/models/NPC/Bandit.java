package models.NPC;

import javax.swing.*;
import java.util.Random;

public class Bandit extends NPC {
    private String name;
    private String image;
    private Player player;
    private int demand;
    Random gen = new Random();

    public Bandit(Player player) {
        name = "Flayn"; //make random somehow later
        this.player = player;
        demand = gen.nextInt(51) + 50;
        image = "bandit.png"; 
    }

    @Override
    public void interact() {
        System.out.println("Vibe check");
        //choose between paying credits, fleeing, or fighting
    }

    @Override
    public void fight() {
        //skill check 
        //bandit's fighter skill should be random?
        int num = gen.nextInt(21);
        //if player loses
        if(num > player.getSkillSet()[1]) {
            //lose
        } else {
            //win
            //continue to travel successfully
            //gain credits
            player.setCredits(player.getCredits() + gen.nextInt(26) + 25); 
        }
    }
}
