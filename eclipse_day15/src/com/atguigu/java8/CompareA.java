package com.atguigu.java8;

/**
 * @author：ZhouYao
 * @create：2021-09-28 18:25
 */

/*
 * JDK8:除了全局常量和抽象方法之外，还可以定义静态方法、默认方法(略)。
 */
public interface CompareA {

    //静态方法
    public static void method1() {
        System.out.println("CompareA:西安");
    }

    //默认方法
    public default void method2() {
        System.out.println("CompareA:深圳");
    }

    default void method3() { // 虽然前面省略了修饰关键字，但它还是public的
        System.out.println("CompareA:杭州");
    }
}

