package com.atguigu.exer2;

/**
 * @author：ZhouYao
 * @create：2021-09-24 8:51
 */
public class Account {

    private int id; // 账号
    private double balance; // 余额
    private double annualInterestRate; // 年利率

    // 返回月利率
    public double getMonthlyInterest() {
        return annualInterestRate / 12;
    }

    // 取款
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("您取了" + amount + "元，您的余额为" + balance + "元");
        } else {
            System.out.println("您的余额不足" + "，您的余额为" + balance + "元");
        }
    }

    // 存款
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("您存了" + amount + "元，您的余额为" + balance + "元");
        } else {
            System.out.println("您未存款，请再次尝试");
        }

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

    public static void main(String[] args) {
        Account account = new Account(1122, 20000, 0.045);
        account.withdraw(30000);
        account.withdraw(2500);
        account.deposit(3000);
        System.out.println("月利率为：" + account.getMonthlyInterest());


    }

}
