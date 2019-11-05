package models;
import models.enums.Difficulty;
import models.enums.ShipType;

public class Game {
    //private int difficulty; //16 = Easy, 12 = Medium, 8 = Hard
    private Difficulty difficulty;
    private Player player;
    private String[] regionNames;
    private static Universe universe;
    private Travel travel;
    private Ship ship = new Ship(ShipType.SEIROSCO);
    private Encounter encounter;
    /**
     * Creates a game object
     *
     * @param difficulty Difficulty of game
     * @param name       Name of player
     */
    public Game(String difficulty, String name) {
        this.difficulty = Difficulty.valueOf(difficulty);
        player = new Player(name, this.difficulty.skillPoints(),
                this.difficulty.credits());
        regionNames = new String[] {"Brigid", "Duscur", "Almyra", "Fodlan",
            "Gronder", "Adrestia", "Faerghus",
            "Leicester", "Dagda", "Shambhala", "Nekrotafeyo"};
        travel = new Travel(ship, this.difficulty.modifier(),
                player.getSkillSet());
        encounter = new Encounter(ship.getCargo(), player.getCredits(),
                this.difficulty.modifier());
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
    public Difficulty getDifficulty() {
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

    public Universe getUniverse() {
        return universe;
    }

    public Travel getTravel() {
        return travel;
    }

    public Ship getShip() {
        return ship;
    }
    public Encounter getEncounter() {
        return encounter;
    }
    /**
     * Creates the universe based on region names
     * Also sets the current region to a random region
     */
    public void startGame() {
        universe = universe.getInstance(regionNames);
        player.setCurrentRegion(universe.getRegion(0));
    }


}