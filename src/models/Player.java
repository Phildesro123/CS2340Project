package models;

public class Player {
    private String name;
    private int skillPoints;
    private double credits;
    //[Pilot, Fighter, Merchant, Engineer]
    private int[] skillSet;
    private Region currentRegion;
    /**
     * Creates a player object
     * @param name Name of player
     * @param skillPoints Number of skill points
     * @param credits Number of credits
     */
    public Player(String name, int skillPoints, double credits) {
        this.name = name;
        this.skillPoints = skillPoints;
        skillSet = new int[]{0, 0, 0, 0};
        this.credits = credits;
    }

    /**
     * Change the name of players
     * @param name Name to change player to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the player's name
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the number of credits
     * @return Number of credits the player has
     */
    public double getCredits() {
        return credits;
    }

    /**
     * Sets the credits
     * @param credits Number of credits
     */
    public void setCredits(double credits) {
        this.credits = credits;
    }

    /**
     * Sets the skill points
     * @param skillPoints The number of skill points
     */
    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    /**
     * Returns skill set of the player
     * @return The skill set of the player
     */
    public int[] getSkillSet() {
        return skillSet;
    }

    /**
     * Returns the number of skill points the player has
     * @return The number of skill points player has
     */
    public int getSkillPoints() {
        return skillPoints;
    }

    /**
     * This is to add skill point to a skill set
     * @param index Index of skill point
     * (0 is pilot, 1 is fighter, 2 is merchant, 3 is engineer)
     */
    public void addToSkillSet(int index) {
        //If player doesn't have enough points don't allow them to change
        if (skillPoints <= 0) {
            return;
        }
        skillSet[index]++;
        skillPoints--;
    }

    /**
     * Remove skill point from a skill in the skill set
     * @param index Index of skill point
     * (0 is pilot, 1 is fighter, 2 is merchant, 3 is engineer)
     */
    public void removeFromSkillSet(int index) {
        /*
        If skill set point is at 0, don't allow the player to take away from it
         */
        if (skillSet[index] <= 0) {
            return;
        }
        skillSet[index]--;
        skillPoints++;
    }

    /**
     * Get player's current region
     * @return Current region
     */
    public Region getCurrentRegion() {
        return currentRegion;
    }

    /**
     * Change the current region
     * @param currentRegion Region to change current region to
     */
    public void setCurrentRegion(Region currentRegion) {
        this.currentRegion = currentRegion;
    }

    /**
     * Distance from current region to another region
     * @param region Other region
     * @return Distance from current region to other region
     */
    public double distance(Region region) {
        double x1 = currentRegion.getX();
        double x2 = region.getX();
        double y1 = currentRegion.getY();
        double y2 = region.getY();
        return Math.sqrt(Math.pow((x2 - x1), 2)
                + Math.pow((y2 - y1), 2));
    }
}
