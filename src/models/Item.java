package models;
import models.enums.ItemData;
import models.enums.ItemType;

public class Item {
    private double basePrice;
    private ItemType type;
    private String name;

    /**
     * Crates Item object
     * @param p Price of item
     * @param t Type of item
     * @param name Name of item
     */
    public Item(double p, ItemType t, String name) {
        this.basePrice = p;
        this.type = t;
        this.name = name;
    }

    /**
     * Creates Item object
     * @param item ItemData object that holds information about the item
     */
    public Item(ItemData item) {
        this(item.getPrice(), item.getType(), item.toString());
    }



    /**
     * Get the item type
     * @return Item type
     */
    public ItemType getItemType() {
        return type;
    }

    /**
     * Get's the name of item
     * @return Name of item
     */
    public String getName() {
        return name;
    }

    /**
     * Get's base price of item
     * @return Base price of item
     */
    public double getBasePrice() {
        return basePrice;
    }
}
