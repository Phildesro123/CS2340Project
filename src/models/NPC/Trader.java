package models.NPC;
import javax.swing.*;

public class Trader extends NPC {
    private Player player;

    public Trader(Player player) {
        name = "Anna"; //make random somehow later
        this.player = player;
        //image = merchant.png; I don't think this is the right way to access the image

    }

    @Override
    public void interact() {
        System.out.println("Is that the one? Thanks a bunch!");
    }
}
