package models.NPC;
import models.Item;
import models.Karma;
import models.Player;
import models.enums.ItemData;
import screens.GameOver;

import java.util.ArrayList;
import java.util.Random;

public class Trader extends NPC {
    private ArrayList<Item> wares;
    private boolean angry;
    private boolean negotiated;
    private double modifier;
    private Player player;
    private Random rand;
    private Karma karma;


    public Trader(Player p) {
        super("Anna", "assets/img/merchant.png", p);
        this.karma = new Karma();
        rand = new Random();
        ItemData[] itemData = ItemData.values();
        wares = new ArrayList<>();
        //Generates multiple regalia items
        Item ware = new Item(itemData[rand.nextInt(4) + (itemData.length - 4)]);
        for (int i = 0; i < 4; i++) {
            wares.add(ware);
        }
        angry = false;
        negotiated = false;
        modifier = 1;
    }

    @Override
    public void interact() {
        System.out.println("Is that the one? Thanks a bunch!");
        //shows the wares of the trader
        //choose whether to buy, ignore, rob, or negotiate
        //only display negotiate button if negotiated is false
        //if choosing to buy, needs a string input somehow to choose which item to buy
    }

    /**
     * Ignore the trader
     */
    public void ignore() {
        //just leave and go to the destination
        //it'd be cool if we could make it so that the next
        //time you run into the same trader they were angry that you ignored them
    }

    /**
     * Player can rob merchants
     */
    public void commitRobbery() {
        //fighter value skill check
        int num = rand.nextInt(11); //traders aren't great fighters
        //if player wins
        if (num <= player.getSkillSet()[1] + player.getShip().getDamageMod()) {
            //Random number between 1-3 items
            for (int i = 0; i < (rand.nextInt(3) + 1); i++) {
                player.getShip().addCargo(wares.remove(rand.nextInt(wares.size())));
            }
        } else {
            //Do a random # of damage (between 100-300)
            player.getShip().setHealth(player.getShip().getHealth() - (rand.nextInt(201) + 100));
            if (player.getShip().getHealth() <= 0) {
                GameOver end = new GameOver(false);
            }
        }
        //continue to travel
    }



    /**
     * Buys item
     * @param item Item to buy from trader
     * @return Sale prompt
     */
    public String buyItem(Item item) {
        if (wares.size() > 0) {
            if (player.getShip().canAddCargo()
                    && player.getCredits() - wares.get(0).price(modifier) >= 0) {
                //Player has space to buy items
                player.getShip().addCargo(item);
                player.setCredits(player.getCredits() - (item.price(modifier)));
                if (!angry) {
                    //Probably use these string returns as a JLabel or box output? Idk.
                    if (!negotiated) {
                        karma.addKarma();
                    }
                    return "Thank you for your business!";
                } else {
                    return "Thanks.";
                }
            } else {
                //Can't sell any items
                return "Sorry, we can't put this item in your inventory. Get more space.";
            }
        } else {
            return "We're sold out!";
        }
        //return to interact screen to choose between buying, ignoring, robbing, or negotiating
    }

    /* selling an item is not needed for the milestone but is an option for future implementation
    public boolean sellItem(Item item) {
        //Player sells item
        if (player.getShip().getCargo().size() > 0) {
            //Check the math on this, I don't know if this is a
            good modifier for the player's merchant price
            player.setCredits(player.getCredits() + item.price(player.getSkillSet()[2] / 20));
            return true;
        } else {
            //Trader cannot buy an item, throw an error message or something
            return false;
        }
    }*/

    /**
     * Negotiate with the trader to try to get a better price
     * True if successful, false if failed/made them angry
     * @return a success boolean
     */
    public boolean negotiate() {
        if (!negotiated) {
            int num = rand.nextInt(14) + 2; //traders aren't bad at negotiating
            //if player succeeds
            if (num <= player.getSkillSet()[2] + (karma.getKarma() / 2)) {
                negotiated = true;
                modifier = 0.625;
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
        //return to interact screen to choose between buying, ignoring, or robbing
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
     * Set the wares of trader
     * @param wares Wares for trader
     */
    public void setWares(ArrayList<Item> wares) {
        this.wares = wares;
    }

    /**
     * Get's merchant's cargo
     * @return Merchant's cargo
     */
    public ArrayList getCargo() {
        return wares;
    };
    /**
     * Get the player that the NPC will interact with
     * @return Player that NPC is interacting with
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Changes player
     * @param player Player to chnage to
     */
    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    public double getModifier() {
        return modifier;
    }
}
