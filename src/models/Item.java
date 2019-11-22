package models;
import models.enums.ItemData;
import models.enums.ItemType;

public class Item {
    private double basePrice;
    private ItemType type;
    private String name;
<<<<<<< HEAD
=======
    private String weaponClass;
>>>>>>> 1f51a90e32352eaa87c1e2c7552b15131f7de36d

    /**
     * Crates Item object
     * @param p Price of item
     * @param t Type of item
     * @param name Name of item
<<<<<<< HEAD
     */
    public Item(double p, ItemType t, String name) {
        this.basePrice = p;
        this.type = t;
        this.name = name;
=======
     * @param wc Class of the weapon
     */
    public Item(double p, ItemType t, String name, String wc) {
        this.basePrice = p;
        this.type = t;
        this.name = name;
        this.weaponClass = wc;
>>>>>>> 1f51a90e32352eaa87c1e2c7552b15131f7de36d
    }

    /**
     * Creates Item object
     * @param item ItemData object that holds information about the item
     */
    public Item(ItemData item) {
<<<<<<< HEAD
        this(item.getPrice(), item.getType(), item.toString());
    }


=======
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
>>>>>>> 1f51a90e32352eaa87c1e2c7552b15131f7de36d

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
<<<<<<< HEAD
=======

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
>>>>>>> 1f51a90e32352eaa87c1e2c7552b15131f7de36d
}
