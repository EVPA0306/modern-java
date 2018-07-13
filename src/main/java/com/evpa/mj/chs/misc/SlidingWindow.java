package com.evpa.mj.chs.misc;

import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {

    public static void main(String[] args) {
        String bad = "pwwkew"; //3
        System.out.println(lengthOfLongestSubstr(bad));
    }

    private static int lengthOfLongestSubstr(String s) {

        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
