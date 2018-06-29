package com.evpa.mj.chs.one;

public class Apple {

    private AppleColor color;
    private int weight;

    public AppleColor getColor() {
        return color;
    }

    public void setColor(AppleColor color) {
        this.color = color;
    }

    public Apple withColor(AppleColor color) {
        this.color = color;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public Apple withWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color=" + color +
                '}';
    }
}
