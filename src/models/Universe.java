package models;
import models.enums.ItemType;
import models.enums.TechLevel;
import java.util.Random;
import java.util.ArrayList;

public class Universe {
    private ArrayList<Region> regions = new ArrayList<>();
    private String[] names;
    private static Universe uni;

    private Universe(String[] names) {
        if (uni != null) {
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
    Region getRegion(int n) {
        return regions.get(n);
    }

    Region[] getRegions() {
        Region[] tmp = new Region[regions.size()];
        int cnt = 0;
        for (Region r : regions) {
            tmp[cnt] = r;
            cnt++;
        }
        return tmp;
    }

    public int uniSize() {
        return regions.size();
    }

    private void doStuff(String[] names) {
        for (int i = 0; i < 10; i++) {
            Region start = new Region(0, 0,
                    "null", TechLevel.PREAG);
            regions.add(start);
        }
        Random gen = new Random();
        TechLevel[] tech = TechLevel.values();
        ItemType[] type = ItemType.values();
        for (int i = 0; i < regions.size(); i++) {
            int x = gen.nextInt(201);
            int y = gen.nextInt(201);
            int nameInt = gen.nextInt(names.length);
            int techInt = gen.nextInt(tech.length);
            int itemInt = gen.nextInt(type.length);
            Item[] tempItems = new Item[10];
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
                    tester = j < i;
                }
            }

            //This is to randomly assign a price modifier to the item
            for (int f = 0; f < 10; f++) {
                itemInt = gen.nextInt(type.length);
            }
            Region temp = new Region(x, y, names[nameInt], tech[techInt]);
            regions.set(i, temp);
        }
    }
}
