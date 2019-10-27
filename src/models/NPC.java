package models;

import javax.swing.*;

public abstract class NPC {
    private ImageIcon icon;
    private String name;

    /**
     * Creates a new NPC object
     * @param icon Icon image
     * @param name Name of NPC
     */
    public NPC(ImageIcon icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    /**
     * Gets the icon of NPC
     * @return Icon image
     */
    public ImageIcon getIcon() {
        return icon;
    }

    /**
     * Sets the icon image of NPC
     * @param icon Icon image
     */
    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    /**
     * Gets the name of NPC
     * @return name of NPC
     */
    public String getName() {
        return name;
    }

    /**
     * Set's the name of NPC
     * @param name Name of NPC
     */
    public void setName(String name) {
        this.name = name;
    }

    //Any other abstract methods?


}
