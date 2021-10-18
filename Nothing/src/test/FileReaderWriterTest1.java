package test;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 @author：ZhouYao
 @create：2021-10-18 15:10
 */
public class FileReaderWriterTest1 {


    @Test
    public void test1() {
        FileReader fr = null;

        try {
            // 1.造文件
            File file = new File("hello.txt");

            // 2.造流
            fr = new FileReader(file);

            // 3.数据的读入
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            // 4.流的关闭
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        FileWriter fw = null;

        try {
            // 1.
            File file = new File("hello1.txt");

            // 2.
            fw = new FileWriter(file);

            // 3.
            fw.write("miao");
            fw.write("hello");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test3() {
        FileReader fr = null;
        FileWriter fw = null;

        try {
            // 1.
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");

            // 2.
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            // 3.
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            // 4.
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
