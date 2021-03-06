package com.atguuigu.java2;

/**
 * @author：ZhouYao
 * @create：2021-09-24 14:37
 */

import org.junit.Test;

/*
 * 如下两个题目输出结果相同吗？各是什么：
 * 		Object o1= true? new Integer(1) : new Double(2.0);
 * 		System.out.println(o1);//
 *
 * 		Object o2;
 * 		if(true)
 * 			o2 = new Integer(1);
 *		else
 *			o2 = new Double(2.0);
 *		System.out.println(o2);//
 *
 */
public class InterViewTest {

    @Test
    public void test() {
        Object o1 = true ? new Integer(1) : new Double(2.0); // ---> 统一类型，即类型提升了
        System.out.println(o1);// 1.0
    }

    @Test
    public void test2() {
        Object o2;
        if (true)
            o2 = new Integer(1);
        else
            o2 = new Double(2.0);
        System.out.println(o2);// 1
    }

    @Test
    public void method1() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); //false

        //Integer内部定义了一个IntegerCache结构，IntegerCache中定义Integer[]
        //保存了从-128-127范围的整数。如果我们使用自动装箱的方式，给Integer赋值的范围在其中时，
        //可以直接使用数组中的元素，不用再去new了。目的，提高效率。

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);//true

        Integer x = 128; //相当于new了一个Integer对象
        Integer y = 128; //相当于new了一个Integer对象
        System.out.println(x == y); //false

    }
}

