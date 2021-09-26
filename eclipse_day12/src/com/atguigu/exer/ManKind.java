package com.atguigu.exer;

/**
 * @author：ZhouYao
 * @create：2021-09-22 18:41
 */
public class ManKind {

    private int sex;
    private int salary;

    public void manOrWoman() {
        if (sex == 1)
            System.out.println("man");
        else if (sex == 0)
            System.out.println("woman");
    }

    public void employee() {
        String s = salary == 0 ? "no job" : "job";
        System.out.println(s);
    }

    public ManKind() {
    }

    public ManKind(int sex, int salary) {
        this.sex = sex;
        this.salary = salary;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


}
