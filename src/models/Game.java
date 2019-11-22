package models;
import models.enums.Difficulty;

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
     * @param name Name of player
     */
    public Game(String difficulty, String name) {
        this.difficulty = Difficulty.valueOf(difficulty);
        player = new Player(name, this.difficulty.skillPoints(),
                this.difficulty.credits());
        regionNames = new String[] {"Brigid", "Duscur", "Almyra", "Fodlan",
            "Gronder", "Adrestia", "Faerghus",
            "Leicester", "Dagda", "Shambhala", "Nekrotafeyo"};
    }
    /**
     * Returns the current player
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Changes the value of player
     * @param player Player to replace player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Gets the difficulty of the game
     * @return Difficulty of the game
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     * Gets the list of regions in the game
     * @return Region in the game
     */
    public Region[] getRegions() {
        return universe.getRegions();
    }

    /**
     * Creates the universe based on region names
     * Also sets the current region to a random region
     */
    public void startGame() {
        universe = Universe.getInstance(regionNames);
        player.setCurrentRegion(universe.getRegion(0));
    }


}