package screens;

import models.Encounter;
import models.Game;

import javax.swing.*;
import java.util.Random;

public class EncounterDisplay {
    Random gen = new Random();
    private Encounter encounter;
    protected JFrame f = new JFrame("Display Page");
    protected JPanel disp = new JPanel();
    public EncounterDisplay(Encounter encounter, Game game) {
        this.encounter = encounter;
        String[] options = {"Buy" , "Run"};
        JOptionPane.showOptionDialog(null, "Click run", "Encounter", JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }
}