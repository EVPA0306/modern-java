package com.evpa.mj.chs.three;

public class Test {
    public static void main(String[] args) {
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                System.out.printf("%3d",i*j);
            }
            System.out.println();
        }
        Runnable runnable = () -> System.out.println("One");
        process(() -> System.out.println("Test"));
        process(runnable);
    }

    private static void process(Runnable runnable) {
        runnable.run();
    }
}
