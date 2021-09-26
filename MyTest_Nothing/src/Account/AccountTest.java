package Account;

/**
 * 银行有[一个账户]。
 * 有[两个储户]分别向同一个账户存3000元，每次存1000存3次 。每次存完打印账户[余额]。
 *
 * @author：ZhouYao
 * @create：2021-07-05 20:42
 */


class Account {

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double atm) {
        if (atm > 0) {

            balance += atm;

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

        Customer t1 = new Customer(acct);
        Customer t2 = new Customer(acct);

        t1.setName("甲");
        t2.setName("乙");

        t1.start();
        t2.start();


    }


}
