package models;

import models.enums.TechLevel;

import java.awt.Color;

public class Region {

    private int x;
    private int y;
    private String name;
    private TechLevel techLevel;
    private Color color;
    private double inflationS;
    private double inflationB;
    private Market market;

    /**
     * Creates a new region
     *
     * @param x         X coordinate
     * @param y         Y Coordinate
     * @param name      Name of region
     * @param techLevel Techlevel of region
     */
    public Region(int x, int y, String name, TechLevel techLevel) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.techLevel = techLevel;
        this.color = new Color((int) (Math.random() * 200),
                (int) (Math.random() * 200),
                (int) (Math.random() * 200));
        this.inflationB = calculateInflationB(techLevel);
        this.inflationS = calculateInflationS(techLevel);
        this.market = techLevel.getMarket();
    }


    /**
     * Gets the name of a region
     *
     * @return Name of region
     */
    public String getName() {
        return name;
    }

    /**
     * Get x coordinate of region
     *
     * @return X coord. of region
     */
    public int getX() {
        return x;
    }

    /**
     * Get y coordinate of region
     *
     * @return Y coord. of region
     */
    public int getY() {
        return y;
    }

    /**
     * Get the market of the region
     *
     * @return Market of region
     */
    public Market getMarket() {
        return market;
    }

    public Color getColor() {
        return color;
    }

    /**
     * Get the techlevel of region
     *
     * @return Techlevel of region
     */
    public TechLevel getTechLevel() {
        return techLevel;
    }

    /**
     * Calculates the modifier of prices for selling based on techlevel
     *
     * @param l Techlevel of region
     * @return Price modifier for selling prices of that region
     */
    private double calculateInflationS(TechLevel l) {
        switch (l) {
            case PREAG:
                return 2;
            case MODERN:
                return 1;
            case MEDIEVAL:
                return 1.5;
            case FUTURISTIC:
                return 0.9;
            case INDUSTRIAL:
                return 1;
            case AGRICULTURE:
                return 1.8;
            case RENAISSANCE:
                return 1;
            default:
                throw new IllegalStateException("Unexpected input: " + l);
        }
    }

    /**
     * Calculates buying price modifier for region based on techlevel
     *
     * @param l Region's techlevel
     * @return Price modifier for buying prices of that region
     */
    private double calculateInflationB(TechLevel l) {
        switch (l) {
            case PREAG:
                return 0.4;
            case MODERN:
                return 1.2;
            case MEDIEVAL:
                return 0.7;
            case FUTURISTIC:
                return 1.4;
            case INDUSTRIAL:
                return 1.1;
            case AGRICULTURE:
                return 0.5;
            case RENAISSANCE:
                return 0.9;
            default:
                throw new IllegalStateException("Unexpected input: " + l);
        }
    }

    /**
     * Get price modifier of region
     *
     * @return Selling price modifier of region
     */
    public double getInflationS() {
        return inflationS;
    }

    /**
     * Get buying price modifier of region
     *
     * @return Buying price modifier of region
     */
    public double getInflationB() {
        return inflationB;
    }

}
