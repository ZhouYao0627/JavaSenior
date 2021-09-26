package File;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author：ZhouYao
 * @create：2021-07-19 9:39
 */
public class FindJPGFileTest1 {

    //    课后练习2：判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
    // 三种方法

    @Test
    public void test1() {

        File file1 = new File("D:\\io\\io1");
        String[] list = file1.list();

        for (String filename : list) {
            if (filename.endsWith(".jpg")) {
                System.out.println(filename);
            }
        }
    }

    @Test
    public void test2() {

        File file = new File("D:\\io\\io1");
        File[] listFiles = file.listFiles();
        for (File filename : listFiles) {
            if (filename.getName().endsWith(".jpg")) {
                System.out.println(filename.getAbsolutePath());
            }
        }
    }

    @Test
    public void test3() {
        File srcFile = new File("d:\\code");
        File[] SubFiles = srcFile.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".jpg");
            }
        });

        for (File file : SubFiles) {
            System.out.println(file.getAbsolutePath());
        }
    }


}
