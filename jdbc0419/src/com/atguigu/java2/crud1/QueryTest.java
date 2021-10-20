package com.atguigu.java2.crud1;

import com.atguigu.java1.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author：ZhouYao
 * @create：2021-08-04 15:28
 */
public class QueryTest {

    /*
     * 查询order表中的一条记录，返回Order类的一个对象
     *
     * 关键是解决字段名与属性名不一致的情况
     */
    @Test
    public void test1() throws Exception {
        Connection connection = JDBCUtils.getConnection();

        String sql = "SELECT order_id orderId,order_name orderName,order_date orderDate FROM `order` WHERE order_id = ?";

        BeanHandler<Order> handler = new BeanHandler<>(Order.class);

        QueryRunner runner = new QueryRunner();
        Order order = runner.query(connection, sql, handler, 1);

        System.out.println(order);
    }


}












