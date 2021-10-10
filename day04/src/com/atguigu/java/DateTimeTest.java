package com.atguigu.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk 8之前的日期时间的API测试
 * 1. System类中currentTimeMillis();  --->day03/DateTimeTest
 * 2. java.util.Date和子类java.sql.Date
 * 3. SimpleDateFormat
 * 4. Calendar
 *
 * @author：ZhouYao
 * @create：2021-07-11 22:10
 */
public class DateTimeTest {

    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作：
      1.1 格式化：日期 --->字符串    format
      1.2 解析：格式化的逆过程，字符串 ---> 日期    parse
    2.SimpleDateFormat的实例化
    */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        // 实例化SimpleDateFormat：使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        // 格式化：日期 --->字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        // 解析：格式化的逆过程，字符串 ---> 日期
        String str = "2021/7/11 下午10:18";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        //*************按照指定的方式格式化和解析：调用带参的构造器*****************
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 格式化
        String format1 = sdf1.format(date);
        System.out.println(format1); // 2021-07-11 10:34:20
        //解析:要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现),
        //否则，抛异常
        Date date2 = sdf1.parse("2021-07-11 10:34:20");
        System.out.println(date2);
    }

    /*
    练习一：字符串"2020-09-08"转换为java.sql.Date

    练习二："三天打渔两天晒网"   1990-01-01  xxxx-xx-xx 打渔？晒网？

    举例：2020-09-08 ？ 总天数

    总天数 % 5 == 1,2,3 : 打渔
    总天数 % 5 == 4,0 : 晒网

    总天数的计算？
    方式一：( date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1
    方式二：1990-01-01  --> 2019-12-31  +  2020-01-01 -->2020-09-08
     */

    @Test
    public void test1() throws ParseException {
        String birth = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = sdf.parse(birth);

        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate.toString());
    }

    /*
    Calendar日历类的使用 --->它是抽象类，不能直接实例化。需借助子类或调用其静态方法
     */

    @Test
    public void testCalendar() {
        // 1.实例化
        // 方式一：创建其子类的对象(GregorianCalendar)的对象
        // 方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass()); // class java.util.GregorianCalendar

        // 2.常用方法
        // get()
        System.out.println("*********get()***********");
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        // set()
        System.out.println("*********set()***********");
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        // add()
        System.out.println("*********add()***********");
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        // getTime()：日历类 ---> Date
        System.out.println("*********getTime()***********");
        Date date = calendar.getTime();
        System.out.println(date);

        // setTime()：Date ---> 日历类
        System.out.println("*********setTime()***********");
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

    }
}
