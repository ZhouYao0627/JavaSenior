package test;

import org.junit.Test;

import java.io.*;

/**
 @author：ZhouYao
 @create：2021-10-18 18:41
 */
public class PicTest1 {

    @Test
    public void test() {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream("子枫.jpg"));
            bos = new BufferedOutputStream(new FileOutputStream("子枫secret.jpg"));

            byte[] buffer = new byte[20];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test1() {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream("子枫secret.jpg"));
            bos = new BufferedOutputStream(new FileOutputStream("子枫secret2.jpg"));

            byte[] buffer = new byte[20];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
