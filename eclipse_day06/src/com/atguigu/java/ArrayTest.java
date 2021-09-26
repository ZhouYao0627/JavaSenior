package com.atguigu.java;

/**
 * @author：ZhouYao
 * @create：2021-09-18 18:17
 */
public class ArrayTest {

    public static void main(String[] args) {

        int[] ids; // 声明
        // 1.1 静态初始化：数组的初始化和数组元素的赋值操作同时进行
        ids = new int[]{1001, 1002, 1003, 1004};

        // 1.2 动态初始化：数组的初始化和数组元素的赋值操作分开进行
        String[] names = new String[5];

        // 2.如何调用数组的指定位置的元素：通过角标的方式调用。
        // 数组的角标(或索引)从0开始的，到数组的长度-1结束
        names[0] = "张郃";
        names[1] = "王陵";
        names[2] = "张学良";
        names[3] = "王传志";    //charAt(0)
        names[4] = "李峰";
//		names[5] = "周礼";	//如果数组超过角标会通过编译，运行失败。

        // 3.如何获取数组的长度
        // 属性：length
        System.out.println(names.length);
        System.out.println(ids.length);

        // 4.如何遍历数组
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);

        }


    }


}
