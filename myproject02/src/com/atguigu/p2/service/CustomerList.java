package com.atguigu.p2.service;

import com.atguigu.p2.bean.Customer;

/**
 * @author：ZhouYao
 * @create：2021-09-22 21:39
 */

/**
 * @version:
 * @Title: CustomerList
 * @Description:CustomerList为Customer对象的管理模块， 内部用数组管理一组Customer对象，并提供相应的添加、修改、删除和遍历方法，
 * 供CustomerView调用
 * @author: zhouyao
 * @date: 2021年6月24日 下午4:30:41
 */
public class CustomerList {

    Customer[] customers;// 用来保存客户对象的数组
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
            for (int i = index; i < total - 1; i++) { // 画个图就清晰了
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

