package com.evpa.mj.chs.eight;

import static java.util.Map.entry;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainEight {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        var friends = Map.of("Tom",45, "Linda","18", "Steve",30);
        friends.forEach((friend,age) -> System.out.println(friend + " " +age));

        System.out.println(friends);

        List<String> names = Arrays.asList("Tom","Linda");
        names.set(0,"Eugene");
        //names.add("Tom");

        System.out.println(names);

        List<String> moreNames = List.of("Eugene", "Marina");
        //moreNames.set(1,"Steve");
        System.out.println(moreNames);
        //moreNames.removeIf();
        //moreNames.replaceAll();

        Map<String, String> favouriteMovies = Map.ofEntries(entry("Raphael", "Star Wars"),
                entry("Cristina", "Matrix"),
                entry("Olivia", "James Bond"));

        System.out.println("Unsorted map:: " + favouriteMovies);

        favouriteMovies.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);

        Map<String, byte[]> dataToHash = new HashMap<>();
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        names.forEach(key ->
                dataToHash.computeIfAbsent(key, hash -> messageDigest.digest(hash.getBytes(StandardCharsets.UTF_8))));

        System.out.println(dataToHash);
    }
}
