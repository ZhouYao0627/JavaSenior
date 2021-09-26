package Jdbc.java1.connection;

import org.junit.Test;

import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author：ZhouYao
 * @create：2021-08-04 9:22
 */
public class ConnectionTest {

//    @Test
//    public void test1() throws Exception {
//
//        Driver driver = new com.mysql.jdbc.Driver();
//
//        // 注册
//        DriverManager.registerDriver(driver);
//
//        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
//        String user = "root";
//        String passsword = "123456";
//
//        // 连接
//        DriverManager.getConnection(url,user,passsword);
//
//
//    }

//    @Test
//    public void test2() throws Exception {
//
//        String className = "com.mysql.jdbc.Driver";
//        Class clazz = Class.forName(className);
//
//        Driver driver = (Driver) clazz.newInstance();
//
//        // 注册驱动
//        DriverManager.registerDriver(driver);
//
//        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
//        String user = "root";
//        String password = "123456";
//
//
//        // 获取连接
//        Connection connection = DriverManager.getConnection(url, user, password);
//        System.out.println(connection);
//    }


//    @Test
//    public void test3() throws Exception {
//
//        String className = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
//        String user = "root";
//        String password = "123456";
//
//        // 加载驱动
//        Class.forName(className);
//
//
//        // 获取连接
//        Connection connection = DriverManager.getConnection(url, user, password);
//        System.out.println(connection);
//    }

    @Test
    public void test4() throws Exception {

        Properties pros = new Properties();

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("");
        pros.load(is);

        String className = pros.getProperty("");
        String url = pros.getProperty("");
        String user = pros.getProperty("");
        String password = pros.getProperty("");

        // 加载驱动
        Class.forName(className);

        // 建立连接
        DriverManager.getConnection(url,user,password);
    }





}










