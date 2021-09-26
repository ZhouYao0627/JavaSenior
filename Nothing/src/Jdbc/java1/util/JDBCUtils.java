package Jdbc.java1.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author：ZhouYao
 * @create：2021-08-05 10:56
 */
public class JDBCUtils {

    @Test
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
            dataSource = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection connection) {

        try {
            if (connection != null)
                connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

}





















