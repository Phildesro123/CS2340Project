package models.NPC;
import models.Item;
import models.Player;
import models.enums.ItemData;
import java.util.ArrayList;
import java.util.Random;
public class Trader extends NPC {
    private ArrayList<Item> cargo;
    private boolean angry;
    private boolean negotiated;
    private double modifier;
    private Player player;
    public Trader(Player p) {
        super("Trader", "assets/img/merchant.png", p);
        Random rand = new Random();
        ItemData[] itemData = ItemData.values();
        cargo = new ArrayList<>();
        //Generates a new cargo every time
        //gets 9 normal items and then 1 regalia item
        for (int i = 0; i < 9; i++) {
            cargo.add(new Item(itemData[rand.nextInt(itemData.length - 4)]));
        }
        cargo.add(new Item(itemData[rand.nextInt(4) + (itemData.length - 4)]));
        angry = false;
        negotiated = false;
        modifier = 1;
    }

    @Override
    public void interact() {
        System.out.println("Is that the one? Thanks a bunch!");
        //choose whether to buy, ignore, rob, or negotiate
    }

    /**
     * Player can rob merchants
     */
    public void commitRobbery() {
        Random rand = new Random();
        //fighter value skill check
        int num = rand.nextInt(16);
        //if player wins
        if(num <= player.getSkillSet()[1]) {
            //Random number between 1-3 items
            for (int i = 0; i < (rand.nextInt(3) + 1); i++) {
                player.getShip().addCargo(cargo.remove(rand.nextInt(cargo.size())));
            }

        } else {
            //Do a random # of damage (between 100-300)
            player.getShip().setHealth(player.getShip().getHealth() - (rand.nextInt(201) + 100));
        }
    }

    /**
     * Sells item
     * @param item Item to sell
     * @return Sale prompt
     */
    public String sellItem(Item item) {
        if (cargo.size() > 0) {
            if (player.getShip().canAddCargo()) {
                //Player has space to buy items
                if (!angry) {
                    player.getShip().addCargo(item);
                    player.setCredits(player.getCredits() - (item.getBasePrice() * modifier));
                    //Probably use these string returns as a JLabel or box output? Idk.
                    return "Thank you for your business!";
                } else {
                    player.getShip().addCargo(item);
                    player.setCredits(player.getCredits() - (item.getBasePrice() * modifier));
                    return "Thanks.";
                }
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
            //Check the math on this, I don't know if this is a good modifier for the player's merchant price
            player.setCredits(player.getCredits() + item.price(player.getSkillSet()[2] / 20));
            return true;
        } else {
            //Trader cannot buy an item, throw an error message or something
            return false;
        }
    }

    public boolean negotiate() {
        if (!negotiated) {
            Random rand = new Random();
            int val = rand.nextInt(100) + player.getSkillSet()[2];

            if (val > 75) {
                negotiated = true;
                modifier = 0.8;
                return true;
            } else {
                negotiated = true;
                angry = true;
                modifier = 1.2;
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Changes the state of trader's anger
     * True if they are angry, False if they are not angry
     * @param angry Whether NPC is angry or not. True if they are false if they aren't
     */
    public void setAngry(boolean angry) {
        this.angry = angry;
    }

    /**
     * Set the cargo of trader
     * @param cargo Cargo for trader
     */
    public void setCargo(ArrayList<Item> cargo) {
        this.cargo = cargo;
    }

    /**
     * Get the player that the NPC will interact with
     * @return Player that NPC is interacting with
     */
    public Player getPlayer() {
        return player;
    }
}
