package com.atguigu.exer4;

/**
 * @author：ZhouYao
 * @create：2021-09-22 17:07
 */
public class Account {

    private double balance;

    public Account() {
    }

    public Account(double inti_balance) {
        this.balance = inti_balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        balance += amt;
    }

    public void withdraw(double amt) {
        if (amt > balance)
            System.out.println("余额不足，取款失败！");
        else
            balance -= amt;


    }

}
