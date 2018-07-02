package com.evpa.mj.chs.three;

import com.evpa.mj.chs.one.Apple;
import com.evpa.mj.chs.one.AppleColor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class MainThree {
    public static void main(String[] args) {

        System.out.println(new TriFunctionImpl().add(2,5,9));
        TriFunction ss = (s,d,f) -> 12 + 13 + 14;
        System.out.println(summ(ss));
        System.out.println(summ((a,b,c) -> 5 + 8 + 2));
        process(() -> {});
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
