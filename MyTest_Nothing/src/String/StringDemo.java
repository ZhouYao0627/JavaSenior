package String;

import org.junit.Test;

/**
 * @author：ZhouYao
 * @create：2021-07-11 17:56
 */
public class StringDemo {

    // 1.模拟一个trim方法，去除字符串两端的空格
    public String myTrim(String str) {
        if (str != null) {
            int start = 0; // 用于记录从前往后首次索引位置不是空格的位置的索引
            int end = str.length() - 1; // 用于记录从后往前首次索引位置不是空格的位置的索引

            while (start < end && str.charAt(start) == ' ') {
                start++;
            }

            while (start < end && str.charAt(end) == ' ') {
                end--;
            }

            if (str.charAt(start) == ' ') { // 循环结束后，索引位置还是空格，就说明是空串
                return "";
            }

            return str.substring(start, end + 1); // 左闭右开

        }
        return null;
    }

    @Test
    public void testMyTrim() {
        String str = "  123  ";
        System.out.println(myTrim(str));
    }

    // 2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
    // 方式一：转换为char[]
    public String reverse1(String str, int start, int end) {
        if (str != null) {
            char[] charArray = str.toCharArray(); // String --> char[]:调用String的toCharArray()
            for (int i = start, j = end; i < j; i++, j--) {
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
            }
            return new String(charArray); // char[] --> String:调用String的构造器
        }
        return null;
    }

    // 方式二：使用String的拼接操作
    public String reverse2(String str, int start, int end) {
        if (str != null) {
            // 1.
            String newStr = str.substring(0, start); // ab
            // 2.
            for (int i = end; i >= start; i--) {
                newStr += str.charAt(i); // abfedc
            }
            // 3.
//        newStr += str.charAt(end + 1);
            newStr += str.substring(end + 1); // abfedcg
            return newStr;
        }
        return null;
    }

    // 方式三：利用StringBuffer/StringBuilder替换String
    public String reverse3(String str, int start, int end) {
        if (str != null) {
            StringBuffer s = new StringBuffer(str.length());
            // 1.
            s.append(str.substring(0, start));
            // 2.
            for (int i = end; i >= start; i--) {
                s.append(str.charAt(i));
            }
            // 3.
            s.append(str.substring(end + 1));

            return s.toString();
        }
        return null;
    }

    @Test
    public void testReverse() {
        String str = "abcdefg";
        System.out.println(reverse3(str, 2, 5));
    }

}
