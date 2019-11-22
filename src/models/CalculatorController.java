package models;

public class CalculatorController {
    /**
     * Gets selling price of item based on region and player's merchant skill
     * @param player Player
     * @param region Current region
     * @param item Current item
     * @return Selling price of item
     */
    public double priceSellCalculator(Player player, Region region, Item item) {
        if (player.getSkillSet()[2] > 0) {
            System.out.println(player.getSkillSet()[2] * 1.08);
            return item.price(player.getSkillSet()[2] * 0.8, item.price(region.getInflationS()));
        } else {
            return item.price(region.getInflationS());
        }
    }

    /**
     * Gets the buying price of item based on region and player's merchant skill
     * @param player Player
     * @param region Current region
     * @param item Current item
     * @return Price of item based on player's trading skill and region's stats.
     */
    public double priceBuyCalculator(Player player, Region region, Item item) {
        System.out.println((player.getSkillSet()[2] / 100.0) + "Buy");
        if (player.getSkillSet()[2] > 0) {
            return item.price(1.0 / (player.getSkillSet()[2]), item.price(region.getInflationB()));
        } else {
            return item.price(region.getInflationB());
        }
    }
}
