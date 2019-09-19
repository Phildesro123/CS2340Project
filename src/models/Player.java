package models;

public class Player {
    private String name;
    private int skillPoints;
    private double credits;

    //[Pilot, Fighter, Merchant, Engineer]
    private int[] skillSet;

    public Player(String name, int skillPoints) {
        this.name = name;
        this.skillPoints = skillPoints;
        skillSet = new int[]{0,0,0,0};
        credits = 0.0;
    }

    public String getName() {
        return name;
    }

    public double getCredits() {
        return credits;
    }

    public int[] getSkillSet() {
        return skillSet;
    }

    public int getSkillPoints() {
        return skillPoints;
    }
}
