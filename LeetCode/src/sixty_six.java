import java.util.Arrays;

/**
 * @author：ZhouYao
 * @create：2021-07-26 21:14
 */
public class sixty_six {
    /*
    Given a non-empty array of decimal digits representing a non-negative integer,
    increment one to the integer.

    The digits are stored such that the most significant digit is at the head of the list,
    and each element in the array contains a single digit.

    You may assume the integer does not contain any leading zero, except the number 0 itself.
    */

//    Input: digits = [1,2,3]
//    Output: [1,2,4]

//    Input: digits = [4,3,2,1]
//    Output: [4,3,2,2]

//    Input: digits = [0]
//    Output: [1]

    public int[] plusOne2(int[] digits) {

        int n = digits.length;
//      从最后一位进行判断，看是否小于9，若小于则直接加一，并返回数组
//                                   若大于9，则将此位置修改为0，并在下方增添数组位数
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // 只有在数组为[9]，[99]之类时，会需要增添位数
        // 假设数组仅为一位，如[9]，那么经过上方后数组变为了[0]，因此需增添一位，再将新添的位置修改为1
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }

    // 本题考查的应当是数组转换为数字，再由数字转换为数组--->未做出来
    public int[] plusOne1(int[] digits) {
        String str1 = Arrays.toString(digits);

        int i = Integer.parseInt(str1);
        i += 1;

        String str2 = i + "";
        int[] arr = new int[str2.length()];

        return arr;
    }

    // 错误，未解决进位的问题
//    public int[] plusOne(int[] digits) {
//
//        // 若数组中只有一个元素，则直接在现有元素上加一
//        if (digits.length == 1) {
//            digits[0] += 1;
//            return digits;
//        }
//
//        // 若数组的元素不止一位，则在最后一位上加一
//        digits[digits.length - 1] += 1;
//        return digits;
//    }


}
