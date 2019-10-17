package models;

import models.enums.ShipType;

import java.util.ArrayList;

public class Ship {
    private double fuel;
    private ArrayList<Item> cargo;
    private int health;
    private String type;
    private int maxCargo;

    /**
     * Creates a ship object
     * @param shipType Type of ship
     */
    public Ship(ShipType shipType) {
        fuel = shipType.shipFuel();
        cargo = new ArrayList<>();
        health = shipType.shipHealth();
        type = shipType.shipName();
        maxCargo = shipType.cargoSpace();
    }

    /**
     * Adds item to cargo
     * @param item Item to add to cargo
     * @return True if item was added, false otherwise
     */
    public boolean addCargo(Item item) {
        if (cargo.size() + 1 > maxCargo) {
            return false;
        } else {
            cargo.add(item);
            return true;
        }
    }

    /**
     * Remove the cargo from
     * @param item Item to remove from cargo
     * @return True if the item was removed, false otherwise
     */
    public boolean removeCargo(Item item) {
        if (cargo.size() > 0) {
            cargo.remove(cargo.indexOf(item));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get the ship's fuel
     * @return Ship's fuel
     */
    public double getFuel() {
        return fuel;
    }

    /**
     * Set the ship's fuel
     * @param fuel Fuel to set the ship's fuel
     */
    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    /**
     * Get ship's cargo
     * @return Ship's cargo
     */
    public ArrayList<Item> getCargo() {
        return cargo;
    }

    /**
     * Get ship's health
     * @return Ship's health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Set the ship's health
     * @param health Ship's health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Get ship's type
     * @return The ship's type
     */
    public String getType() {
        return type;
    }

}
