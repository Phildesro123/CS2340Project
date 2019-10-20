package models.enums;

public enum ShipType {
    SEIROSCO,
    EMPIREWCORP,
    BLACKEAGLE,
    KINGDOMCCO,
    BLUELION,
    ALLIANCEDCO,
    GOLDENDEER;

    /**
     * Gets the the health of a shit
     * @return Ship's health
     */
    public int shipHealth() {
        switch (this) {
        case BLUELION: //More Damage
            return 550;
        case SEIROSCO: //Good stats all around
            return 700;
        case BLACKEAGLE: //Middle between Deer & Lion
            return 400;
        case GOLDENDEER: //Speedy Merchant class
            return 350;
        case KINGDOMCCO: // Good damage and combat
            return 800;
        case ALLIANCEDCO: // Speedy Merchant class
            return 750;
        case EMPIREWCORP: // More well rounded than Seiros
            return 850;
        default:
            throw new IllegalStateException("Unexpected value: " + this);
        }
    }

    /**
     * Get ship's name
     * @return Ship's name
     */
    public String shipName() {
        switch (this) {
        case BLUELION:
            return "Blue Lion: Luin";
        case SEIROSCO:
            return "Seiros Company";
        case BLACKEAGLE:
            return "Black Eagle: Aymr";
        case GOLDENDEER:
            return "Golden Deer: Blutgang";
        case KINGDOMCCO:
            return "Kingdom Calvary Company MKV";
        case ALLIANCEDCO:
            return "Alliance Duelist Company MKV";
        case EMPIREWCORP:
            return "Empire Wyvern Company MKV";
        default :
            throw new IllegalStateException("Unexpected value: " + this);
        }
    }

    /**
     * Gets cargo space of ship
     * @return Cargo space of ship
     */
    public int cargoSpace() {
        switch (this) {
        case BLUELION:
            return 3;
        case SEIROSCO:
            return 7;
        case BLACKEAGLE:
            return 4;
        case GOLDENDEER:
            return 6;
        case KINGDOMCCO:
            return 8;
        case ALLIANCEDCO:
            return 15;
        case EMPIREWCORP:
            return 10;
        default :
            throw new IllegalStateException("Unexpected value: " + this);
        }
    }

    /**
     * Get the ship's fuel
     * @return Ship's fuel
     */
    public int shipFuel() {
        switch (this) {
        case BLUELION:
            return 2000;
        case SEIROSCO:
            return 300;
        case BLACKEAGLE:
            return 2750;
        case GOLDENDEER:
            return 3000;
        case KINGDOMCCO:
            return 2500;
        case ALLIANCEDCO:
            return 4500;
        case EMPIREWCORP:
            return 5000;
        default:
            throw new IllegalStateException("Unexpected value: " + this);
        }
    }
}
