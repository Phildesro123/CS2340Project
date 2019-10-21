package models.enums;

public enum ItemData {
    RUSTYSWORD(30.0, ItemType.RUSTY, "Rusty Sword"),
    RUSTYAXE(32.0, ItemType.RUSTY, "Rusty Axe"),
    RUSTYLANCE(31.0, ItemType.RUSTY, "Rusty Lance"),
    RUSTYBOW(35.0, ItemType.RUSTY, "Rusty Bow"),
    RUSTYGAUNTLET(40.0, ItemType.RUSTY, "Rusty Gauntlets"),
    IRONSWORD(40.0, ItemType.IRON, "Iron Sword"),
    IRONAXE(42.0, ItemType.IRON, "Iron Axe"),
    IRONLANCE(41.0, ItemType.IRON, "Iron Lance"),
    IRONBOW(45.0, ItemType.IRON, "Iron Bow"),
    HAMMER(35.0, ItemType.IRON, "Hammer"),
    IRONGAUNTLET(50.0, ItemType.IRON, "Iron Gauntlet"),
    STEELSWORD(45.0, ItemType.STEEL, "Steel Sword"),
    STEELAXE(47.0, ItemType.STEEL, "Steel Axe"),
    STEELGAUNTLET(55.0, ItemType.STEEL, "Steel Gauntlet"),
    STEELBOW(50.0, ItemType.STEEL, "Steel Bow"),
    STEELLANCE(46.0, ItemType.STEEL, "Steel Lance"),
    SILVERSWORD(50.0, ItemType.SILVER, "Silver Sword"),
    SILVERAXE(51.0, ItemType.SILVER, "Silver Axe"),
    SILVERLANCE(53.0, ItemType.SILVER, "Silver Lance"),
    SILVERBOW(55.0, ItemType.SILVER, "Silver Bow"),
    SILVERGAUNTLET(60.0, ItemType.SILVER, "Silver Gauntlet"),
    BRAVESWORD(50.0, ItemType.BRAVE, "Brave Sword"),
    BRAVEAXE(52.0, ItemType.BRAVE, "Brave Axe"),
    BRAVELANCE(51.0, ItemType.BRAVE, "Brave Lance"),
    BRAVEBOW(55.0, ItemType.BRAVE, "Brave Bow"),
    KILLINGEDGE(70.0, ItemType.KILLER, "Killing Edge"),
    KILLERLANCE(71.0, ItemType.KILLER, "Killer Lance"),
    KILLERAXE(72.0, ItemType.KILLER, "Killer Axe"),
    KILLERBOW(75.0, ItemType.KILLER, "Killer Bow"),
    KILLERHAMMER(78.0, ItemType.KILLER, "Killer Hammer"),
    AUTOCROSSBOW(90.0, ItemType.BRAVE, "Auto Cross Bow");
    private double price;
    private ItemType type;
    private String name;

    ItemData(double price, ItemType type, String name) {
        this.price = price;
        this.type = type;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public ItemType getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
