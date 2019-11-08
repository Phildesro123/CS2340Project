package models.NPC;
import models.Item;

import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
import java.util.Map;

<<<<<<< HEAD

=======
>>>>>>> 9944f43e57d49caf3bc4ec2467f96e148bbcd8e3
public class Police extends NPC {
    private ArrayList<Item> cargo;
    private double credits;
    private Random gen = new Random();
    private Map<Item, Integer> contraband = new HashMap<>();

    public Police(ArrayList<Item> cargo, double credits) {
        super("Police", "assets/img/cop.png");
        this.cargo = cargo;
        this.credits = credits;
        name = "Seteth"; //make random somehow later
        //image = cop.png; I don't think this is the right way to access the image
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
<<<<<<< HEAD
        //Do stuff

=======
        System.out.println("Wee woo wee woo");
>>>>>>> 9944f43e57d49caf3bc4ec2467f96e148bbcd8e3
    }
}
