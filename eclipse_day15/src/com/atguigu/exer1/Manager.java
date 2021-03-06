package com.atguigu.exer1;

/**
 * @author：ZhouYao
 * @create：2021-09-26 21:43
 */

/*
 * 对于 Manager 类来说，他既是员工，还具有奖金(bonus)的属性。
 *
 */
public class Manager extends Employee {

    private double bonus;    //奖金

    public Manager(double bonus) {
        super();
        this.bonus = bonus;
    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }


    @Override
    public void work() {
        System.out.println("管理员工，提高公司运行效率。");
    }
}

