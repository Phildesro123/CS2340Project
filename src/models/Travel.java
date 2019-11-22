package models;


public class Travel {
<<<<<<< HEAD
    private Ship ship;
    private double diff;
    private int[] skills;

    public Travel(Ship ship, double diff, int[] skills) {
        this.ship = ship;
=======
    private double diff;
    private int[] skills;

    public Travel(double diff, int[] skills) {
>>>>>>> 1f51a90e32352eaa87c1e2c7552b15131f7de36d
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
<<<<<<< HEAD
    public boolean canTravel(double dist) {
        int fuel = ship.getFuel();
        return (fuel > fuelCost(dist));
    }

    public void traveling(double dist) {
        int fuel = ship.getFuel();
        if (canTravel(dist)) {
=======
    public boolean canTravel(Ship ship, double dist) {
        double fuel = ship.getFuel();
        return (fuel >= fuelCost(dist));
    }

    public void traveling(Ship ship, double dist) {
        double fuel = ship.getFuel();
        if (canTravel(ship, dist)) {
>>>>>>> 1f51a90e32352eaa87c1e2c7552b15131f7de36d
            fuel = fuel - fuelCost(dist);
            ship.setFuel(fuel);
        }
    }
}
