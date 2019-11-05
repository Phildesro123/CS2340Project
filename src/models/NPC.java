package models;

import javax.swing.*;

public abstract class NPC {
    ImageIcon icon;
    String name;

    /**
     * Creates a new NPC object
     * @param icon Icon image
     * @param name Name of NPC
     */
    public NPC(ImageIcon icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    //Any other abstract methods?

}
