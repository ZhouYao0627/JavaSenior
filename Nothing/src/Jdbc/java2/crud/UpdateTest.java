package Jdbc.java2.crud;

import Jdbc.java1.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author：ZhouYao
 * @create：2021-08-05 11:12
 */
public class UpdateTest {

    // 向数据表中添加一条数据 （不推荐，推荐使用下方的那种）
    @Test
    public void test1() throws Exception {

        Connection connection = JDBCUtils.getConnection();

        String sql = "insert into customers(name,email,birth) values('ww','ww@126.com','1010-02-03') ";

        QueryRunner runner = new QueryRunner();
        runner.update(connection, sql);

        JDBCUtils.close(connection);
    }

    // 使用带占位符的sql （推荐） ★
    @Test
    public void test2() {

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "insert into customers(name,email,birth) values(?,?,?) ";

            QueryRunner runner = new QueryRunner();
            runner.update(connection, sql, "ww", "ww@126.com", "2002-10-22");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }

    }

    // 删除记录的操作
    @Test
    public void test3() {

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "delete from customers where id > ?";

            QueryRunner runner = new QueryRunner();
            runner.update(connection, sql, 1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }

    }

    // 修改表数据的操作
    @Test
    public void test4() {

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "update customers set email = ? where id = ?";

            QueryRunner runner = new QueryRunner();
            runner.update(connection, sql, "ww@123.com", "1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }

    }


}
















