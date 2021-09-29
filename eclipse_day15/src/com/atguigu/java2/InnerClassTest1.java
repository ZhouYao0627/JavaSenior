package com.atguigu.java2;

/**
 * @author：ZhouYao
 * @create：2021-09-29 9:27
 */

public class InnerClassTest1 {

    // 开发中很少见
    public void method() {
//		局部内部类
        class AA {

        }
    }

    // 返回一个实现了Comparable接口的类的对象
    public Comparable getComparable() {

//		创建一个实现了Comparable接口的类:局部内部类
        //方式一(标准方式->非匿名实现类的匿名对象)：
//		class MyComparable implements Comparable{
//			@Override
//			public int compareTo(Object o) {
//				return 0;
//			}
//		}
//		return new MyComparable();

        //方式二(匿名方式->匿名实现类的匿名对象)：
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };

    }
}

