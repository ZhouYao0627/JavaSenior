package com.atguigu.exer2;

/**
 * @author：ZhouYao
 * @create：2021-09-22 16:19
 */
public class Girl {

    private String name;
    private int age;

    public void marry(Boy boy) {
        System.out.println("我想嫁给" + boy.getName());
        boy.marry(this);
    }

    /**
     * @param girl
     */
    public int compare(Girl girl) {
        return this.age - girl.age;
    }

    public Girl() {
    }

    public Girl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
