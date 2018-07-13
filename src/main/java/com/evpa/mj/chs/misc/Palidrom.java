package com.evpa.mj.chs.misc;

public class Palidrom {
    public static void main(String[] args) {
        String s = "baba";
        System.out.println(isPalindrome(s));
        /*String longest = "";
        for (int i = 0; i <= s.length(); i++) {
            if (isPalindrome(s.substring(0,i)))
                longest = s.substring(0,i);
        }
        System.out.println(longest);*/
    }

    public static boolean isPalindrome(String s) {
        boolean res = false;
        int j = s.length()-1;
        for (int i = 0;  i < s.length(); i++, j--) {
            if (s.charAt(i) == s.charAt(j)) {
                res = true;
            } else {
                return false;
            }

        }
        return res;
    }
}
