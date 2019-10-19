package models.enums;

import models.Item;
import models.Market;

public enum TechLevel {
    PREAG(new Market(items(new ItemData[]{
        ItemData.RUSTYSWORD,
        ItemData.RUSTYAXE,
        ItemData.RUSTYBOW,
        ItemData.RUSTYGAUNTLET,
        ItemData.RUSTYLANCE,
        ItemData.IRONAXE,
        ItemData.IRONGAUNTLET,
        ItemData.IRONLANCE,
        ItemData.IRONSWORD,
        ItemData.IRONBOW,
        ItemData.HAMMER,
    }))),
    AGRICULTURE(new Market(items(new ItemData[] {
        ItemData.STEELAXE,
        ItemData.STEELSWORD,
        ItemData.STEELLANCE,
        ItemData.STEELGAUNTLET,
        ItemData.STEELBOW,
        ItemData.IRONAXE,
        ItemData.IRONGAUNTLET,
        ItemData.IRONLANCE,
        ItemData.IRONSWORD,
        ItemData.IRONBOW,
        ItemData.HAMMER
    }))),
    MEDIEVAL(new Market(items(new ItemData[] {
        ItemData.STEELAXE,
        ItemData.STEELSWORD,
        ItemData.STEELLANCE,
        ItemData.STEELGAUNTLET,
        ItemData.STEELBOW,
        ItemData.IRONAXE,
        ItemData.IRONGAUNTLET,
        ItemData.IRONLANCE,
        ItemData.IRONSWORD,
        ItemData.IRONBOW,
        ItemData.HAMMER
    }))),
    RENAISSANCE(new Market(items(new ItemData[]{
        ItemData.SILVERAXE,
        ItemData.SILVERSWORD,
        ItemData.SILVERLANCE,
        ItemData.SILVERGAUNTLET,
        ItemData.SILVERBOW,
        ItemData.STEELAXE,
        ItemData.STEELSWORD,
        ItemData.STEELLANCE,
        ItemData.STEELGAUNTLET,
        ItemData.STEELBOW
    }))),
    INDUSTRIAL(new Market(items(new ItemData[]{
        ItemData.SILVERAXE,
        ItemData.SILVERLANCE,
        ItemData.SILVERGAUNTLET,
        ItemData.SILVERBOW,
        ItemData.SILVERSWORD,
        ItemData.STEELAXE,
        ItemData.STEELLANCE,
        ItemData.STEELGAUNTLET,
        ItemData.STEELBOW,
        ItemData.KILLINGEDGE
    }))),
    MODERN(new Market(items(new ItemData[] {
        ItemData.SILVERAXE,
        ItemData.SILVERLANCE,
        ItemData.SILVERGAUNTLET,
        ItemData.SILVERBOW,
        ItemData.SILVERSWORD,
        ItemData.KILLINGEDGE,
        ItemData.KILLERLANCE,
        ItemData.KILLERBOW,
        ItemData.KILLERAXE
    }))),
    FUTURISTIC(new Market(items(new ItemData[] {
        ItemData.KILLINGEDGE,
        ItemData.KILLERLANCE,
        ItemData.KILLERBOW,
        ItemData.KILLERAXE,
        ItemData.BRAVESWORD,
        ItemData.BRAVELANCE,
        ItemData.BRAVEBOW,
        ItemData.BRAVEAXE,
        ItemData.KILLERHAMMER,
        ItemData.AUTOCROSSBOW
    })));


    private Market market;

    TechLevel(Market market) {
        this.market = market;
    }

    public Market getMarket() {
        return market;
    }

    private static Item[] items(ItemData[] items) {
        Item[] items1 = new Item[items.length];
        for (int i = 0; i < items1.length; i++) {
            items1[i] = new Item(items[i]);
        }
        return items1;
    }

}


// May add items for tech levels