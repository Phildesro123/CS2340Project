package models;

public class Market {
    /*
    Will have a list of items it can sell based on tech level of region
    The tech level class will have a list of items for each tech level
     */
    //[Sword, Axe, Lance, Bow, Gauntlet, Staff, Club, Crossbow, Scythe, Dagger]
    private Game game;
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

    @Override
    public String toString() {
        String s = "";
        for (Item i : items) {
            s += String.format("Name: %s\n", i.getName());
        }
        return s;
    }
}
