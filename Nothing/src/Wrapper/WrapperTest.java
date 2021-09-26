package Wrapper;

import org.junit.Test;

/**
 * @author：ZhouYao
 * @create：2021-07-14 21:09
 */
public class WrapperTest {

    // String类型--->基本数据类型,包转类：调用包转类的parseXxx(String s)
    @Test
    public void test1() {
        String str1 = "123";

        int i = Integer.parseInt(str1);
        System.out.println(i);

        String str2 = "true111";
        boolean b = Boolean.parseBoolean(str2);
        System.out.println(b);
    }

    // 基本数据类型,包转类--->String类型:调用String重载的valueOf(Xxx xxx)
    @Test
    public void test2() {
        int i = 10;
        String s1 = String.valueOf(i);
        System.out.println(s1);
        String s2 = i + "";
        System.out.println(s2);
    }

    // 基本数据类型--->包装类
    @Test
    public void test3() {
        int num = 10;
        Integer integer = new Integer(num);
        System.out.println(integer.toString());
    }

    // 包装类--->基本数据类型：调用包转类Xxx的xxxValue()
    @Test
    public void test4() {
        Integer integer = new Integer(12);
        int i = integer.intValue();
        System.out.println(i);
    }

    @Test
    public void test5() {
        // 自动装箱:基本数据类型--->包装类
        int n = 10;
        Integer num1 = n;

        // 自动拆箱:包转类--->基本数据类型
        int num2 = num1;
    }


}
