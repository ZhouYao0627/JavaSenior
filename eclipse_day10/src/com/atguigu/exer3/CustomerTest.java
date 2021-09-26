package com.atguigu.exer3;

/**
 * @author：ZhouYao
 * @create：2021-09-22 16:48
 */
public class CustomerTest {

    public static void main(String[] args) {

        Customer cust = new Customer("Smith", "Jane");

        Account acct = new Account(1000, 2000, 0.0123);

        cust.setAccount(acct);

        cust.getAccount().deposit(100);
        cust.getAccount().withdraw(960);
        cust.getAccount().withdraw(2000);

        System.out.println(cust);


    }


}
