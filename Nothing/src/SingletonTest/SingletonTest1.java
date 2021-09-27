package SingletonTest;

/**
 * 饿汉式
 *
 * @author：ZhouYao
 * @create：2021-07-07 21:31
 */
class Bank {

    private Bank() {

    }

    private static Bank instance = new Bank();

    public static Bank getInstance() {
        return instance;
    }
}

public class SingletonTest1 {

    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();

        System.out.println(bank1 == bank2);


    }

}