package com.atguigu.exer;

/**
 * 银行有[一个账户]。
 * 有[两个储户]分别向同一个账户存3000元，每次存1000存3次 。每次存完打印账户[余额]。
 *
 * 分析：
 * 1.是否是多线程问题？ 是，两个储户线程
 * 2.是否有共享数据？ 有，账户(或账户余额)
 * 3.是否有线程安全问题？ 有
 * 4.需要考虑如何解决线程安全问题？ 同步机制：有三种方式
 *
 * @author：ZhouYao
 * @create：2021-07-05 16:51
 */

class Account {

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    // 存钱
    public synchronized void deposit(double amt) { // 这里使用synchronized没有问题的原因是下方只创建了一个acct，即多个线程共用了一个this
        if (amt > 0) {
            balance += amt;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":存钱成功，余额为：" + balance);
        }
    }

}

class Customer extends Thread {
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {

        Account acct = new Account(0);

        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();

        // 下方是我将extends Thread改为implements Runnable，不知是否正确
//        Account acct = new Account(0);
//
//        Customer c = new Customer(acct);
//
//        Thread thread1 = new Thread(c);
//        Thread thread2 = new Thread(c);
//
//        thread1.setName("甲");
//        thread2.setName("乙");
//
//        thread1.start();
//        thread2.start();
    }

}
