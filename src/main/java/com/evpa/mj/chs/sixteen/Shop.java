package com.evpa.mj.chs.sixteen;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

public class Shop {

    private final String name;

    public Shop(String name) {
        this.name = name;
    }

    public Double getPrice(String product) {
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
                    try {
                        double price = getPrice(product);
                        completableFuture.complete(price);
                    } catch (Exception e) {
                        completableFuture.completeExceptionally(e);
                    }
                }).start();
        return completableFuture;
    }

    private Double calculatePrice(String product) {
        randomDelay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void randomDelay() {
        int delay = 500 + new Random().nextInt(200);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        Shop shop = new Shop("Apple");

        System.out.println(shop.getPriceAsync("iPhone Xr")
                .get(10, TimeUnit.SECONDS));

        List<Shop> shops = List.of(new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll"),
                new Shop("BigFive")
        );

        final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(),100), (Runnable r) ->
        {
            Thread th = new Thread(r);
            th.setDaemon(true);
            return th;
        });

        long start = System.nanoTime();
        var prices = shops.parallelStream()
                .map(shp -> shp.getPrice("myPhone27S"))
                .collect(Collectors.toList());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
        System.out.println(prices);

        long startOne = System.nanoTime();
        var futurePrices = shops.stream()
                .map(shp -> CompletableFuture.supplyAsync(() -> shp.getPrice("myPhone27S"), executor))
                .collect(Collectors.toList()).stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        long durationOne = (System.nanoTime() - startOne) / 1_000_000;
        System.out.println("Done in " + durationOne + " msecs");
        System.out.println(futurePrices);
    }
}
