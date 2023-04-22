package com.evpa.mj.chs.fifteen;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.IntConsumer;

public abstract class ExecutorServiceExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> y = executorService.submit(() -> f(2));
        Future<Integer> z = executorService.submit(() -> f(2));

        System.out.println(y.get() + " " + z.get());

        CompletableFuture<Integer> a = new CompletableFuture<>();
        CompletableFuture<Integer> b = new CompletableFuture<>();
        CompletableFuture<Integer> c = a.thenCombine(b, Integer::sum);

        executorService.submit(() -> a.complete(f(3)));
        executorService.submit(() -> b.complete(f(3)));

        System.out.println(c.get());

        executorService.shutdown();
    }

    private static Integer f(Integer x) {
        return x * x;
    }

    public abstract void ff(Integer x, IntConsumer r);
}
