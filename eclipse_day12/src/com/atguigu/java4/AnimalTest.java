package com.atguigu.java4;

/**
 * @author：ZhouYao
 * @create：2021-09-24 9:52
 */

/*
 * 多态性应用举例
 */
public class AnimalTest {

    public static void main(String[] args) {
        AnimalTest test = new AnimalTest();
        test.func(new Dog());

        test.func(new Cat());
    }

    public void func(Animal animal) {    //Animal animal = new Dog();
        animal.eat();
        animal.shout();
    }

    //如果没有多态性，就会写很多如下的方法，去调用，增添了很多步骤
//    public void func(Dog dog) {
//        dog.eat();
//        dog.shout();
//    }
//    public void func(Cat cat) {
//        cat.eat();
//        cat.shout();
//    }
}


class Animal {

    public void eat() {
        System.out.println("动物，进食");
    }

    public void shout() {
        System.out.println("动物：叫");
    }
}


class Dog extends Animal {
    public void eat() {
        System.out.println("狗吃骨头");
    }

    public void shout() {
        System.out.println("汪！汪！汪！");
    }
}


class Cat extends Animal {
    public void eat() {
        System.out.println("猫吃鱼");
    }

    public void shout() {
        System.out.println("喵！喵！喵！");
    }
}

