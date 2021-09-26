package com.atguigu.java;

/**
 * @author：ZhouYao
 * @create：2021-09-20 18:01
 */

/*
 * 一、设计类、其实就是设计类的成员
 * Field = 属性 = 成员变量 = 域、字段
 * Method = (成员)方法 = 函数
 *
 * 创建类 = 类的实例化 = 实例化类
 *
 * 二.类和对象的使用(面向对象思想落地的实现)
 * 1.创建类，设计类的成员
 * 2.创建类的对象
 * 3.通过“对象.属性”或“对象.方法”调用对象的结构
 * 三、如果创建类一个类的多个对象，则每个对象都独立的拥有一套类的属性。(非 static 的)
 * 	  意味着:如果我们修改一个对象的属性 a，则不影响另外一个对象属性 a 的值。
 */

//测试类
public class PersonTest {
    public static void main(String[] args) {
        //2.创建 Person 类的对象
        //创建对象语法：类名对象名= new 类名();
        Person p1 = new Person();
        //Scanner scan = new Scanner(System.in);

        //调用类的结构：属性、方法
        //调用属性:“对象.属性”
        p1.name = "Tom";
        p1.age = 25;
        p1.isMale = true;
        System.out.println(p1.name);

        //调用方法:“对象.方法”
        p1.eat();
        p1.sleep();
        p1.talk("chinese");
        //**********************
        Person p2 = new Person();
        System.out.println(p2.name); //null
        System.out.println(p2.isMale);
        //**********************
        //将 p1 变量保存的对象地址值赋给 p3,导致 p1 和 p3 指向了堆空间中的一个对象实体。
        Person p3 = p1;
        System.out.println(p3.name);

        p3.age = 10;
        System.out.println(p1.age); //10
    }
}

/*
 * 类的语法格式：
 * 修饰符 class 类名{
 * 		属性声明;
 * 		方法声明;
 * }
 * 说明：修饰符 public：类可以被任意访问类的正文要用{  }括起来
 */
//1.创建类，设计类的成员
class Person {

    //属性:对应类中的成员变量
    String name;
    int age;
    boolean isMale;

    //方法:对应类中的成员方法
    public void eat() {
        System.out.println("吃饭");
    }

    public void sleep() {
        System.out.println("睡觉");
    }

    public void talk(String language) {
        System.out.println("人可以说话，使用的是：" + language);
    }
}

