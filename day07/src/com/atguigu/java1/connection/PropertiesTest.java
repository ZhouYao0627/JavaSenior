package com.atguigu.java1.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author：ZhouYao
 * @create：2021-07-17 10:52
 */
public class PropertiesTest {

    //Properties:常用来处理配置文件。key和value都是String类型
    public static void main(String[] args) {

        FileInputStream fis = null;
        try {
            Properties pros = new Properties();

            fis = new FileInputStream("jdbc.properties");
            pros.load(fis); // 加载流对应文件

            String name = pros.getProperty("name"); // 因为我的jdbc.properties文件没有删掉重新造，所以还是乱码
            String password = pros.getProperty("password");

            System.out.println("name = " + name + ", password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
