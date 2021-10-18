package test;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 @author：ZhouYao
 @create：2021-10-18 16:11
 */
public class FileInputOutputStreamTest1 {

    @Test
    public void test() {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // 1.
            File srcFile = new File("子枫.jpg");
            File destFile = new File("子枫1.jpg");

            // 2.
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            // 3.
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
