package models.NPC;


import javax.swing.*;

public interface NPC {

    /**
     * NPC's interaction method
     */
    public void interact();

    /**
     * Gets the name of NPC
     * @return Name of NPC
     */
    public String getName();

    /**
     * Gets the icon of NPC
     * @return Icon of NPC
     */
    public ImageIcon getImage();

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
