package com.evpa.mj.chs.seventeen;

public class Test {

    static {
        System.out.println("Static block");
    }

    {
        System.out.println("Non-static block");
    }

    public static void main(String[] args) {
        System.out.println("Main");
        Test test = new Test();
        Test test1 = new Test();
    }
}
