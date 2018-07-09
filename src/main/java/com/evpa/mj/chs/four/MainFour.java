package com.evpa.mj.chs.four;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class MainFour {

    public static void main(String[] args) {
        List<Dish> dishesList = Arrays.asList(new Dish("Pork", false, 800, DishType.MEAT)
                , new Dish("Mac and Cheese", false, 620, DishType.OTHER)
                , new Dish("Buffalo Wings", false, 743, DishType.POULTRY)
                , new Dish("Salmon",false, 450, DishType.FISH)
                , new Dish("Pizza", true,   550, DishType.OTHER)
                , new Dish("White Rice", true, 350, DishType.OTHER)
        );

        List<String> lowCaloricList = dishesList
                .stream()
                .filter(d -> {
                    System.out.println("filtering..." + d.getCalories());
                    return d.getCalories() < 600;})
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(dish -> {
                    System.out.println("Mapping..." + dish.getName());
                    return dish.getName();
                })
                .limit(10)
                .collect(toList());

        dishesList.stream()
                .forEach(System.out::println);

        System.out.println(lowCaloricList);

        Path path = Paths.get("/usr/share/dict/words");

    }
}
