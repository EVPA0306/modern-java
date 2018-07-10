package com.evpa.mj.chs.four;

import java.util.stream.Stream;

public class PythagoreanTriple {
    public static void main(String[] args) {

        int[] tripletOne = new int[] {3,4,5};

        Stream.iterate(1, n -> n + n)
                .limit(10)
                .forEach(System.out::println);

        Stream.iterate(new int[]{0,1}, t -> new int[]{ t[1], t[0] + t[1] })
                .limit(10)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));

        Stream.iterate(new int[]{1,2}, t -> new int[]{ t[1], t[0] + t[1] })
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);
    }
}
