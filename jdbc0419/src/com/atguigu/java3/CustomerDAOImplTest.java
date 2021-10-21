package com.atguigu.java3;

import com.atguigu.java1.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * 对Customer的测试
 *
 * @author：ZhouYao
 * @create：2021-08-04 16:05
 */
public class CustomerDAOImplTest {

    @Test
    public void testGetAll() {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            CustomerDAOImpl imp1 = new CustomerDAOImpl();
            List<Customer> list = imp1.getAll(connection);

//            for (Customer customer : list)
//                System.out.println(customer); // 省略了toString也可以
            list.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
    }

    // 下面为自己测试
    @Test
    public void testAddCustomer() {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            CustomerDAOImpl imp = new CustomerDAOImpl(); // 下方用了不带id的构造器，因为mysql中的id是自增长的
            int count = imp.addCustomer(connection, new Customer("尹楠", "1242456@123.com", new Date(39911L)));
            System.out.println("增加了" + count + "条数据");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
    }

    @Test
    public void testUpdateCustomer() {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            CustomerDAOImpl imp = new CustomerDAOImpl();
            int count = imp.updateCustomer(connection, new Customer(25, "周耀", "1007@qq.com", new Date(231312121L)));
            System.out.println("修改了" + count + "条数据");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }

    }

    @Test
    public void testGetCustomer() {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            CustomerDAOImpl imp = new CustomerDAOImpl();
            Customer customer = imp.getCustomer(connection, 25);
            System.out.println(customer); // 未写toString也可以
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }

    }

    @Test
    public void testGetCount() {

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            CustomerDAOImpl imp = new CustomerDAOImpl();
            long count = imp.getCount(connection);
            System.out.println("一共有" + count + "条数据");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }

    }

    @Test
    public void testGetMaxBirth() {

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            CustomerDAOImpl imp = new CustomerDAOImpl();
            Date birth = imp.getMaxBirth(connection);
            System.out.println(birth);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }

    }

    @Test
    public void testDeleteById() {

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            CustomerDAOImpl imp = new CustomerDAOImpl();
            int count = imp.deleteById(connection, 27);
            System.out.println("删除了" + count + "条数据");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }

    }


}






