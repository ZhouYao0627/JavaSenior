package com.atguigu.java1;

/**
 * @author：ZhouYao
 * @create：2021-09-29 20:45
 */

import org.junit.Test;
import java.util.Date;
import java.util.Scanner;

/*
 * 一、java异常体系结构
 *
 * java.lang.Throwable
 * 		|----java.lang.Error:一般不编写针对性的代码进行处理
 * 		|----java.lang.Exception:可以进行异常处理
 * 			|----编译时异常(checked)
 * 				|----IOEXception
 * 					|----FileNotFoundException
 * 				|----ClassNotFoundException
 * 			|----运行时异常(unchecked/RuntimeException)
 * 				|----NullPointerException：空指针异常
 * 				|----ArrayIndexOutOfBoundsException：数组角标越界
 * 				|----ClassCaseException：类型转换异常
 * 				|----NumberFormatException
 * 				|----InputMismatchException：输入不匹配异常
 * 				|----ArithmaticException
 *
 * 面试题:常见的异常有哪些？举例说明
 */
public class ExceptionTest {

    // ******************以下是编译时异常***************************
    @Test
    public void test7() {
//		File file = new File("hello.txt");
//		FileInputStream fis = new FileInputStream(file);
//
//		int data = fis.read();
//		while(data != -1){
//			System.out.print((char)data);
//			data = fis.read();
//		}
//
//		fis.close();
    }

    // ******************以下是运行时异常***************************
    // ArithmeticException
    @Test
    public void test6() {
        int a = 10;
        int b = 0;
        System.out.println(a / b);
    }

    // InputMismatchException
    @Test
    public void test5() {
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        System.out.println(score);

        scanner.close();
    }

    // NumberFormatException
    @Test
    public void test4() {
        String str = "123";
        str = "abc";
        int num = Integer.parseInt(str);
    }

    // ClassCaseException
    @Test
    public void test3() {
        Object obj = new Date();
        String str = (String) obj;
    }

    // ArrayIndexOutOfBoundsException
    @Test
    public void test2() {
        // int[] arr = new int[10];
        // System.out.println(arr[10]);

        // String str = "abc";
        // System.out.println(str.charAt(3));
    }

    // NullPointerException
    @Test
    public void test1() {
        // int[] arr = null;
        // System.out.println(arr[3]);

        // String str = "abc";
        // str = null;
        // System.out.println(str.charAt(0));
    }
}

