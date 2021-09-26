package com.atguigu.exer2;

/**
 * @author：ZhouYao
 * @create：2021-09-24 8:52
 */
public class CheckAccount extends Account {

    private double overdraft; // 可透支限额

    public CheckAccount(double overdraft) {
        this.overdraft = overdraft;
    }

    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }

    // 重写取款方法
    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        if (getBalance() >= amount) {
            // 错误方式：getBalance() -= amount; ---> 这是一个赋值的过程，这是set的工作
            //方式一：
//            setBalance(getBalance() - amount);
            // 方式二：
            super.withdraw(amount);
        } else if (overdraft >= amount - getBalance()) {    //透支额度+余额 足够消费
            overdraft -= (amount - getBalance());
//			setBalance(0);
            //或
            super.withdraw(getBalance());
        } else {    //超过可透支限额
            System.out.println("超过可透支限额！");
        }
    }


}
