package com.evpa.mj.chs.fifteen;

public class ArithmeticCell extends SimpleCell {

    private Integer left;
    private Integer right;

    public void setLeft(Integer left) {
        this.left = left;
        onNext(left + right);
    }

    public void setRight(Integer right) {
        this.right = right;
        onNext(right + left);
    }

    public ArithmeticCell(String name) {
        super(name);
    }

    public static void main(String[] args) {
        ArithmeticCell c3 = new ArithmeticCell("C3");
        SimpleCell c1 = new SimpleCell("C1");
        SimpleCell c2 = new SimpleCell("C2");

        c1.subscribe(c3);
        c2.subscribe(c3);

        c1.onNext(10);
        c2.onNext(20);
    }

}
