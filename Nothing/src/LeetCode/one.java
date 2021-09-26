package LeetCode;

import java.util.HashMap;

/**
 * @author：ZhouYao
 * @create：2021-07-22 16:40
 */
public class one {
     /*
    给定一个整数数组 nums和一个整数目标值 target，
    请你在该数组中找出和为目标值 target的那两个整数，并返回它们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    你可以按任意顺序返回答案。
    */

//    输入：nums = [2,7,11,15], target = 9
//    输出：[0,1]
//    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

//    Input: nums = [3,2,4], target = 6
//    Output: [1,2]


    // 方法二
    public int[] twoSum1(int[] nums, int target) {

        int[] result = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsValue(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i); // 这行很重要
        }
        return result;
    }

    // 方法一
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        if (nums.length == 2)
            return result;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }




}












