package com.evpa.mj.chs.nine;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainOfResponsibility {

    public static void main(String[] args) {
        UnaryOperator<String> headerProcessing = (String text) -> "Greetings from: " + text;

        UnaryOperator<String> spellChecker = (String text) -> text.replaceAll("o", "a");

        Function<String, String> pipeLine = headerProcessing.andThen(spellChecker);

        System.out.println(pipeLine.apply("Povlenko"));
    }
}
