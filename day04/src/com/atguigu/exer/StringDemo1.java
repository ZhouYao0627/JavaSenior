package com.atguigu.exer;

import org.junit.Test;

/**
 * @author：ZhouYao
 * @create：2021-07-13 15:36
 */
public class StringDemo1 {
    // 第3题：判断str2在str1中出现的次数

    // 获取一个字符串在另一个字符串中出现的次数。
    //比如：获取“ ab 在 abkkcadkabkebfkabkskab ” 中 出现的次数
    public int getCount(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int index = 0;
        int count = 0;
        if (mainLength > subLength) {
            // 方式一：利用索引来做的
//            while ((index = mainStr.indexOf(subStr)) != -1) {
//                count++;
//                mainStr = mainStr.substring(index + subLength);
//            }
            // 方式二：对方式一的改进
            while ((index = mainStr.indexOf(subStr, index)) != -1) {
                count++;
                index += subLength;
            }
            return count;
        } else {

            return 0;
        }

    }

//    // 在网络上找到的方法
//    public int count(String str1, String str2) {
//        int count = 0;
//        if (str1.equals("") || str2.equals("")) {
//            System.out.println("你没有输入字符串或子串，无法比较！");
//            //System.exit(0);
//        } else {
//            for (int i = 0; i <= str1.length() - str2.length(); i++) {
//                if (str2.equals(str1.substring(i, str2.length() + i)))
//                    count++;
//            }
//        }
//        return count;
//    }

    @Test
    public void testCount() {
        String str1 = "abkkcadkabkebfkabkskab";
        String str2 = "ab";
        System.out.println(getCount(str1, str2));
    }


}
