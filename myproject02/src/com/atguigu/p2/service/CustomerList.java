package com.atguigu.p2.service;

import com.atguigu.p2.bean.Customer;

/**
 * @author��ZhouYao
 * @create��2021-09-22 21:39
 */

/**
 * @version:
 * @Title: CustomerList
 * @Description:CustomerListΪCustomer����Ĺ���ģ�飬 �ڲ����������һ��Customer���󣬲��ṩ��Ӧ����ӡ��޸ġ�ɾ���ͱ���������
 * ��CustomerView����
 * @author: zhouyao
 * @date: 2021��6��24�� ����4:30:41
 */
public class CustomerList {

    Customer[] customers;// ��������ͻ����������
    int total = 0; // ��¼�ѱ���ͻ����������

    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    public boolean addCustomer(Customer customer) {
        if (total >= customers.length) {
            return false;
        } else {
            customers[total++] = customer;
            return true;
        }
    }

    public boolean replaceCustomer(int index, Customer cust) {
        if (index < 0 || index >= total) {
            return false;
        } else {
            customers[index] = cust;
            return true;
        }
    }

    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total) {
            return false;
        } else {
            for (int i = index; i < total - 1; i++) { // ����ͼ��������
                customers[i] = customers[i + 1];
            }
            customers[--total] = null;
            return true;
        }
    }

    public Customer[] getAllCustomers() {
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }

    public Customer getCustomer(int index) {
        if (index < 0 || index >= total) {
            return null;
        } else {
            return customers[index];
        }
    }

    public int getTotal() {
        return total;
    }

}

