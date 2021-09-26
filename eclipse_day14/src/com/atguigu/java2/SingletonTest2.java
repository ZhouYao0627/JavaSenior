package com.atguigu.java2;

/**
 * @author：ZhouYao
 * @create：2021-09-25 17:30
 */

/*
 * 单例的懒汉式实现
 */
public class SingletonTest2 {
    public static void main(String[] args) {

        Order order1 = Order.getInstance();
        Order order2 = Order.getInstance();

        System.out.println(order1 == order2);
    }
}

class Order {
    // 1.私有化类的构造器
    private Order() {
    }

    // 2.声明当前类对象，没有初始化。
    // 此对象也必须声明为static的
    private static Order instance = null;

    // 3.声明 public、static 的返回当前类对象的方法
    public static Order getInstance() {
        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }
}
