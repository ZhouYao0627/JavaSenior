package com.atguigu.exer3;

/**
 * @author：ZhouYao
 * @create：2021-09-22 16:40
 */
public class Account {

    private int id; // 账号
    private double balance; // 余额
    private double annualInterestRate; // 年利率

    // 取钱
    public void withdraw(double amount) {
        if (amount > balance)
            System.out.println("抱歉，您的余额不足！取款失败！");
        else {
            balance -= amount;
            System.out.println("成功取出：" + amount);
        }
//        System.out.println("当前余额为：" + balance);
    }

    // 存钱
    public void deposit(double amount) {
        balance += amount;
        System.out.println("成功存入:" + amount);

//        System.out.println("当前余额为：" + balance);
    }

    public Account() {
    }

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", annualInterestRate=" + annualInterestRate +
                '}';
    }
}
