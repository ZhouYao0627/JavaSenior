package Jdbc.java1.connection;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author：ZhouYao
 * @create：2021-08-04 9:22
 */
public class ConnectionTest {

    // 1.
    @Test
    public void test1() throws SQLException {

        java.sql.Driver driver = new com.mysql.jdbc.Driver();

        DriverManager.registerDriver(driver);

        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
        String user = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    @Test
    public void test2() throws Exception {

        String className = "";
        Class clazz = Class.forName(className);
        Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();

        DriverManager.registerDriver(driver);

        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
        String user = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    @Test
    public void test3() throws Exception {

        String className = "";
        Class.forName(className);

        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
        String user = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    @Test
    public void test4() throws Exception {

        Properties pros = new Properties();

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        pros.load(is);

        String className = pros.getProperty("className");
        String url = pros.getProperty("url");
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }


}










