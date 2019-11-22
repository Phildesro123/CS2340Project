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
            return item.price(item.price(region.getInflationS()),
                    player.getSkillSet()[2] * 0.8);
        } else {
            return item.price(region.getInflationS());
        }
    }

    /**
     * Gets the buying price of item based on region and player's merchant skill
     * @param player Player
     * @param region Current region
     * @param item Current item
     * @return
     */
    public double priceBuyCalculator(Player player, Region region, Item item) {
        System.out.println((player.getSkillSet()[2] / 100.0) + "Buy");
        if (player.getSkillSet()[2] > 0) {
            return item.price(item.price(region.getInflationB()),
                    1.0 / 1 + (player.getSkillSet()[2] / 100.0));
        } else {
            return item.price(region.getInflationB());
        }
    }
}
