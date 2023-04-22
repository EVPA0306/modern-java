package com.evpa.mj.chs.misc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Misc {

    public static void main(String[] args) {
        System.out.println(search(List.of("ab,abcd")));
        System.out.println(searchOne(List.of("2|2|1|3|1|3")));
        System.out.println("searchThree:: " + searchThree("2|2|1|3|1|3"));
    }

    private static String searchThree(String s) {
        return Arrays.stream(s.split("\\|"))
                .distinct()
                .collect(Collectors.joining("|"));
    }

    private static List<String> searchOne(List<String> strings) {
        return strings.stream()
                .map(str -> str.split("\\|"))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<String> search(List<String> list) {
        return list.stream()
                .map(str -> str.split(","))
                .flatMap(Arrays::stream)
                .filter(str -> 'a' == str.charAt(0))
                .collect(Collectors.toList());
    }
}
