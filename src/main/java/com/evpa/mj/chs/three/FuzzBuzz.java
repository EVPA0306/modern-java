package com.evpa.mj.chs.three;

public class FuzzBuzz {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i + " FuzzBuzz");
            } else if (i % 3 == 0) {
                System.out.println(i + " Fuzz");
            } else if (i % 5 == 0) {
                System.out.println(i + " Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
