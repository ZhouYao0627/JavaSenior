package com.atguigu.exer1;

/**
 * @author：ZhouYao
 * @create：2021-09-26 21:44
 */

/*
 * 请使用继承的思想，设计 CommonEmployee 类和 Manager 类，
 */
public class EmployeeTest {
    public static void main(String[] args) {

        Employee manager = new Manager("库克", 1001, 5000, 50000);

        manager.work();

        CommonEmployee commonEmployee = new CommonEmployee();
        commonEmployee.work();
    }
}

