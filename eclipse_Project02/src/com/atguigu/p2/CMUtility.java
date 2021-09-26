package com.atguigu.p2;

import java.util.Scanner;

/**
 * CMUtility工具类： 将不同的功能封装为方法，就是可以直接通过调用方法使用它的功能，而无需考虑具体的功能实现细节。
 */
public class CMUtility {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 用于界面菜单的选择。该方法读取键盘，如果用户键入’1’-’5’中的任意字符，则方法返回。返回值为用户键入字符。
     */
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0); // charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。
            if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5') {
                System.out.print("选择错误，请重新输入：");
            } else
                break;
        }
        return c;
    }

    /**
     * 从键盘读取一个字符，并将其作为方法的返回值。 //如性别男或女
     */
    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    /**
     * 从键盘读取一个字符，并将其作为方法的返回值。 如果用户不输入字符而直接回车，方法将以defaultValue作为返回值。 //修改性别
     */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    /**
     * 从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值。 //年龄
     */
    public static int readInt() {
        int n;
        for (; ; ) { // 这里采用循环是因为用户不一定输入的就是两位数，可能有误
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str); // String类型--->基本数据类型,包转类：调用包装类的parseXxx(String s)
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * 从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值。 如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值。 //修改年龄
     */
    public static int readInt(int defaultValue) {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, true);
            if (str.equals("")) {
                return defaultValue;
            }

            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * 从键盘读取一个长度不超过limit的字符串，并将其作为方法的返回值。 //姓名 电话 邮箱
     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /**
     * 从键盘读取一个长度不超过limit的字符串，并将其作为方法的返回值。 如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值。
     * //修改姓名 电话 邮箱
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("") ? defaultValue : str;
    }

    /**
     * 用于确认选择的输入。该方法从键盘读取‘Y’或’N’，并将其作为方法的返回值。 //判断是否真的要退出或删除
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase(); // toUpperCase()方法用于把字符串转换为大写。
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }

    /**
     * 私有方法 从键盘获取值
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) { // 看是否有输入
            line = scanner.nextLine();
            if (line.length() == 0) { // 输入的长度为0
                if (blankReturn) // 需要修改的话：blankReturn为true
                    return line; // 这里length为0返回的原因是在调用它时，length为0便可以使用defaultValue了
                else
                    continue;
            }

            if (line.length() < 1 || line.length() > limit) { // 即输入不能为空且输入不能大于limit
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }

        return line;
    }
}