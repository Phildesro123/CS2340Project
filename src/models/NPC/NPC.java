package models.NPC;


import javax.swing.*;

public abstract class NPC {

    private String name;
    private ImageIcon icon;

    public NPC(String name, ImageIcon icon) {
        this.name = name;
        this.icon = icon;
    }

    /**
     * NPC's interaction method
     */
    public abstract void interact();

    /**
     * Gets the name of NPC
     * @return Name of NPC
     */
    public abstract String getName();

    /**
     * Gets the icon of NPC
     * @return Icon of NPC
     */
    public abstract ImageIcon getImage();

    /**
     * Sets name of the NPC
     * @param name Name of NPC
     */
    public void setName(String name);

    /**
     * Sets the icon of NPC
     * @param icon Icon of NPC
     */
    public void setImage(ImageIcon icon);

}
