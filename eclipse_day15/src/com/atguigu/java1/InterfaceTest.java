package com.atguigu.java1;

/**
 * @author：ZhouYao
 * @create：2021-09-28 13:43
 */

/* 接口(interface)是抽象方法和常量值定义的集合。
 * 接口的特点：
 * 用 interface 来定义。
 * 接口中的所有成员变量都默认是由 public static final 修饰的。
 * 接口中的所有抽象方法都默认是由 public abstract 修饰的。
 * 接口中没有构造器。
 * 接口采用多继承机制。
 */

/*
 * 接口的使用
 * 1.接口使用 interface 来定义。
 * 2.在 Java 中:接口和类是并列的两个结构
 * 3.如何去定义两个接口:定义接口中的成员
 * 	 > 3.1 JDK7 及以前:只能定义全局常量和抽象方法
 * 		> 全局常量:public static final的(但是书写中，可以省略不写)
 * 		> 抽象方法:public abstract 的
 *   > 3.2 JDK8:除了全局常量和抽象方法之外，还可以定义静态方法、默认方法(看java8)。
 *
 * 4.接口中不能定义构造器！意味着接口不可以实例化。
 *
 * 5.Java 开发中，接口通过让类去实现(implements)的方式来使用。
 *   如果实现类覆盖了接口中的所有方法，则此实现类就可以实例化
 *   如果实现类没有覆盖接口中所有的抽象方法，则此实现类仍为一个抽象类
 *
 * 6.Java 类可以实现多个接口 ---> 弥补了 Java 单继承性的局限性
 *  格式:class AA extends BB implements CC,DD,EE
 *
 *  7.接口与接口之间是继承,而且可以多继承
 *
 **********************************
 * 8.接口的具体使用，体现多态性
 * 	   接口的主要用途就是被实现类实现。（面向接口编程）
 * 9.接口，实际可以看作是一种规范
 *
 * 面试题:抽象类与接口有哪些异同？ ---> 看csdn(面向对象下)或宋老师的课件
 *
 */
public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flayable.MAX_SPEED);
        System.out.println(Flayable.MIN_SPEED);
    }
}

interface Flayable {

    //全局变量
    public static final int MAX_SPEED = 7900;
    int MIN_SPEED = 1; //省略了 public static final

    //抽象方法
    public abstract void fly();

    void stop(); //省略了 public abstract

    //Interfaces cannot have constructors
//	public Flayable(){
//
//	}
}

interface Attackable {
    void attack();
}

class Plane implements Flayable {

    @Override
    public void fly() {
        System.out.println("飞机通过引擎起飞");
    }

    @Override
    public void stop() {
        System.out.println("驾驶员减速停止");
    }
}

abstract class Kite implements Flayable {
    @Override
    public void fly() {

    }
}

class Bullet extends Object implements Flayable, Attackable, CC {

    @Override
    public void attack() {
        // TODO Auto-generated method stub
    }

    @Override
    public void fly() {
        // TODO Auto-generated method stub
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
    }

    @Override
    public void method1() {
        // TODO Auto-generated method stub
    }

    @Override
    public void method2() {
        // TODO Auto-generated method stub
    }
}

//*********************************
interface AA {
    void method1();
}

interface BB {
    void method2();
}

interface CC extends AA, BB {

}

