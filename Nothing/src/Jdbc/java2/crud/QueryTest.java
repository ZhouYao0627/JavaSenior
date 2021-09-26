package Jdbc.java2.crud;

import Jdbc.java1.util.JDBCUtils;
import Jdbc.java2.bean.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * @author：ZhouYao
 * @create：2021-08-05 11:37
 */
public class QueryTest {

    /*
     * BeanHandler:对应查询表中的一条记录，以对象的方式返回
     */
    @Test
    public void test1() {

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "select name,email,birth from customers where id = ?";

            BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);

            QueryRunner runner = new QueryRunner();
            Customer customer = runner.query(connection, sql, handler, 1);
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }

    }

    /*
     * BeanListHandler:对应查询表中的多条记录，以对象构成的集合的方式返回
     */
    @Test
    public void test2() {

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "select name,email,birth from customers where id > ?";

            BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);

            QueryRunner runner = new QueryRunner();
            List<Customer> list = runner.query(connection, sql, handler, 1);

            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }

    }

    /*
     * MapHandler:对应查询表中的一条记录，以map对象的方式返回。
     * map中key为表中的字段名，map中value为表中一条数据的数据值。
     */
    @Test
    public void test3() {

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "select name,email,birth from customers where id = ?";

            MapHandler handler = new MapHandler();

            QueryRunner runner = new QueryRunner();
            Map<String, Object> map = runner.query(connection, sql, handler, 1);
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
    }

    /*
     * MapListHandler:对应查询表中的多条记录，以map对象构成的List的方式返回。
     * map中key为表中的字段名，map中value为表中一条数据的数据值。
     */
    @Test
    public void test4() {

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "select name,email,birth from customers where id > ?";


            MapListHandler handler = new MapListHandler();

            QueryRunner runner = new QueryRunner();
            List<Map<String, Object>> list = runner.query(connection, sql, handler, 1);

            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }

    }

    /*
     * ScalarHandler:用于查询表中的特殊值。比如：count(*) 、 max(xxx)
     */
    @Test
    public void test5() {

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "select count(*) from customers";

            ScalarHandler handler = new ScalarHandler();

            QueryRunner runner = new QueryRunner();
            long count = (long)runner.query(connection, sql, handler);

            System.out.println("查询到表中一共有" + count + "条记录");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
    }


}















