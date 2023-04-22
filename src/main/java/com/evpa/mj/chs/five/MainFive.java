package com.evpa.mj.chs.five;

import static java.lang.System.out;

import com.evpa.mj.chs.Data;
import com.evpa.mj.chs.four.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainFive {

    public static void main(String[] args) {
        var lessThan500 = Data.DISH_LIST.stream()
                .filter(dish -> dish.getCalories() < 500)
                .collect(Collectors.toList());

        out.println(lessThan500);

        var moreThan500 = Data.DISH_LIST.stream()
                .takeWhile(dish -> dish.getCalories() > 500)
                .collect(Collectors.toList());

        out.println(moreThan500);

        var words = List.of("Hello","World");

        var dstWords = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        out.println(dstWords);

        var ints = List.of(1, 2, 3, 4, 5);

        out.println(ints.stream()
                .map(i -> i * i)
                .collect(Collectors.toList()));

        /*
        2. Given two lists of numbers, how would you return all pairs of numbers?
        For example, given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)].
        For simplicity, you can represent a pair as an array with two elements.
         */

        var listOne = List.of(1, 2, 3);
        var listTwo = List.of(3, 4);

        var listThree = listOne.stream()
                .flatMap(i -> listTwo.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> List.of(i,j)))
                .collect(Collectors.toList());

        out.println("listThree::" + listThree);

        var intsToReduce = List.of(1,2,3,4,5,6);

        var intResult = intsToReduce.stream()
                .reduce(0, Integer::sum);
        out.println(intResult);

        var maxCal = Data.DISH_LIST.stream()
                .map(Dish::getCalories)
                .reduce(Integer::max)
                .stream().findFirst()
                .orElse(0);

        out.println(maxCal);

        var totalCal = Data.DISH_LIST.stream()
                .map(Dish::getCalories)
                .reduce(Integer::sum)
                        .stream().findFirst()
                .orElse(0);

        out.println(totalCal);

    }

}
