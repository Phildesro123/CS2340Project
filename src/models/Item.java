package models;
import models.enums.ItemData;
import models.enums.ItemType;

public class Item {
    private double basePrice;
    private ItemType type;

    /**
     * Creates Item object
     * @param p Base price of item
     * @param t Item type
     */
    public Item(double p, ItemType t) {
        this.basePrice = p;
        this.type = t;
    }


    public Item(ItemData item) {
        this(item.getPrice(), item.getType());
    }



    /**
     * Get the item type
     * @return Item type
     */
    public ItemType getItemType() {
        return type;
    }

    /**
     * Get's base price of item
     * @return Base price of item
     */
    public double getBasePrice() {
        return basePrice;
    }
}
