package LeetCode;

import java.util.*;

/**
 * @author：ZhouYao
 * @create：2021-07-22 17:31
 */

public class fifteen {
    /*给你一个包含n个整数的数组nums，
    判断nums中是否存在三个元素a，b，c ，
    使得a+b+c=0？请你找出所有和为0且不重复的三元组。
    注意：答案中不可以包含重复的三元组。
    */

//    Input: nums = [-1,0,1,2,-1,-4]
//    Output: [[-1,-1,2],[-1,0,1]]

//    Input: nums = []
//    Output: []

//    Input: nums = [0]
//    Output: []

    public List<List<Integer>> threeSum(int[] nums) {

        // List接口：存储有序的、可重复的数据。
        Set<List<Integer>> res = new HashSet<>();

        // 判断数组长度是否小于3
        if (nums.length < 3)
            return new ArrayList<>(res);

        // 需先排序
        Arrays.sort(nums);

        // 本题也需采用双指针
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(res);
    }


//    public List<List<Integer>> threeSum(int[] nums) {
//
//        List<List<Integer>> list1 = new ArrayList<>();
//
//        // 1.对于数组长度小于3或者数组内容为null的
//        if (nums == null || nums.length < 3)
//            return list1;
//        // 2.数组排序
//        Arrays.sort(nums);
//        // 3.
//        for (int i = 0; i < nums.length; i++) {
//            // 3.1如果数组的第一位就大于0的话，那么此数组全大于0，就不用再继续了
//            if (nums[0] > 0)
//                return list1;
//            // 3.2 ★★★
//            if (i > 0 && nums[i] == nums[i - 1])
//                continue;
//            // 3.3
//            int L = i + 1, R = nums.length - 1;
//            int sum = nums[i] + nums[L] + nums[R];
//            if (sum == 0) {
//                list1.add(Arrays.asList(nums[i], nums[L], nums[R]));
//                while (L < R && nums[L] == nums[L + 1])
//                    L++;
//                while (L < R && nums[R] == nums[R - 1])
//                    R--;
//
//                L++;
//                R--;
//            } else if (sum < 0) {
//                L++;
//            } else {
//                R--;
//            }
//        }
//        return list1;
//    }


}












