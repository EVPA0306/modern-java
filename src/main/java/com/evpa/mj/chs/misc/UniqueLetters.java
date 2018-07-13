package com.evpa.mj.chs.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UniqueLetters {
    public static void main(String[] args) {

        //String bad = "dvdf"; //3
        //String bad = "abcabcbb";//3
        String bad = "pwwkew";//3



        char[] chars = bad.toCharArray();

        List<Character> characterList = new ArrayList<>();

        for (char ch: chars) {
            characterList.add(ch);
        }

        System.out.println(characterList);

        System.out.println(characterList.stream()
                .distinct()
                .collect(Collectors.toList()));

    }
}
