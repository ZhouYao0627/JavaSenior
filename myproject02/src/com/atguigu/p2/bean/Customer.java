package com.atguigu.p2.bean;

/**
 * @author��ZhouYao
 * @create��2021-09-22 21:39
 */

public class Customer {

    private String name; // �ͻ�����
    private char gender; // �Ա�
    private int age; // ����
    private String phone; // �绰����
    private String email; // ��������

    public Customer() {
        super();
    }

    public Customer(String name, char gender, int age, String phone, String email) {
        super();
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

