package com.atguigu.java;

/**
 * @author：ZhouYao
 * @create：2021-09-18 22:11
 */
public class BubbleSortTest {

    public static void main(String[] args) {

        int[] arr = new int[]{43, 32, 76, 92, -65, 85, 71, -42};
        int temp;

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }

    }

}
