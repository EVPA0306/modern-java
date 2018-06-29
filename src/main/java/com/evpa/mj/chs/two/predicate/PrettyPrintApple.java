package com.evpa.mj.chs.two.predicate;

import com.evpa.mj.chs.one.Apple;

public class PrettyPrintApple implements ApplePrintPredicate {
    @Override
    public void  print(Apple apple) {
        System.out.println(apple.getWeight());
    }
}
