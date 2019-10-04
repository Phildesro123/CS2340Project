package models.enums;

public enum Difficulty {
    EASY, MEDIUM, HARD;

    /**
     * Returns number of skillpoints for each difficulty
     *
     * @return The number of skill points
     */
    public int skillPoints() {
    	switch (this) {
    		case EASY:
    			return 16;
    		case MEDIUM:
    			return 12;
    		case HARD:
    			return 8;
    	}
    }

    /**
     * Returns number of credits for each difficulty
     *
     * @return The number of credits
     */
    public double credits() {
    	switch (this) {
    		case EASY:
    			return 1000.0;
    		case MEDIUM:
    			return 500.0;
    		case HARD:
    			return 100.0;
    	}
    }
}