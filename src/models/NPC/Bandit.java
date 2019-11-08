package models.NPC;

import javax.swing.*;

public class Bandit extends NPC {
    private String name;
    private ImageIcon image;

    public Bandit() {
        name = "Flayn"; //make random somehow later
        //image = bandit.png; I don't think this is the right way to access the image

    }

    @Override
    public void interact() {
        System.out.println("Vibe check");
    }
}
