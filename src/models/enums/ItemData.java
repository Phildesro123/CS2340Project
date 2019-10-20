package models.enums;

public enum ItemData {
    RUSTYSWORD(30.0, ItemType.RUSTY),
    RUSTYAXE(32.0, ItemType.RUSTY),
    RUSTYLANCE(31.0, ItemType.RUSTY),
    RUSTYBOW(35.0, ItemType.RUSTY),
    RUSTYGAUNTLET(40.0, ItemType.RUSTY),
    IRONSWORD(40.0, ItemType.IRON),
    IRONAXE(42.0, ItemType.IRON),
    IRONLANCE(41.0, ItemType.IRON),
    IRONBOW(45.0, ItemType.IRON),
    HAMMER(35.0, ItemType.IRON),
    IRONGAUNTLET(50.0, ItemType.IRON),
    STEELSWORD(45.0, ItemType.STEEL),
    STEELAXE(47.0, ItemType.STEEL),
    STEELGAUNTLET(55.0, ItemType.STEEL),
    STEELBOW(50.0, ItemType.STEEL),
    STEELLANCE(46.0, ItemType.STEEL),
    SILVERSWORD(50.0, ItemType.SILVER),
    SILVERAXE(51.0, ItemType.SILVER),
    SILVERLANCE(53.0, ItemType.SILVER),
    SILVERBOW(55.0, ItemType.SILVER),
    SILVERGAUNTLET(60.0, ItemType.SILVER),
    BRAVESWORD(50.0, ItemType.BRAVE),
    BRAVEAXE(52.0, ItemType.BRAVE),
    BRAVELANCE(51.0, ItemType.BRAVE),
    BRAVEBOW(55.0, ItemType.BRAVE),
    KILLINGEDGE(70.0, ItemType.KILLER),
    KILLERLANCE(71.0, ItemType.KILLER),
    KILLERAXE(72.0, ItemType.KILLER),
    KILLERBOW(75.0, ItemType.KILLER),
    KILLERHAMMER(78.0, ItemType.KILLER),
    AUTOCROSSBOW(90.0, ItemType.BRAVE);
    private double price;
    private ItemType type;

    ItemData(double price, ItemType type) {
        this.price = price;
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public ItemType getType() {
        return type;
    }
}
