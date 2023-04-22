package com.evpa.mj.chs.seven;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class SimpleWordCount {

    public static void main(String[] args) {
        var map = "SimpleWordCount".chars()
                .mapToObj(w -> (char) w)
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                        .entrySet().stream()
                        .max(Comparator.comparingLong(Map.Entry::getValue))
                                .map(entry -> "This word " + entry.getKey() + " has max occurrence " + entry.getValue())
                .orElse("Not found");
        System.out.println(map);
    }
}
