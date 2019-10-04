package models;

public class Game {
    private int difficulty; //16 = Easy, 12 = Medium, 8 = Hard
    private Player player;

    /**
     * Creates a game object
     *
     * @param difficulty Difficulty of game
     * @param name       Name of player
     */
    public Game(int difficulty, String name) {
        if (difficulty == 16) {
            player = new Player(name, 16, 1000.0);
        } else if (difficulty == 12) {
            player = new Player(name, 12, 500.0);
        } else if (difficulty == 8) {
            player = new Player(name, 8, 100.0);
        } else {
            throw new IllegalArgumentException("Invalid difficulty");
        }
        this.difficulty = difficulty;
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

}