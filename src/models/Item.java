package models;

import models.enums.ItemType;

public class Item {
    double basePrice;
    ItemType type;
    public Item (double p, ItemType t) {
        this.basePrice = p;
        this.type = t;
    }
}
