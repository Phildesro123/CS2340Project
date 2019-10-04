package models;
import models.enums.TechLevel;
import java.util.Random;
import java.util.ArrayList;

public class Universe {
    private ArrayList<Region> regions = new ArrayList<>();
    private String names[];
    private static Universe uni;

    private Universe(String names[]) {
        if (uni != null){
            throw new RuntimeException("Use getInstance()");
        }
        // initialization logic
        this.names = names;
    }

    public static Universe getInstance(String[] names) {
        if (uni == null) {
            uni = new Universe(names);
            uni.doStuff(names);
        }
        return uni;
    }
    public Region getRegion(int n) {
        return regions.get(n);
    }
    public int uniSize() {
        return regions.size();
    }

    public void doStuff(String names[]) {
        for (int i = 0; i < 10; i++) {
            Region start = new Region(0,0,"null", TechLevel.PREAG);
            regions.add(start);
        }
        Random gen = new Random();
        TechLevel tech[] = TechLevel.values();
        for (int i = 0; i < regions.size(); i++) {
            int x = gen.nextInt(201);
            int y = gen.nextInt(201);
            int nameInt = gen.nextInt(names.length);
            int techInt = gen.nextInt(tech.length);
            int j = 0;
            boolean tester = true;
            while (tester) {
                if (Math.abs(x - regions.get(j).getX()) <= 5) {
                    x = gen.nextInt(201);
                    j = 0;
                } else if (Math.abs(y - regions.get(j).getY()) <= 5) {
                    y = gen.nextInt(201);
                    j = 0;
                } else if (names[nameInt].equals(regions.get(j).getName())) {
                    nameInt = gen.nextInt(names.length);
                    j = 0;
                } else {
                    j++;
                    if (j < i) {
                        tester = true;
                    } else {
                        tester = false;
                    }
                }
            }
            Region temp = new Region(x,y,names[nameInt], tech[techInt]);
            regions.set(i, temp);
        }
    }
}
