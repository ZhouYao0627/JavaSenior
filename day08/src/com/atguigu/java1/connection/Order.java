package com.atguigu.java1.connection;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型类
 *
 * @author：ZhouYao
 * @create：2021-07-17 16:46
 */
public class Order<T> {

    String orderName;
    int orderId;

    // 类的内部结构就可以使用类的泛型
    T orderT;

    public Order() {

        // 错误，编译不通过
//        T[] arr = new T[10];
        // 编译通过
        T[] arr = (T[]) new Object[10];


    }

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    // 如下的三个方法都不是泛型方法
    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    // 静态方法中不能使用类的泛型  ---> 因为静态结构早于对象的创建
//    public static void show(T orderT){
//        System.out.println(orderT);
//    }

    public void show() {
        // 编译不通过
//        try {
//
//        }catch (T t){
//
//        }
    }

    /*
    泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
    换句话说，泛型方法所属的类是不是泛型类都没有关系。
    泛型方法，可以声明为静态的。原因：泛型参数是在调用方法时确定的。并非在实例化类时确定。

    泛型方法的格式： ★★★
    [访问权限] <泛型> 返回类型 方法名([泛型标识 参数名称]) 抛出的异常
    */

    public <E> List copyFromArrayToList(E[] arr){

        ArrayList<E> list = new ArrayList<>();

        for (E e : list){
            list.add(e);
        }
        return list;
    }


}
