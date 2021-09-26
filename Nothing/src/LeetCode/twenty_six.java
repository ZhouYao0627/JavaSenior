package LeetCode;

/**
 * @author：ZhouYao
 * @create：2021-07-23 23:09
 */
public class twenty_six {

    /*给你一个有序数组nums，请你原地删除重复出现的元素，
    使每个元素只出现一次 ，返回删除后数组的新长度。
    不要使用额外的数组空间，
    你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
    */

    //    Input: nums = [0,0,1,1,1,2,2,3,3,4]
//    Output: 5, nums = [0,1,2,3,4]
    public int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }


//    public int removeDuplicates(int[] nums) {
//        int pos = 0;
//        for (int num : nums) {
//            if (nums[pos] != num) {
//                System.out.println("nums[pos]：" + nums[pos] + ",pos: " + pos);
//                System.out.println("num：" + num);
//                nums[++pos] = num;
//            }
//        }
//        return pos + 1;
//    }
//
//    public static void main(String[] args) {
//
//        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//
//        twenty_six o = new twenty_six();
//        int i = o.removeDuplicates(nums);
//        System.out.println(i);
//
//    }


}
//        nums[pos]：1,pos: 0
//        num：2
//        2

//        nums[pos]：0,pos:0
//        num：1
//        nums[pos]：1,pos:1
//        num：2
//        nums[pos]：2,pos:2
//        num：3
//        nums[pos]：3,pos:3
//        num：4
//        5