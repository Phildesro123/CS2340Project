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
        for (int i = 0; i < 10; i++) {
            cargo.add(new Item(itemData[rand.nextInt(itemData.length)]));
        }
        player = p;
        angry = false;
    }

    public int commitRobbery(int val) {
        if (val > 60) {
            //Random number between 1-3 items
            Random rand = new Random();
            for (int i = 0; i < (rand.nextInt(3) + 1); i++) {
                player.getShip().addCargo(cargo.remove(rand.nextInt(cargo.size())));
            }

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

    public Item findItemToRemove(Item item) {
        if (cargo.indexOf(item) > -1) {
            return item;
        } else {
            boolean foundType = false;
            boolean compare = false;
            int i = 0;
            Item foundItem = null;
            while (!foundType && i < cargo.size()) {
                compare = cargo.get(i).getWeaponClass()
                        .equals(item.getWeaponClass());
                if (compare) {
                    foundType = true;
                    foundItem = cargo.get(i);
                }
                i++;
            }
            return foundItem;
        }
    }
}
