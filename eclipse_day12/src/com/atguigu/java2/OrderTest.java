package com.atguigu.java2;

/**
 * @author：ZhouYao
 * @create：2021-09-23 21:48
 */

public class OrderTest {
    public static void main(String[] args) {

        Order order = new Order();

        order.orderDefault = 1;
        order.orderProtected = 2;
        order.orderPublic = 3;

        order.methodDefault();
        order.methodProtected();
        order.methodPublic();

        //同一个包中的其它类，不可以调用Order类中私有的属性
//		order.orderPrivate = 4;	//The field Order.orderPrivate is not visible
//		order.methoPrivate();
    }
}

