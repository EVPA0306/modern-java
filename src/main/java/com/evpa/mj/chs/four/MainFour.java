package com.evpa.mj.chs.four;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

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
                .skip(1)
                .collect(toList());

        //dishesList.stream()
        //        .forEach(System.out::println);

        //dishesList.stream()
        //        .filter(Dish::isVegeterian)
        //        .forEach(System.out::println);

        System.out.println(lowCaloricList);

        List<String> words = Arrays.asList("Java", "world", "is", "awesome");

        List<Integer> counts = words.stream()
                .map(String::length)
                .collect(toList());

        System.out.println(counts);

        String[] arrayOfWords = {"Hello","World"};
        Stream<String> stringStream = Arrays.stream(arrayOfWords);

        System.out.println(words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList()));

        List<Integer> sqet = Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .map(d -> d*d)
                .collect(toList());

        System.out.println(sqet);

        Integer summ = Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .reduce(10, (a,b) -> a+b);
        System.out.println("Summ: " + summ);


        Optional<Integer> max = Arrays.asList(6,78,8)
                .stream()
                .reduce((a,b) -> Integer.max(a,b));

        System.out.println("Max: " + max.get());

        List<Integer> pairOne = Arrays.asList(1,2,3);
        List<Integer> pairTwo = Arrays.asList(3,4);

        List<int[]> result = pairOne.stream()
                .flatMap(i -> pairTwo.stream()
                        .filter(j -> (i+j) % 3 ==0)
                .map(j -> new int[]{i,j})
                )
                .collect(toList());

        result.stream()
                .forEach(arr -> {
                    System.out.println(Arrays.toString(arr));
                });


        Optional<Dish> vegan = dishesList.stream()
                .filter(Dish::isVegeterian)
                .findAny();

        System.out.println(vegan.get());

        System.out.println(dishesList.stream()
                .map(dish -> 1)
                .reduce(0,(a,b) -> a+b));

        /*Path path = Paths.get("/usr/share/dict/words");

        try (Stream<String> lines = Files.lines(path)) {
            lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .forEach(System.out::println);
        } catch (IOException ioe) {

        }*/

    }
}
