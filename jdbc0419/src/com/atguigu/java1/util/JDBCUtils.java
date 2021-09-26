package com.atguigu.java1.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 提供JDBC的工具类，用于获取数据库的连接等操作
 *
 * @author：ZhouYao
 * @create：2021-08-03 22:22
 */
public class JDBCUtils {

    /**
     * 获取数据库连接的方法
     *
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        // 通过数据源获取连接
        Connection connection = dataSource.getConnection();
        return connection;
    }

    private static DataSource dataSource;

    static {
        try {
            // 提供Properties，并加载指定配置文件的流
            Properties pros = new Properties();

            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            pros.load(is);

            // 通过DruidDataSourceFactory创建一个数据源
            // 由于静态代码块只执行一次，所以我们自始至终就创建过一个DataSource
            dataSource = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接
     *
     * @param connection
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


}
