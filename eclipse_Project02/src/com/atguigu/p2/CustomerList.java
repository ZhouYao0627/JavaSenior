package com.atguigu.p2;

/**
 * @author：ZhouYao
 * @create：2021-09-23 16:51
 */
public class CustomerList {
    private Customer[] customers; // 用来保存客户对象的数组
    int total = 0; // 记录已保存客户对象的数量

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
            for (int i = index; i < total - 1; i++) {
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
        if (index < 0 || index >= total)
            return null;
        else
            return customers[index];
    }

    public int getTotal() {
        return total;
    }


}
