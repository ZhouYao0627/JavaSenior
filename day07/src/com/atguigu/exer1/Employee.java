package com.atguigu.exer1;

/**
 * @author：ZhouYao
 * @create：2021-07-16 15:07
 */
public class Employee implements Comparable {

     /*
    定义一个 Employee 类。该类包含：private 成员变量 name,age,birthday ，
    其中 birthday 为MyDate 类的对象；并为每一个属性定义getter, setter 方法；
    并重写toString 方法输出 name, age, birthday
    */

    private String name;
    private int age;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }


    // 使 Employee 实现 Comparable 接口，并按 name 排序
    @Override
    public int compareTo(Object o) {

        if (o instanceof Employee) {
            Employee e = (Employee) o;
            return this.name.compareTo(e.name);
        } else {
            throw new RuntimeException("输入的类型不匹配");
        }

    }

}
