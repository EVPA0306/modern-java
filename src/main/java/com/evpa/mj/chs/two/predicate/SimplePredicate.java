package com.evpa.mj.chs.two.predicate;

import com.evpa.mj.chs.one.Apple;

import java.util.function.Predicate;

public class SimplePredicate implements Predicate<Apple> {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 0;
    }
}
