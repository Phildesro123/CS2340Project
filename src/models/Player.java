package models;

public class Player {
    private String name;
    private int skillPoints;
    private double credits;
    //[Pilot, Fighter, Merchant, Engineer]
    private int[] skillSet;

    /**
     * Creates a player object
     * @param name The player's name
     * @param skillPoints The starting skill points for player
     */
    public Player(String name, int skillPoints) {
        this.name = name;
        this.skillPoints = skillPoints;
        skillSet = new int[]{0,0,0,0};
        credits = 0.0;
    }

    /**
     * Return the player's name
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return Number of credits the player has
     */
    public double getCredits() {
        return credits;
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
     * @param index Index of skill point (0 is pilot, 1 is fighter, 2 is merchant, 3 is engineer)
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
     * @param index Index of skill point (0 is pilot, 1 is fighter, 2 is merchant, 3 is engineer)
     */
    public void removeFromSkillSet(int index) {
        //If skill set point is at 0, don't allow the player to take away from it
        if (skillSet[index] <= 0) {
            return;
        }
        skillSet[index]--;
        skillPoints++;
    }
}
