package models;

import models.enums.ShipType;

import java.util.ArrayList;

public class Ship {
    private double fuel;
    private ArrayList<Item> cargo;
    private int health;
    private String type;
    private int maxCargo;

    public Ship(ShipType shipType) {
        fuel = shipType.shipFuel();
        cargo = new ArrayList<>();
        health = shipType.shipHealth();
        type = shipType.shipName();
        maxCargo = shipType.cargoSpace();
    }

    public boolean addCargo(Item item) {
        if (cargo.size() + 1 > maxCargo) {
            return false;
        } else {
            cargo.add(item);
            return true;
        }
    }

    public boolean removeCargo(Item item) {
        if (cargo.size() > 0) {
            cargo.remove(cargo.indexOf(item));
            return true;
        } else {
            return false;
        }
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public ArrayList<Item> getCargo() {
        return cargo;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getType() {
        return type;
    }

}
