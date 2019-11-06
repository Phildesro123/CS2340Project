package models.NPC;
import models.Item;

import javax.swing.*;
import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
import java.util.Map;

public class Police implements NPC {
    private ArrayList<Item> cargo;
    private double credits;
    private Random gen = new Random();
    private Map<Item, Integer> contraband = new HashMap<>();
    public Police(ArrayList<Item> cargo, double credits) {
        this.cargo = cargo;
        this.credits = credits;
    }
    /*
    Ok you need a random gen for the items so you will have to check how many i would say a max of 3
     */
    public Map<Item, Integer> whichItems() {
        if (cargo.size() == 1) {
            contraband.put(cargo.get(0), 0);
        } else if (cargo.size() == 2) {
            for (int i = 0; i < cargo.size(); i++) {
                contraband.put(cargo.get(i), i);
            }
        } else {
            for (int i = 0; i < 3; i++) {
                int x = gen.nextInt(cargo.size());
                if (contraband.containsValue(x)) {
                    i--;
                } else {
                    contraband.put(cargo.get(x), x);
                }
            }
        }
        return contraband;
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
}
