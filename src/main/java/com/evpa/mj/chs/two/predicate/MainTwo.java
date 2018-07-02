package com.evpa.mj.chs.two.predicate;

import com.evpa.mj.chs.one.Apple;
import com.evpa.mj.chs.one.AppleColor;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Predicate;

import static com.evpa.mj.chs.one.AppleColor.GREEN;
import static com.evpa.mj.chs.one.AppleColor.PINK;

public class MainTwo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Apple> inventory = Arrays.asList(new Apple().withColor(GREEN).withWeight(150)
                ,new Apple().withColor(AppleColor.RED).withWeight(170)
                , new Apple().withColor(AppleColor.PINK).withWeight(230)
        );

        List<Integer> integers = Arrays.asList(Integer.valueOf(100), Integer.valueOf(110), Integer.valueOf(120));

        Integer[] arrInt = new Integer[] {130,140,150};

        System.out.println(filter(inventory,new AppleGreenColorPredicate()));
        System.out.println(filter(inventory, apple -> GREEN.equals(apple.getColor())));
        prettyPrintApple(inventory,new PrettyPrintApple());
        simplePrintApple(inventory, new AppleSimpleFormater());
        simplePrintApple(inventory, new AppleFormater() {
            @Override
            public String accept(Apple apple) {
                return "Apple weight: " + apple.getWeight();
            }
        });
        simplePrintApple(inventory, apple -> "Apple is " + apple.toString());
        System.out.println(filterUni(inventory,apple -> PINK.equals(apple.getColor())));
        System.out.println(filterUni(integers, i -> i >= 101));
        System.out.println(filterUni(inventory,new SimplePredicate()));
        Object[] newArrInt = Arrays.asList(arrInt).parallelStream()
                .filter(integer -> integer >= 131)
                .toArray();
        System.out.println(Arrays.toString(newArrInt));
        //SORT
        Collections.sort(integers);
        System.out.println(inventory);
        Collections.sort(inventory, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return Integer.valueOf(o2.getWeight()).compareTo(o1.getWeight());
            }
        });
        System.out.println(inventory);

        Collections.sort(inventory, (a,b) -> Integer.valueOf(a.getWeight()).compareTo(b.getWeight()));
        System.out.println(inventory);

        inventory.sort((a,b) -> Integer.valueOf(b.getWeight()).compareTo(a.getWeight()));
        System.out.println(inventory);

        Thread t  = new Thread(() -> System.out.println("Hello"));
        //t.run();
        t.start();

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> threadName = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });
        Future<String> stringFuture = executorService.submit(() -> Thread.currentThread().getName());
        System.out.println(threadName.get() + " " + stringFuture.get());
        executorService.shutdown();
    }

    private static <T> List<T> filterUni(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T e: list) {
            if (predicate.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    private static void simplePrintApple(List<Apple> inventory, AppleFormater af) {
        for (Apple apple: inventory) {
            System.out.println(af.accept(apple));
        }
    }

    private static void prettyPrintApple(List<Apple> inventory, PrettyPrintApple prettyPrintApple) {
        for (Apple apple: inventory) {
            prettyPrintApple.print(apple);
        }
    }

    private static List<Apple> filter(List<Apple> inventory, ApplePredicate predicate) {

        List<Apple> result = new ArrayList<>();

        for (Apple apple: inventory) {
            if(predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
