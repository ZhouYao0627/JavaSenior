package LeetCode;

/**
 * @author：ZhouYao
 * @create：2021-07-27 11:20
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

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[len - 1] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] arr = new int[len + 1];
        arr[0] = 1;

        return arr;
    }


}
