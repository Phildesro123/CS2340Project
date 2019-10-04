package models;
import models.enums.TechLevel;
import models.Region;
import java.util.Random;
import java.util.ArrayList;

public class Universe {
    //public Universe {
    private ArrayList<Region> regions = new ArrayList<>();
    private static Universe uni;

    private Universe() {
        if (uni != null){
            throw new RuntimeException("Use getInstance()");
        }
        // initialization logic

    }

    public static Universe getInstance() {
        if (uni == null) {
            uni = new Universe();
            uni.doStuff();
        }
        return uni;
    }
    public Region getRegion(int n) {
        return regions.get(n);
    }
    public int uniSize() {
        return regions.size();
    }
    public void doStuff() {

        for (int i = 0; i < 10; i++) {
            Region start = new Region(0,0,"null", TechLevel.PREAG);
            regions.add(start);
        }
        Random gen = new Random();
        ArrayList<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");
        names.add("f");
        names.add("g");
        names.add("h");
        names.add("i");
        names.add("j");
        names.add("k");
        names.add("l");
        names.add("m");
        names.add("n");
        TechLevel tech[] = TechLevel.values();
        for (int i = 0; i < regions.size(); i++) {
            int x = gen.nextInt(51);
            int y = gen.nextInt(51);
            int nameInt = gen.nextInt(names.size());
            int techInt = gen.nextInt(tech.length);
            int j = 0;
            boolean tester = true;
            while (tester) {
                if (Math.abs(x - regions.get(j).getX()) <= 5) {
                    x = gen.nextInt(101);
                    j = 0;
                } else if (Math.abs(y - regions.get(j).getY()) <= 5) {
                    y = gen.nextInt(101);
                    j = 0;
                } else if (names.get(nameInt).equals(regions.get(j).getName())) {
                    nameInt = gen.nextInt(names.size());
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
            Region temp = new Region(x,y,names.get(nameInt), tech[techInt]);
            regions.set(i, temp);
        }
    }
}
