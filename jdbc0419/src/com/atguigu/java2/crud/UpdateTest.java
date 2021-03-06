package com.atguigu.java2.crud;

import com.atguigu.java1.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;

/**
 * 测试向数据表中添加、删除、修改数据
 *
 * 步骤：
 * 1.获取数据库的连接
 * 2.提供一个包含占位符的sql
 * 3.使用提供好的QueryRunner，调用update()方法，实现数据的插入
 * 4.资源的关闭
 *
 * @author：ZhouYao
 * @create：2021-08-04 10:23
 */
public class UpdateTest {

    // 向数据表中添加一条数据 （不推荐，推荐使用下方的那种）
    @Test
    public void test1() {
        Connection connection = null;

        try {
            // 1.先获取数据库的连接
            connection = JDBCUtils.getConnection();

            // 2.提供一个添加操作的sql
            String sql = "insert into customers(name,email,birth) values('王海','tom@126.com','2020-09-08')";

            // 3.使用提供好的QueryRunner，调用update()方法，实现数据的插入
            QueryRunner runner = new QueryRunner();
            int count = runner.update(connection, sql);
            System.out.println("添加了" + count + "条记录");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4.资源的关闭
            JDBCUtils.close(connection);
        }
    }

    // 使用带占位符的sql （推荐） ★★★
    @Test
    public void test2() {
        Connection connection = null;

        try {
            // 1.先获取数据库的连接
            connection = JDBCUtils.getConnection();

            // 2.提供一个添包含占位符的sql
            String sql = "insert into customers(name,email,birth) values(?,?,?)";

            // 3.使用提供好的QueryRunner，调用update()方法，实现数据的插入
            QueryRunner runner = new QueryRunner();

            int count = runner.update(connection, sql, "王亮", "wangl@126.com", new Date(23423423432423L)); // 这里传入的是毫秒数
            System.out.println("添加了" + count + "条记录");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4.资源的关闭
            JDBCUtils.close(connection);
        }
    }

    // 删除记录的操作
    @Test
    public void test3() {
        Connection connection = null;

        try {
            // 1.先获取数据库的连接
            connection = JDBCUtils.getConnection();

            // 2.提供一个添包含占位符的sql
            String sql = "delete from customers where id > ?";

            // 3.使用提供好的QueryRunner，调用update()方法，实现数据的插入
            QueryRunner runner = new QueryRunner();
            int count = runner.update(connection, sql, 19);
            System.out.println("删除了" + count + "条记录");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4.资源的关闭
            JDBCUtils.close(connection);
        }
    }

    // 修改表数据的操作
    @Test
    public void test4() {
        Connection connection = null;

        try {
            // 1.先获取数据库的连接
            connection = JDBCUtils.getConnection();

            // 2.提供一个添包含占位符的sql
            String sql = "update customers set email = ? where id = ?";

            // 3.使用提供好的QueryRunner，调用update()方法，实现数据的插入
            QueryRunner runner = new QueryRunner();
            int count = runner.update(connection, sql, "tom@gmail.com", 19);
            System.out.println("修改了" + count + "条记录");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4.资源的关闭
            JDBCUtils.close(connection);
        }
    }


}












