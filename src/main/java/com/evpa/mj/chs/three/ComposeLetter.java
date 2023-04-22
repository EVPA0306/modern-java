package com.evpa.mj.chs.three;

import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;

public class ComposeLetter {
    public static void main(String[] args) {

        Function<String,String> addHeader = Letter::addHeader;
        System.out.println(addHeader.apply("TEST"));
        Function<String,String> transformationPipelineWithCorrection = addHeader
                .andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);
        String finalText = transformationPipelineWithCorrection.apply("Eugene labda");
        System.out.println(finalText);


        Function<String, String> transformationPipelineWithOutCorrection =
                addHeader.andThen(Letter::addFooter);

        System.out.println(transformationPipelineWithOutCorrection.apply("Eugene labda"));


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
