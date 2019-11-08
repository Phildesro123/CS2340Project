package models.NPC;
import models.Item;
import models.Player;
import models.enums.ItemData;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Trader implements NPC {
    private ArrayList<Item> cargo;
    private boolean angry;
    private Player player;

    public Trader(Player p) {
        Random rand = new Random();
        ItemData[] itemData = ItemData.values();
        cargo = new ArrayList<>();
        //Generates a new cargo every time
        for (int i = 0; i < 10; i++) {
            cargo.add(new Item(itemData[rand.nextInt(itemData.length)]));
        }
        player = p;
        angry = false;
    }

    public int commitRobbery() {
        Random rand = new Random();
        int val = rand.nextInt(100) + player.getSkillSet()[1];
        if (val > 60) {
            //Random number between 1-3 items
            for (int i = 0; i < (rand.nextInt(3) + 1); i++) {
                player.getShip().addCargo(cargo.remove(rand.nextInt(cargo.size())));
            }
            //This value is a dummy value, don't use it, all the logic occurs above this statement.
            return -1;
        } else {
            //Return a random # of damage
            return rand.nextInt(player.getShip().getHealth() / 4);
        }
    }

    public String sellItem(Item item) {
        if (cargo.size() > 0) {
            if (player.getShip().canAddCargo()) {
                //Player has space to buy items


                //Probably use these string returns as a JLabel or box output?
                return "Thank you for your business!";
            } else {
                //Can't sell any items
                return "Sorry, we can't put this item in your inventory. Get more space.";
            }
        } else {
            return "We're sold out!";
        }
    }

    public boolean buyItem(Item item) {
        //Trader buys item
        if (player.getShip().getCargo().size() > 0) {
            player.setCredits(player.getCredits() + item.price(player.getSkillSet()[2] / 20));
            return true;
        } else {
            //Trader cannot buy an item, throw an error message or something
            return false;
        }
    }

    @Override
    public void interact() {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public ImageIcon getImage() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void setImage(ImageIcon icon) {

    }

    public void setAngry(boolean angry) {
        this.angry = angry;
    }

    public void setCargo(ArrayList<Item> cargo) {
        this.cargo = cargo;
    }

    public Player getPlayer() {
        return player;
    }

}
