package models;


public class Travel {

    private double diff;
    private int[] skills;

    public Travel(double diff, int[] skills) {
        this.diff = diff;
        this.skills = skills;
    }
    public int fuelCost(double dist) {
        int fuel;
        int pilot = skills[0];
        double pilotMult = 1.0 - (Math.pow(1.273, pilot) / 100.0);
        fuel = (int) ((dist * diff) * pilotMult);
        return fuel;
    }

    public boolean canTravel(Ship ship, double dist) {
        double fuel = ship.getFuel();
        return (fuel >= fuelCost(dist));
    }

    public void traveling(Ship ship, double dist) {
        double fuel = ship.getFuel();
        if (canTravel(ship, dist)) {
            fuel = fuel - fuelCost(dist);
            ship.setFuel(fuel);
        }
    }
}
