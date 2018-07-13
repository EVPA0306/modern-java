package com.evpa.mj.chs.six;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println("isPrime simple:" + isPrimeSimple(113));
        System.out.println("isPrime:" + isPrime(113));
        System.out.println("Prime numbers: " + partitionPrimes(113).get(true));
        System.out.println(isPrimeExt(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37),114));
    }

    private static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2,n)
                .boxed()
                .collect(partitioningBy(candidate -> isPrime(candidate)));
    }

    private static boolean isPrimeSimple(int candidate) {
        return IntStream.range(2,candidate)
                .noneMatch(i -> candidate % i == 0);
    }

    private static boolean isPrime(int candidate) {
        int candidateRoot = (int)Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2,candidateRoot)
                .noneMatch(i -> candidate % i == 0)
                ;
    }

    private static boolean isPrimeExt(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return takeWhile(primes,i -> i <= candidateRoot)
                .stream()
                .noneMatch(p -> candidate % p == 0);
    }

    private static <A> List<A> takeWhile(List<A> list, Predicate<A> predicate) {
        int i = 0;
        for (A a : list) {
            if (predicate.test(a)) {
                return list.subList(0,i);
            }
            i++;
        }
        return list;
    }
}
