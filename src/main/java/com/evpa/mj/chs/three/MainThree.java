package com.evpa.mj.chs.three;

public class MainThree {
    public static void main(String[] args) {
        System.out.println(new TriFunctionImpl().add(2,5,9));
        TriFunction ss = (s,d,f) -> 12 + 13 + 14;
        System.out.println(summ(ss));
        System.out.println(summ((a,b,c) -> 5 + 8 + 2));
        process(() -> {});
    }

    private static int summ(TriFunction triFunction) {
        return triFunction.add(0,0,0);
    }

    private static void process(NothingFunction nothingFunction) {
        nothingFunction.none();
    }
}
