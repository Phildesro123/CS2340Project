package models.NPC;

import javax.swing.*;
import java.util.Random;

public class Bandit extends NPC {
    private String name;
    private ImageIcon image;
    private Player player;
    Random gen = new Random();

    public Bandit(Player player) {
        name = "Flayn"; //make random somehow later
        this.player = player;
        //image = bandit.png; I don't think this is the right way to access the image

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
        }
    }
}
