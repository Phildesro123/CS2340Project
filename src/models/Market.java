package models;

public class Market {
    //[Sword, Axe, Lance, Bow, Gauntlet, Staff, Club, Crossbow, Scythe, Dagger]
    private Item[] items;
    public Market(Item[] i) {
        this.items = i;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] i) {
        items = i;
    }
}
