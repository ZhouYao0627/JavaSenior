package LeetCode;

import java.util.Arrays;

/**
 * @author：ZhouYao
 * @create：2021-07-26 11:27
 */
public class sixteen {
    /*
    给定一个包括 n 整数的数组nums和一个目标值target。
    找出nums中的三个整数，使得它们的和与target最接近。
    返回这三个数的和。假定每组输入只存在唯一答案。
    */

//    Input: nums = [-1,2,1,-4], target = 1
//    Output: 2
//    Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

    public int threeSumClosest(int[] nums, int target) {

        int result = nums[0] + nums[1] + nums[2];

        // 需先排序
        Arrays.sort(nums);

        //
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            int sum = nums[i] + nums[left] + nums[right];
            // 若正好有相等的
            if (sum == target) {
                return target;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }

            // 下方太妙了，即将最接近target的sum赋值给result
            if (Math.abs(sum - target) < Math.abs(result - target))
                result = sum;
        }
        return result;
    }


}









