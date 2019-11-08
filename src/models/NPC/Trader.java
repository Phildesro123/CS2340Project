package models.NPC;
import models.Item;
import models.Player;
import models.enums.ItemData;
import java.util.ArrayList;
import java.util.Random;
public class Trader extends NPC {
    private ArrayList<Item> cargo;

    private boolean angry;
    private Player player;

    public Trader(Player p) {
        super("Trader", "assets/img/merchant.png");
        Random rand = new Random();
        ItemData[] itemData = ItemData.values();
        cargo = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cargo.add(new Item(itemData[rand.nextInt(itemData.length)]));
        }
        player = p;
        angry = false;
    }

    /**
     * Player can rob trader
     * @param val
     * @return
     */
    public int commitRobbery(int val) {
        if (val > 60) {
            //Random number between 1-3 items
            Random rand = new Random();
            for (int i = 0; i < (rand.nextInt(3) + 1); i++) {
                player.getShip().addCargo(cargo.remove(rand.nextInt(cargo.size())));
            }

        }
        //return number
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

    /**
     * Finds item to remove from cargo
     * @param item Item to remove from NPC cargo
     * @return Item that was removed
     */
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
    @Override
    public void interact() {
        System.out.println("Is that the one? Thanks a bunch!");
    }
}
