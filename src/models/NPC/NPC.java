package models.NPC;


import javax.swing.*;

public abstract class NPC {
    private String name;
    private ImageIcon image;

    /**
     * NPC's interaction method
     */
    public void interact() {
        System.out.println("Yikes");
    }

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
    public ImageIcon getImage() {
        return image;
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
    public void setImage(ImageIcon image) {
        this.image = image;
    }

}
