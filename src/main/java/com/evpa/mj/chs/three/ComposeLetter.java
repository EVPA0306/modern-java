package com.evpa.mj.chs.three;

import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;

public class ComposeLetter {
    public static void main(String[] args) {

        Function<String,String> addHeader = Letter::addHeader;
        Function<String,String> transformationPipeline = addHeader
                .andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);
        String finalText = transformationPipeline.apply("Eugene labda");
        System.out.println(finalText);
        System.out.println(f(3));
        System.out.println(integrate(f -> f + 5, 3,7));
    }

    private static Integer f(Integer x) {
        return x + 10;
    }

    private static double integrate(DoubleUnaryOperator f, double a, double b) {
        return (f.applyAsDouble(a) + f.applyAsDouble(b)) * (b-a) / 2.0;
    }
}
