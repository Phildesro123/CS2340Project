package models;
import models.enums.ItemData;
import models.enums.ItemType;

public class Item {
    private double basePrice;
    private ItemType type;
    private String name;
    private String weaponClass;

    /**
     * Crates Item object
     * @param p Price of item
     * @param t Type of item
     * @param name Name of item
     * @param wc Class of the weapon
     */
    public Item(double p, ItemType t, String name, String wc) {
        this.basePrice = p;
        this.type = t;
        this.name = name;
        this.weaponClass = wc;
    }

    /**
     * Creates Item object
     * @param item ItemData object that holds information about the item
     */
    public Item(ItemData item) {
        this(item.getPrice(), item.getType(), item.getName(),
                item.getWeaponClass());
    }

    /**
     * Get the weapon class
     * @return weapon class
     */
    public String getWeaponClass() {
        return weaponClass;
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

    public double price(double modifier) {
        return Math.round(basePrice * modifier);
    }

    public double price(double modifier, double price) {
        if (price * modifier < 5.0) {
            return 5.0;
        } else {
            return Math.round(price * modifier);
        }
    }

    @Override
    public boolean equals(Object obj) {
        Item i = (Item) obj;
        return name.equals(i.getName()) && type == i.getItemType();
    }
}
