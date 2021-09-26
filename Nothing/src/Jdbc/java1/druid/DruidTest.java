package Jdbc.java1.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
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

        source.setUsername("root");
        source.setPassword("123456");
        source.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8");
        source.setDriverClassName("com.mysql.jdbc.Driver");

        source.getConnection();
    }

    @Test
    public void test2() throws Exception {

        Properties pros = new Properties();

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("");
        pros.load(is);

        DataSource dataSource = DruidDataSourceFactory.createDataSource(pros);
        dataSource.getConnection();
    }



}
