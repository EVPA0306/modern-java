package com.evpa.mj.chs.misc;

import java.util.*;

class Solution {

    public static void main(String[] args) {

        String bad = "dvdf"; //3

        String good = "pwwkew"; //3
        String anotherGood = "bbbbb"; //1
        String superGood = "abcabcbb";//3

        System.out.println(lengthOfLongestSubstring(superGood));
    }

    public static int lengthOfLongestSubstring(String s) {

        Map<Character,Integer> sub;
        StringBuilder sB;
        List<String> strs = new ArrayList<>();
        int result;

        int pointer = 0;

        while (pointer != s.length()) {

            sub = new LinkedHashMap<>();
            sB = new StringBuilder();

            for (int i = pointer; i < s.length(); i++) {
                Character key = s.charAt(i);
                if (sub.containsKey(key)) {
                    break;
                } else {
                    sB.append(key);
                    sub.put(key, i);
                }
            }
            pointer++;
            strs.add(sB.toString());
        }

        result = strs.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .findFirst()
                .orElse("")
                .length();

        return result;
    }
}