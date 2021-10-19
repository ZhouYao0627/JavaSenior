package Jdbc.java1.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author：ZhouYao
 * @create：2021-08-05 10:40
 */
public class DruidTest {

    @Test
    public void test1() throws SQLException {

        DruidDataSource source = new DruidDataSource();

        source.setUsername("");
        source.setPassword("");
        source.setUrl("");
        source.setDriverClassName("");

        Connection connection = source.getConnection();
        System.out.println(connection);
    }

    @Test
    public void test2() throws Exception {

        Properties pros = new Properties();

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("");
        pros.load(is);

        DataSource dataSource = DruidDataSourceFactory.createDataSource(pros);
        System.out.println(dataSource.getConnection());
    }


}
