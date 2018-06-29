package com.evpa.mj.chs.two.predicate;

import com.evpa.mj.chs.one.Apple;
import com.evpa.mj.chs.one.AppleColor;

public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return AppleColor.GREEN.equals(apple.getColor());
    }
}
