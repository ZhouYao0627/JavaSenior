package com.atguigu.exer3;

/**
 * @author：ZhouYao
 * @create：2021-09-28 17:44
 */

/*
 * 定义一个测试类 InterfaceTest，创建两个 ComparableCircle 对象，
 * 调用 compareTo 方法比较两个类的半径大小。
 *
 */
public class InterfaceTest {
    public static void main(String[] args) {

        ComparableCircle c1 = new ComparableCircle(3.4);
        ComparableCircle c2 = new ComparableCircle(3.6);

        int compareValue = c1.compareTo(c2);
        if (compareValue > 0) {
            System.out.println("c1 对象大");
        } else if (compareValue < 0) {
            System.out.println("c2 对象大");
        } else {
            System.out.println("两个一样的");
        }

        int compareValue1 = c1.compareTo(new String("AA"));
        System.out.println(compareValue1);
    }
}

