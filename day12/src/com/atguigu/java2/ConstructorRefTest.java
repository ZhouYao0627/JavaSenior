package com.atguigu.java2;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * 一、构造器引用
 *      和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致。
 *      抽象方法的返回值类型即为构造器所属的类的类型
 *
 * 二、数组引用
 *     大家可以把数组看做是一个特殊的类，则写法与构造器引用一致。
 *
 * Created by shkstart
 */
public class ConstructorRefTest {
    // 构造器引用
    // Supplier中的T get()
    // Employee的空参构造器：Employee()
    @Test
    public void test1() {

        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println("*******************");

        Supplier<Employee>  sup1 = () -> new Employee();
        System.out.println(sup1.get());

        System.out.println("*******************");

        Supplier<Employee>  sup2 = Employee :: new;
        System.out.println(sup2.get());
    }

    //Function中的R apply(T t)
    @Test
    public void test2() {

    }

    //BiFunction中的R apply(T t,U u)
    @Test
    public void test3() {

    }

    //数组引用
    //Function中的R apply(T t)
    @Test
    public void test4() {

    }
}
