package models;

public class Game {
    //private int difficulty; //16 = Easy, 12 = Medium, 8 = Hard
    private Difficulty difficulty;
    private Player player;
    private String[] regionNames;
    private static Universe universe;

    /**
     * Creates a game object
     *
     * @param difficulty Difficulty of game
     * @param name       Name of player
     */
    public Game(String difficulty, String name) {
        /*if (difficulty == 16) {
            player = new Player(name, 16, 1000.0);
        } else if (difficulty == 12) {
            player = new Player(name, 12, 500.0);
        } else if (difficulty == 8) {
            player = new Player(name, 8, 100.0);
        } else {
            throw new IllegalArgumentException("Invalid difficulty");
        }*/
        this.difficulty = Difficulty.valueOf(difficulty);
        player = new Player(name, this.difficulty.skillPoints(), this.difficulty.credits());
        regionNames = new String[] {"Brigid", "Duscur", "Almyra", "Fodlan", "Gronder", "Adrestia", "Faerghus", "Leicester", "Dagda", "Shambhala"};
    }
    /**
     * Returns the current player
     *
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Changes the value of player
     *
     * @param player Player to replace player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Gets the difficulty of the game
     *
     * @return Difficulty of the game
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Gets the region names in the game
     *
     * @return Region names in the game
     */
    public String[] getRegionNames() {
    	return regionNames;
    }

    /**
     * Creates the universe based on region names
     */
    public void startGame() {
    	if (universe == NULL) {
    		universe = new Universe(regionNames);
    	}
    }


}