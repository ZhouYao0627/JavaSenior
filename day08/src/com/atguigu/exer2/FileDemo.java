package com.atguigu.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author：ZhouYao
 * @create：2021-07-18 16:09
 */
public class FileDemo {

    /*1.
    利用 File 构造器，new一个文件目录 file
    1)在其中创建多个文件和目录
    2)编写方法，实现删除 file 中指定文件的操作
    */
    @Test
    public void test1() throws IOException {

        File file = new File("D:\\io\\io1\\hello.txt");
        // 创建一个与file同目录下的另外一个文件，文件名为：haha.txt

        File destFile  = new File(file.getParent(), "haha.txt");
        boolean newFile = destFile.createNewFile();
        if (newFile){
            System.out.println("创建成功");
        }

    }





}
