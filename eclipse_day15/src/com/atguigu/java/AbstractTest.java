package com.atguigu.java;

/**
 * @author：ZhouYao
 * @create：2021-09-26 20:52
 */

/*
 * abstract 关键字的使用
 *
 * 1.abstract:抽象的
 * 2.abstract 可以用来修饰的结构:类、方法
 * 3.abstract 修饰类:抽象类
 * 	> 此类不能实例化
 *  > 抽象类中一定有构造器，便于子类实例化时调用(涉及:子类对象实例化全过程)
 *  > 开发中，都会提供抽象类的子类，让子类对象实例化，实现相关的操作
 *
 * 4.abstract 修饰方法:抽象方法
 *  > 抽象方法，只有方法的声明，没有方法体。
 *  > 包含抽象方法的类，一定是一个抽象类。反之，抽象类中可以没有抽象方法
 *  > 若子类重写了父类中所有的抽象方法，此子类方可实例化
 *    若子类没有重写了父类中所有的抽象方法，此子类也是一个抽象类，需要使用abstract修饰
 *
 * abstract 使用上的注意点:
 * 1.abstract 不能用来修饰变量、代码块、构造器；
 * 2.abstract 不能用来修饰私有方法、静态方法、final 的方法、final 的类。
 */
public class AbstractTest {
    public static void main(String[] args) {

        //一旦 Person 类抽象了，就不可实例化
//		Person p1 = new Person();
//		p1.eat();

    }
}

abstract class Creature {
    public abstract void breath();
}

abstract class Person extends Creature {
    String name;
    int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //不是抽象方法
//	public void eat(){
//
//	}

    //抽象方法
    public abstract void eat();

    public void walk() {
        System.out.println("人走路");
    }
}

class Student extends Person {
    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }

    public void eat() {
        System.out.println("学生应该多吃有营养的。");
    }

    @Override
    public void breath() {
        System.out.println("学生应该呼吸新鲜的无雾霾空气");
    }
}

