package models.NPC;



public abstract class NPC {

    private String name;
    private String icon;
    private Player player;

    public NPC(String name, String icon, Player player) {
        this.name = name;
        this.icon = icon;
        this.player = player;
    }

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
    public String getIcon() {
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

