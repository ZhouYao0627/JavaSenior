package com.atguuigu.java2;

import org.junit.Test;

/**
 * @author：ZhouYao
 * @create：2021-07-14 18:50
 */

/*
 * 包装类的使用
 * 1.java提供了8种基本数据类型对应的包装类，使得基本数据类型的变量具有类的特征
 * 		基本数据类型		包装类
 * 		byte			Byte
 * 		short			Short
 * 		int 			Integer
 * 		long			Long
 * 		float			Float
 * 		double			Double
 * 		boolean			Boolean
 * 		char			Character
 *  注意:其中Byte、Short、Integer、Long、Float、Double的父类是:Number
 *
 * 2.基本数据类型、包装类、String三者之间的相互转换。
 */

/*
 * 为什么要使用包装类？
 * 答：为了使基本数据类型的变量具有类的特征，引入包装类
 */

public class WrapperTest {

    // String类型--->基本数据类型,包转类：调用包装类的parseXxx(String s)
    @Test
    public void test5() {
        String str1 = "123";
        // 错误的情况：
//		int num1 = (int)str1;
//		Integer in1 = (Integer)str1;

        int num2 = Integer.parseInt(str1);
        System.out.println(num2 + 1);

        String str2 = "true1";
        boolean b1 = Boolean.parseBoolean(str2);
        System.out.println(b1);
    }

    // 基本数据类型,包转类--->String类型:调用String重载的valueOf(Xxx xxx)
    @Test
    public void test4() {

        int num1 = 10;
        // 方式1：连接运算
        String str1 = num1 + "";
        // 方式2：调用String重载的valueOf(Xxx xxx)
        float f1 = 12.3f;
        String str2 = String.valueOf(f1); // "12.3"

        Double d1 = new Double(12.4);
        String str3 = String.valueOf(d1);
        System.out.println(str2);
        System.out.println(str3); // "12.4"
    }

    /*
     * JDK 5.0新特性：自动装箱与自动拆箱
     */
    @Test
    public void test3() {

//		int num1 = 10;
//		// 基本数据类型--->包装类
//		method(num1);

        // 自动装箱：基本数据类型--->包装类
        int num2 = 10;
        Integer in1 = num2; // 自动装箱

        boolean b1 = true;
        boolean b2 = b1; // 自动装箱

        // 自动拆箱：包转类--->基本数据类型
        System.out.println(in1.toString()); // 10

        int num3 = in1; // 自动拆箱

    }
//
//	public void method(Object obj) {
//		System.out.println(obj);
//	}

    // 包装类--->基本数据类型：调用包装类的xxxValue()
    @Test
    public void test2() {
        Integer in1 = new Integer(12);
        int i1 = in1.intValue();
        System.out.println(i1 + 1);

        Float f1 = new Float(12.3);
        float f2 = f1.floatValue();
        System.out.println(f2 + 1);

    }

    // 基本数据类型--->包装类：调用包装类的构造器
    @Test
    public void test1() {
        int num1 = 10;
        Integer in1 = new Integer(num1);
        System.out.println(in1.toString());
    }

}
