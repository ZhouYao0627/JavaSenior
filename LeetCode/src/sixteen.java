import java.util.Arrays;

/**
 * @author：ZhouYao
 * @create：2021-07-22 20:02
 */
public class sixteen {
    /*
    给定一个包括 n 整数的数组nums和一个目标值target。
    找出nums中的三个整数，使得它们的和与target最接近。
    返回这三个数的和。假定每组输入只存在唯一答案。

    Example：
    Input: nums = [-1,2,1,-4], target = 1
    Output: 2
    Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    */

    /*
     * 我的想法
     * 1.排序-->[-1,1,2,4]
     * 2.判断数组中是否有target这个数
     *   有，则以target为中心，求其与左右两数之和
     *   无，则判断target是否大于0，若大于0则以此数的左侧的数为中心，求其与左右两数之和
     *                            若小于0则以此数的右侧为中心，求其与左右两数之和
     * */
//    public int threeSumClosest(int[] nums, int target) {
//
//        // 1.
//        Arrays.sort(nums);
//        // 2.
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) {
//                int result1 = nums[i] + nums[i - 1] + nums[i + 1];
//                return result1;
//            }
//
//            sum += nums[i];
//        }
//        if (sum < target)
//            return 0;
//
//        int j = 0;
//        while (nums[j] < target) {
//            j++;
//        }
//
//        if (target >= 0) {
//            int result2 = nums[j] + nums[j - 1] + nums[j - 2];
//            return result2;
//        } else {
//            int result3 = nums[j] + nums[j + 1] + nums[j + 2];
//            return result3;
//        }
//
//    }

    // 依旧使用了双指针
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        // 排序
        Arrays.sort(nums);
        //
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }

                // 下方太妙了，即将最接近target的赋值给result
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    //    we could improve performance a bit by skipping duplicate elements.
    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[nums.length - 1];
        int closestSum = sum;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    sum = nums[left] + nums[right] + nums[i];
                    if (sum < target) {
                        //move closer to target sum.
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    } else if (sum > target) {
                        //move closer to target sum.
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else {
                        return sum;
                    }
                    //update the closest sum if needed.
                    if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                        closestSum = sum;
                    }
                }
            }

        }
        return closestSum;
    }


}
