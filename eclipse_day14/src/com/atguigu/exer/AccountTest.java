package com.atguigu.exer;

/**
 * @author：ZhouYao
 * @create：2021-09-25 16:55
 */
public class AccountTest {

    public static void main(String[] args) {

        Account.setMinMoney(100);
        Account.setInterestRate(0.012);

        Account acct1 = new Account();
        Account acct2 = new Account("123456", 1000);

        System.out.println(acct1.getInterestRate());
        System.out.println(acct1.getMinMoney());
    }


}
