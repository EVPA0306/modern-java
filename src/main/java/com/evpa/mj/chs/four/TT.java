package com.evpa.mj.chs.four;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;

/*
    1. Find all transactions in the year 2011 and sort them by value (small to high).
    2. What are all the unique cities where the traders work?
    3. Find all traders from Cambridge and sort them by name.
    4. Return a string of all traders’ names sorted alphabetically.
    5. Are any traders based in Milan?
    6. Print all transactions’ values from the traders living in Cambridge.
    7. What’s the highest value of all the transactions?
    9. Find the transaction with the smallest value.
 */

public class TT {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> transactions2011 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getAmount))
                .collect(Collectors.toList());
        System.out.println(transactions2011);

        List<String> uniqueCities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueCities);

        List<Trader> tradersFromCambridge = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equalsIgnoreCase(trader.getCity()))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toList());

        System.out.println(tradersFromCambridge);

        String allTraders = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining())
                //.reduce("", (n1,n2) -> n1+n2)
                ;
        System.out.println(allTraders);

        boolean inMilan = transactions.stream()
                .anyMatch(transaction -> "Milan".equalsIgnoreCase(transaction.getTrader().getCity()));
        System.out.println(inMilan);

        transactions.stream()
                .filter(transaction -> "Cambridge".equalsIgnoreCase(transaction.getTrader().getCity()))
                .forEach(t -> System.out.println(t.getAmount()));

        System.out.println(transactions.stream()
                .map(Transaction::getAmount)
                .reduce(Integer::max)
        );

        Optional<Transaction> smallest = transactions.stream()
                .sorted((t1,t2) -> ((Integer)t1.getAmount()).compareTo(t2.getAmount()))
                .findFirst();
        System.out.println(smallest.get());

        Optional<Transaction> smallestTransaction =
                transactions.stream()
                        .reduce((t1, t2) ->
                                t1.getAmount() < t2.getAmount() ? t1 : t2);
        System.out.println(smallestTransaction.get());


        System.out.println(Arrays.asList(67,3,78,12,4,3).stream()
                .reduce((n1,n2) -> n1 < n2 ? n2 : n1).get());

        System.out.println(Arrays.asList(67,3,78,12,4,3).stream()
                .mapToInt(Integer::intValue)
                .reduce((n1,n2) -> n1 < n2 ? n2 : n1).getAsInt());

        System.out.println(Arrays.asList(67,3,78,12,4,3).stream()
                .mapToInt(Integer::intValue)
                .sum());

        IntStream evenNumbers = IntStream.rangeClosed(1,100)
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());

        System.out.println("Fib:");
        fib(0,1, Integer.MAX_VALUE);
    }

    //Fibonacci
    private static long fib(long i, long j, int limit) {
        if (i >= limit)
            return i;
        long next = j;
        System.out.println(next);
        return fib(next , j + i, limit);
    }
}
