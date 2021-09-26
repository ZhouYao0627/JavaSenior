package com.atguuigu.java1;

/**
 * @author：ZhouYao
 * @create：2021-09-24 13:54
 */

import java.util.Date;

/*
 * Object类中toString()的使用
 *
 * 1.当我们输出一个引用对象时，实际上就是调用当前对象的toString()
 * 2.Object类中toString的定义方法
 * 	public String toString() {
 *      return getClass().getName() + "@" + Integer.toHexString(hashCode());
 *  }
 *
 * 3.像String、Date、File、包装类等都重写了Object类中的toString()方法。
 * 	 使得在调用toString()时，返回"实体内容"信息.
 *
 * 4.自定义类如果重写toString()方法，当调用此方法时，返回对象的"实体内容".
 */
public class ToStringTest {
    public static void main(String[] args) {

        Customer cust1 = new Customer("Tom", 21);
        System.out.println(cust1.toString());    //com.atguuigu.java1.Customer@b4c966a
        System.out.println(cust1);    //com.atguuigu.java1.Customer@b4c966a ---> Customer[name = Tom,age = 21]

        String str = new String("MM");
        System.out.println(str); // MM

        Date date = new Date(45362348664663L);
        System.out.println(date.toString());    //Wed Jun 24 12:24:24 CST 3407

    }
}

