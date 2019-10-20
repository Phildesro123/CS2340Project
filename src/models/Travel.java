package models;
import models.enums.Difficulty;


public class Travel {
    private Player player;
    private Ship ship;
    private double diff;
    private int[] skills;

    public Travel(Ship ship, double diff, int[] skills) {
        this.ship = ship;
        this.diff = diff;
        this.skills = skills;
    }
    public int fuelCost(double dist) {
        int fuel;
        int pilot = skills[0];
        double pilotMult = 1.0 + (Math.pow(1.27, pilot) / 100.0);
        fuel = (int) ((dist * diff) / pilotMult);
        return fuel;
    }
    public boolean canTravel(double dist) {
        int fuel = ship.getFuel();
        return (fuel > fuelCost(dist));
    }

    public void traveling(double dist) {
        int fuel = ship.getFuel();
        if (canTravel(dist)) {
            fuel = fuel - fuelCost(dist);
            ship.setFuel(fuel);
        }
    }
}
