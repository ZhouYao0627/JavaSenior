package File;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author：ZhouYao
 * @create：2021-07-19 9:39
 */
public class FileDemo1 {

     /*1.
    利用 File 构造器，new一个文件目录 file
    1)在其中创建多个文件和目录
    2)编写方法，实现删除 file 中指定文件的操作
    */

    @Test
    public void test1() throws IOException {

        File file1 = new File("D:\\io\\io1\\hello.txt");

        File destFile = new File(file1.getParent(), "haha.txt");

        boolean newFile = destFile.createNewFile();
        if (newFile){
            System.out.println("创建成功");
        }


    }




}
