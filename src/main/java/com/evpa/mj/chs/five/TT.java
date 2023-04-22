package com.evpa.mj.chs.five;


import com.evpa.mj.chs.Data;
import com.evpa.mj.chs.four.Trader;
import com.evpa.mj.chs.four.Transaction;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static com.evpa.mj.chs.Data.*;

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


        List<Transaction> transactions2011 = TRANSACTIONS_LIST.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getAmount))
                .collect(Collectors.toList());
        out.println("1." + transactions2011);

        List<String> uniqueCities = TRANSACTIONS_LIST.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        out.println("2." + uniqueCities);

        List<Trader> tradersFromCambridge = TRANSACTIONS_LIST.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equalsIgnoreCase(trader.getCity()))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toList());

        out.println("3." + tradersFromCambridge);

        String allTraders = TRANSACTIONS_LIST.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining(" "));
        out.println("4." + allTraders);

        boolean inMilan = TRANSACTIONS_LIST.stream()
                .anyMatch(transaction -> "Milan".equalsIgnoreCase(transaction.getTrader().getCity()));
        out.println(inMilan);

        TRANSACTIONS_LIST.stream()
                .filter(transaction -> "Cambridge".equalsIgnoreCase(transaction.getTrader().getCity()))
                .forEach(t -> out.println(t.getAmount()));

        out.println(TRANSACTIONS_LIST.stream()
                .map(Transaction::getAmount)
                .reduce(Integer::max)
        );

        Optional<Transaction> smallest = TRANSACTIONS_LIST.stream()
                .sorted((t1,t2) -> ((Integer)t1.getAmount()).compareTo(t2.getAmount()))
                .findFirst();
        out.println(smallest.get());

        Optional<Transaction> smallestTransaction =
                TRANSACTIONS_LIST.stream()
                        .reduce((t1, t2) ->
                                t1.getAmount() < t2.getAmount() ? t1 : t2);
        out.println(smallestTransaction.get());


        out.println(Arrays.asList(67,3,78,12,4,3).stream()
                .reduce((n1,n2) -> n1 < n2 ? n2 : n1).get());

        out.println(Arrays.asList(67,3,78,12,4,3).stream()
                .mapToInt(Integer::intValue)
                .reduce((n1,n2) -> n1 < n2 ? n2 : n1).getAsInt());

        out.println(Arrays.asList(67,3,78,12,4,3).stream()
                .mapToInt(Integer::intValue)
                .sum());

        IntStream evenNumbers = IntStream.rangeClosed(1,100)
                .filter(n -> n % 2 == 0);
        out.println(evenNumbers.count());


        Map<Trader,List<Transaction>> transactionsByTrader = TRANSACTIONS_LIST.stream()
                .collect(groupingBy(Transaction::getTrader));
        out.println(transactionsByTrader);


      out.println("Fibonacci:");
      Stream.iterate(new int[]{0,1}, n -> new int[]{n[1], n[0] + n[1]})
              .limit(20)
              .map(t -> t[0] + " ")
              .forEach(out::print);

      out.println();

      String str = "Darshan";
      out.println(str);

      str.chars()
              .distinct()
              .forEach(ch -> out.print((char)ch));


    }

}
