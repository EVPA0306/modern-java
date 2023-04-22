package com.evpa.mj.chs.seven;

import java.util.Arrays;
import java.util.stream.IntStream;

public class WordCount {

    public static void main(String[] args) {
        final String SENTENCE =
                " Nel   mezzo del cammin  di nostra  vita " +
                        "mi  ritrovai in una  selva oscura" +
                        " ché la  dritta via era   smarrita ";

        System.out.println("Found " + countWords(SENTENCE) + " words");

        int wordCount = 0;
        boolean isWs = false;
        for (char ch : SENTENCE.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                isWs = true;
            } else {
                if (isWs) {
                    wordCount++;
                    isWs = false;
                }
            }
        }

        System.out.println("wc::" + wordCount);

        //System.out.println(
                SENTENCE.lines()
                        .map(str -> str.split(""))
                        .flatMap(Arrays::stream)
                        //.filter(Predicate.not(String::isBlank))
                        //.collect(groupingBy(String::isBlank)))
                        .forEach(System.out::println)
                //.collect(Collectors.joining("|")))
        //)
        ;
    }

    private static int countWords(String sentence) {
        return IntStream.range(0, sentence.length())
                .mapToObj(sentence::charAt)
                .reduce(new WordCounter(0,true),
                        WordCounter::accumulate, WordCounter::combine)
                .getCounter();
    }

    private static class WordCounter {

        private final int counter;
        private final boolean lastSpace;

        public WordCounter(int counter, boolean lastSpace) {
            this.counter = counter;
            this.lastSpace = lastSpace;
        }

        public WordCounter accumulate(Character character) {
            if (Character.isWhitespace(character)) {
                return lastSpace ? this : new WordCounter(counter, true);
            } else {
                return lastSpace ? new WordCounter(counter + 1, false) : this;
            }
        }

        public WordCounter combine(WordCounter wordCounter) {
            return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
        }

        public int getCounter() {
            return counter;
        }
    }
}
