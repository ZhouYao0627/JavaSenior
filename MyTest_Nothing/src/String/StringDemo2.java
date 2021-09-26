package String;

import org.junit.Test;

/**
 * @author：ZhouYao
 * @create：2021-07-13 11:04
 */
public class StringDemo2 {
    // 1.模拟一个trim方法，去除字符串两端的空格
    public String myTrim(String str) {

        if (str != null) {
            int start = 0;
            int end = str.length() - 1;

            while (str.charAt(start) == ' ') {
                start++;
            }

            while (str.charAt(end) == ' ') {
                end--;
            }

            if (str.charAt(start) == ' ') {
                return "";
            }

            return str.substring(start, end + 1);
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
            char[] chars = str.toCharArray();

            for (int i = start, j = end; i < j; i++, j--) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }

            return new String(chars);

        }
        return null;
    }

    // 方式二：使用String的拼接操作
    public String reverse2(String str, int start, int end) {
        String newStr;
        if (str != null) {
            newStr = str.substring(0, start); // ab
            for (int i = end; i >= start; i--) {
                newStr += str.charAt(i); // abfedc
            }
            newStr += str.charAt(end + 1);
            return newStr;
        }
        return null;
    }

    // 方式三：利用StringBuffer/StringBuilder替换String
    public String reverse3(String str, int start, int end) {
        if (str != null) {
            StringBuffer s = new StringBuffer(str.length());
            s.append(str.substring(0, start)); // ab

            for (int i = end; i >= start; i--) {
                s.append(str.charAt(i)); // abfedc
            }

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
