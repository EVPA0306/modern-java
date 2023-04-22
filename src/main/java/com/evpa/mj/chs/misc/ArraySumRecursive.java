package com.evpa.mj.chs.misc;

public class ArraySumRecursive {

    public static void main(String[] args) {
        int[] array = new int[]{5,4,3,2,1};
        System.out.println(arraySumm(array,0));
    }

    private static int arraySumm(final int[] array, final int start) {
        if (start >= array.length) {
            return 0;
        } else {
            return array[start] + arraySumm(array, start + 1);
        }
    }

}
