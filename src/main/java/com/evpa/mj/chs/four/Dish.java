package com.evpa.mj.chs.four;

public class Dish {

    private final String name;
    private final boolean vegeterian;
    private final Integer calories;
    private final DishType type;

    public Dish(String name, boolean vegeterian, Integer calories, DishType type) {
        this.name = name;
        this.vegeterian = vegeterian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Integer getCalories() {
        return calories;
    }

    public DishType getType() {
        return type;
    }

    public boolean isVegeterian() {
        return vegeterian;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }
}
