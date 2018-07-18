package com.evpa.mj.chs.seventeen;

import java.util.Random;

public class TempInfo {
    public static final Random random = new Random();

    private final String town;
    private final int temperature;

    public TempInfo(String town, int temperature) {
        this.town = town;
        this.temperature = temperature;
    }

    public static TempInfo fetch(final String town) {
        if (random.nextInt(10) == 0)
            throw new RuntimeException("Error!");
            //System.err.println("Error!");
        return new TempInfo(town,random.nextInt(100));
    }

    public String getTown() {
        return town;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "TempInfo{" +
                "town='" + town + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
