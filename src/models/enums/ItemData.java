package models.enums;

public enum ItemData {
    RUSTYSWORD(30.0, ItemType.RUSTY, "Rusty Sword", "Sword"),
    RUSTYAXE(32.0, ItemType.RUSTY, "Rusty Axe", "Axe"),
    RUSTYLANCE(31.0, ItemType.RUSTY, "Rusty Lance", "Lance"),
    RUSTYBOW(35.0, ItemType.RUSTY, "Rusty Bow", "Bow"),
    RUSTYGAUNTLET(40.0, ItemType.RUSTY, "Rusty Gauntlets", "Fists"),
    IRONSWORD(40.0, ItemType.IRON, "Iron Sword", "Sword"),
    IRONAXE(42.0, ItemType.IRON, "Iron Axe", "Axe"),
    IRONLANCE(41.0, ItemType.IRON, "Iron Lance", "Lance"),
    IRONBOW(45.0, ItemType.IRON, "Iron Bow", "Bow"),
    HAMMER(35.0, ItemType.IRON, "Hammer", "Hammer"),
    IRONGAUNTLET(50.0, ItemType.IRON, "Iron Gauntlets", "Fists"),
    STEELSWORD(45.0, ItemType.STEEL, "Steel Sword", "Sword"),
    STEELAXE(47.0, ItemType.STEEL, "Steel Axe", "Axe"),
    STEELGAUNTLET(55.0, ItemType.STEEL, "Steel Gauntlet", "Fists"),
    STEELBOW(50.0, ItemType.STEEL, "Steel Bow", "Bow"),
    STEELLANCE(46.0, ItemType.STEEL, "Steel Lance", "Lance"),
    SILVERSWORD(50.0, ItemType.SILVER, "Silver Sword", "Sword"),
    SILVERAXE(51.0, ItemType.SILVER, "Silver Axe", "Axe"),
    SILVERLANCE(53.0, ItemType.SILVER, "Silver Lance", "Lance"),
    SILVERBOW(55.0, ItemType.SILVER, "Silver Bow", "Bow"),
    SILVERGAUNTLET(60.0, ItemType.SILVER, "Silver Gauntlet", "Fists"),
    BRAVESWORD(50.0, ItemType.BRAVE, "Brave Sword", "Sword"),
    BRAVEAXE(52.0, ItemType.BRAVE, "Brave Axe", "Axe"),
    BRAVELANCE(51.0, ItemType.BRAVE, "Brave Lance", "Lance"),
    BRAVEBOW(55.0, ItemType.BRAVE, "Brave Bow", "Bow"),
    KILLINGEDGE(70.0, ItemType.KILLER, "Killing Edge", "Sword"),
    KILLERLANCE(71.0, ItemType.KILLER, "Killer Lance", "Lance"),
    KILLERAXE(72.0, ItemType.KILLER, "Killer Axe", "Axe"),
    KILLERBOW(75.0, ItemType.KILLER, "Killer Bow", "Bow"),
    KILLERHAMMER(78.0, ItemType.KILLER, "Killer Hammer", "Hammer"),
    AUTOCROSSBOW(90.0, ItemType.BRAVE, "Auto Cross Bow", "Bow");
    private double price;
    private ItemType type;
    private String name;
    private String weaponClass;

    ItemData(double price, ItemType type, String name, String weaponClass) {
        this.price = price;
        this.type = type;
        this.name = name;
        this.weaponClass = weaponClass;
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

    public String getWeaponClass() {
        return weaponClass;
    }
}
