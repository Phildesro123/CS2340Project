package models.NPC;


import models.Player;

public abstract class NPC {

    private String name;
    private ImageIcon icon;
    private Player player;

    public NPC(String name, String icon, Player player) {
        this.name = name;
        this.icon = (ImageIcon) icon; //this is where file IO nonsense would go
        this.player = player;
    }

    /**
     * Shows the options that the player has to interact with the NPC
     */
    public abstract void interact();

    /**
     * Gets the name of NPC
     * @return Name of NPC
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the icon of NPC
     * @return Icon of NPC
     */
    public Icon getIcon() {
        return icon;
    }
    /**
     * Sets name of the NPC
     * @param name Name of NPC
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the icon of NPC
     * @param icon Icon of NPC
     */
    public void setImage(String icon) {
        this.icon = icon;
    }

}

