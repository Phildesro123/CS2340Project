package models;

import models.enums.TechLevel;

public class Region {

    private int x;
    private int y;
    private String name;
    private TechLevel techLevel;

    public Region(int x, int y, String name, TechLevel techLevel) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.techLevel = techLevel;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TechLevel getTechLevel() {
        return techLevel;
    }


}
