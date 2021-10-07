import java.util.concurrent.locks.ReentrantLock;

/**
 @author：ZhouYao
 @create：2021-10-07 20:17
 */
public class AccountTest {

    public static void main(String[] args) {

        Account acct = new Account(0);

        Customer c = new Customer(acct);

        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);

        t1.start();
        t2.start();
    }

}

class Account {

    private double balance;

    private ReentrantLock lock = new ReentrantLock();

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amt) {
        try {
            lock.lock();

            if (amt > 0) {
                balance += amt;
                System.out.println(Thread.currentThread().getName() + "存入" + amt + "元," + "余额为：" + balance);
            }
        } finally {
            lock.unlock();
        }
    }
}

class Customer implements Runnable {

    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }
}



