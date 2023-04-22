package com.evpa.mj.chs.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.evpa.mj.chs.one.AppleColor.GREEN;
import static com.evpa.mj.chs.one.AppleColor.PINK;
import static com.evpa.mj.chs.one.AppleColor.RED;
import static java.util.stream.Collectors.toList;

public class MainOne {
    public static void main(String[] args) {

        Function<Apple,Boolean> appleBooleanFunction =
                apple -> apple.getColor() == AppleColor.valueOf(apple.getColor().name());

        List<Apple> inventory = Arrays.asList(new Apple().withColor(AppleColor.GREEN)
                ,new Apple().withColor(AppleColor.RED), new Apple().withColor(AppleColor.PINK));

        System.out.println(filterApples(inventory));
        System.out.println(filterApples(inventory, a -> RED == a.getColor()));
        System.out.println(inventory.parallelStream()
                .filter(apple -> PINK == apple.getColor())
                .collect(toList()));
    }

    public static List<Apple> filterApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (GREEN == apple.getColor())
                result.add(apple);
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
