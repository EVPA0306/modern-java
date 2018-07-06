package com.evpa.mj.chs.three;

import com.evpa.mj.chs.one.Apple;
import com.evpa.mj.chs.one.AppleColor;
import com.evpa.mj.chs.one.Fruit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class MainThree {

    static Map<String, Function<Integer,Fruit>>  fruitMap = new HashMap<>();
    static {
        fruitMap.put("apple",Apple::new);
    }

    private static Fruit giveMeFruit(String fruit, Integer weight) {
        return fruitMap.get(fruit.toLowerCase())
                .apply(weight);
    }

    public static void main(String[] args) {

        Fruit firstApple = giveMeFruit("apple", 555);
        System.out.println(firstApple);

        System.out.println(new TriFunctionImpl().add(2,5,9));
        TriFunction ss = (s,d,f) -> 12 + 13 + 14;
        System.out.println(summ(ss));
        System.out.println(summ((a,b,c) -> 5 + 8 + 2));
        process(() -> {});

        Runnable runnable = () -> System.out.println("One");
        //process(runnable);

        try {
            System.out.println(processFile(bufferedReader -> bufferedReader.readLine() + bufferedReader.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Arrays.asList(1,2,4,5,6)
                .stream()
                .forEach(i -> out.println(i));

        List<AppleColor> colors = Arrays.asList(new Apple().withColor(AppleColor.PINK),new Apple().withColor(AppleColor.GREEN))
                .stream()
                .map(apple -> apple.getColor())
                .collect(Collectors.toList());
        out.println(colors);

        List<Integer> l = map(
                Arrays.asList("lambdas", "in", "action"),
                (String s) -> s.length()
        );

        final int portNumber = 2221;
        Object o = (Runnable)() -> { System.out.println("Tricky example: port number: " + portNumber); };
        ((Runnable) o).run();
        //portNumber = 2222;

        List<String> strings = Arrays.asList("a","b","A","B","c");
        System.out.println(strings);
        strings.sort(String::compareTo);
        System.out.println(strings);

        Supplier<Apple> newApple = Apple::new;
        System.out.println(newApple.get());

        Supplier<Apple> anotherApple = () -> new Apple().withColor(AppleColor.GREEN);
        System.out.println(anotherApple.get());

        Function<AppleColor, Apple> appleColorFunction = Apple::new;
        System.out.println(appleColorFunction.apply(AppleColor.PINK));
        Function<AppleColor, Apple> appleFunction = (color) -> new Apple(AppleColor.RED);

        List<Integer> weights = Arrays.asList(7,3,4,10);
        List<Apple> apples = map(weights,Apple::new);
        System.out.println(apples);
    }

    private static String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/usr/share/dict/words"))) {
            return processor.process(bufferedReader);
        }
    }

    private static int summ(TriFunction triFunction) {
        return triFunction.add(0,0,0);
    }

    private static void process(NothingFunction nothingFunction) {
        nothingFunction.none();
    }

    private static  <T,R> List<R>map(List<T> list, Function<T,R> function) {
        List<R> res = new ArrayList<>();
        for (T t: list) {
            res.add(function.apply(t));
        }
        return res;
    }
}
