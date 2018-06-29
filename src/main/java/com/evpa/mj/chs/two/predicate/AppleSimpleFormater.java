package com.evpa.mj.chs.two.predicate;

import com.evpa.mj.chs.one.Apple;

public class AppleSimpleFormater implements AppleFormater {
    @Override
    public String accept(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}
