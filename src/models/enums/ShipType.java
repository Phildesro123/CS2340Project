package models.enums;

public enum ShipType {
    SEIROSCO("Immaculate Cruiser", 700, 7, 300, 2, "Produced by the Seiros Company, "
            + "it is a Cruiser that is well rounded."),
    EMPIREWCORP("Wyvern MKV", 850, 10,5000, 3 , "An Imperial Battle Cruiser"
            + " produced by the Empire Wyvern Company. "
            + "Very well rounded and great for long sieges."),
    BLACKEAGLE("Black Eagle: Aymr", 400, 4, 2750, 1, "An Imperial "
            + "Cruiser Designed by the Emperor's special scientist team. Well rounded."),
    KINGDOMCCO("Kingdom Calvary Company MKIII", 800, 8, 2500, 6,
            "A Heavy Weight Battle Cruiser produced by the Kingdom Calvary Company. "
                    + "Designed for battling with other ships and scouting the enemy."),
    BLUELION("Blue Lion: Luin", 550, 3, 2000, 4, "A Kingdom"
            + " Battleship designed by the new Galatea Corporation for the King. "
            + "Good for small scuffles."),
    ALLIANCEDCO("Duelist MKVII", 750, 15, 4500, 2,
            "Merchant Ship designed by the Alliance Duelist Company."),
    GOLDENDEER("Golden Deer: Blutgang", 350, 6, 3000, 1,
            "Merchant Ship designed by the Alliance's chairmen and R&D.");

    private int health;
    private String name;
    private int cargoSpace;
    private int fuel;
    private String description;
    private int damageMod;

    /**
     *
     * @param n Name
     * @param h Health
     * @param c Cargo Space
     * @param f Fuel
     * @param m Damage Modification
     * @param d Description
     */
    ShipType(String n, int h, int c, int f, int m, String d) {
        this.name = n;
        this.health = h;
        this.cargoSpace = c;
        this.fuel = f;
        this.damageMod = m;
        this.description = d;
    }

    /**
     * Gets the the health of a shit
     * @return Ship's health
     */
    public int shipHealth() {
        return health;
    }

    /**
     * Get ship's name
     * @return Ship's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets cargo space of ship
     * @return Cargo space of ship
     */
    public int cargoSpace() {
       return cargoSpace;
    }

    /**
     * Get the ship's fuel
     * @return Ship's fuel
     */
    public int shipFuel() {
       return fuel;
    }

    /**
     * Gets Damage modifier
     * @return damage modifier
     */
    public int getDamageMod() {
        return damageMod;
    }

    /**
     * Gets Description
     * @return description
     */
    public String getDesc() {
        return description;
    }
}
