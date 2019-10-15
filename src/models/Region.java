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

    public Region(int x, int y, String name, TechLevel techLevel, Market m) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.techLevel = techLevel;
        this.color = new Color((int) (Math.random() * 200),
                (int) (Math.random() * 200),
                (int) (Math.random() * 200));
        this.inflationB = calculateInflationB(techLevel);
        this.inflationS = calculateInflationS(techLevel);
        this.market = m;
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

    public Market getMarket() {
        return market;
    }

    public Color getColor() {
        return color;
    }

    public TechLevel getTechLevel() {
        return techLevel;
    }

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
        default :
            throw new IllegalStateException("Unexpected input: " + l);
        }
    }

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
            default :
                throw new IllegalStateException("Unexpected input: " + l);
        }
    }


}
