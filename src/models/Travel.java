package models;
import models.enums.Difficulty;


public class Travel {
    private Player player;
    private Game game;
    private Ship ship1;

    public int fuelCost(double dist) {
        int fuel;
        Difficulty diff = game.getDifficulty();
        double diffMod = diff.modifier();
        int pilot = player.getSkillSet()[0];
        double pilotMult = (pilot * 1.27) / 100.0;
        fuel = (int) ((dist * diffMod) * pilotMult);
        return fuel;
    }
    public Travel(Ship ship) {
        this.ship1 = ship;
    }
    public Travel() {

    }

}
