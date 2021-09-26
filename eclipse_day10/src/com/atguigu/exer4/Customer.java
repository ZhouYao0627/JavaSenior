package com.atguigu.exer4;

/**
 * @author：ZhouYao
 * @create：2021-09-22 17:07
 */
public class Customer {

    private String firstName;
    private String lastName;
    private Account account;

    public Customer() {
    }

    public Customer(String f, String l) {
        this.firstName = f;
        this.lastName = l;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
