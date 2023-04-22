package com.evpa.mj.chs.sixteen;

public class Discount {
    public enum Code {

        NONE(0),
        SILVER(5),
        GOLD(10),
        PLATINUM(15);

        Code(int percentage) {
        }
    }
}
