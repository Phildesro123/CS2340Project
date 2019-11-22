package models;

public class Karma {
    private int karma = 0;
    public void addKarma() {
        karma++;
    }
    public void remKarma() {
        karma--;
    }
    public int getKarma() {
        return karma;
    }
}
