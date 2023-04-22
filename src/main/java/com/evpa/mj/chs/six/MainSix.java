package com.evpa.mj.chs.six;

import com.evpa.mj.chs.four.Dish;
import com.evpa.mj.chs.four.DishType;

import static com.evpa.mj.chs.Data.*;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class MainSix {

    public static void main(String[] args) {

        List<Dish> emptyMenu = new ArrayList<>();

        long howManyDishes = DISH_LIST.stream()
                .collect(counting());
        System.out.println(howManyDishes);
        //
        Optional<Dish> mostCalorieDish = DISH_LIST.stream()
                .collect(maxBy(Comparator.comparing(Dish::getCalories)));
        System.out.println(mostCalorieDish.get());

        Optional<Dish> mostCalorieDishEmpty = emptyMenu.stream()
                .collect(maxBy(Comparator.comparing(Dish::getCalories)));
        System.out.println(mostCalorieDishEmpty);

        LongSummaryStatistics intSummaryStatistics = DISH_LIST.stream()
                .collect(summarizingLong(Dish::getCalories));
        System.out.println(intSummaryStatistics);
        //
        String shortMenu = DISH_LIST.stream()
                .map(Dish::getName)
                .collect(joining(", "));
        System.out.println(shortMenu);
        //
        int totalCal = DISH_LIST.stream()
                .collect(reducing(0,Dish::getCalories, (i,j) -> i + j));
        System.out.println(totalCal);

        //
        Map<DishType,List<Dish>> dishTypeListMap = DISH_LIST.stream()
                .collect(groupingBy(Dish::getType));
        System.out.println(dishTypeListMap);
        //
        Map<Boolean, List<Dish>> partitionedMenu = DISH_LIST.stream()
                .collect(partitioningBy(Dish::isVegeterian));
        System.out.println(partitionedMenu);

        System.out.println((int)Math.sqrt(6));

        IntStream.range(2,151)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        //
        List<Dish> dishes = DISH_LIST.stream()
                .collect(new ToListCollector<>());
        System.out.println(dishes);

        var menuStatistics = DISH_LIST.stream()
                .collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);
    }


    public <T> Supplier<List<T>> supplier() {
        //return () -> new ArrayList<>(); is same as
        return ArrayList::new;
    }
}
