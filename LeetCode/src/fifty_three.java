/**
 * @author：ZhouYao
 * @create：2021-07-27 11:35
 */
public class fifty_three {

//    Given an integer array nums,
//    find the contiguous subarray (containing at least one number)
//    which has the largest sum and return its sum.
//    A subarray is a contiguous part of an array.

//    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//    Output: 6
//    Explanation: [4,-1,2,1] has the largest sum = 6.

//    Input: nums = [1]
//    Output: 1

//    Input: nums = [5,4,-1,7,8]
//    Output: 23

    public static int maxSubArray(int[] nums) {
        int tempSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tempSum + nums[i] >= nums[i])
                tempSum = tempSum + nums[i];
            else
                tempSum = nums[i];
            maxSum = tempSum > maxSum ? tempSum : maxSum;
        }
        return maxSum;
    }

    // 他人的1
    public static int maxSubArray1(int[] A) {
        int maxSoFar = A[0], maxEndingHere = A[0];
        for (int i = 1; i < A.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    // 他人的2
//    public int maxSubArray2(int[] nums) {
//        int sum = 0, max = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            sum = sum < 0 ? nums[i] : (sum + nums[i]);
//            max = Math.max(sum, max);
//        }
//        return max;
//    }

    // 未做出来
//    public int maxSubArray(int[] nums) {
//        int maxSum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int tempSum = 0;
//            for (int j = i; j < nums.length; j++) {
//                tempSum += nums[j++];
//                maxSum = tempSum > maxSum ? tempSum : maxSum;
//            }
//        }
//        return maxSum;
//    }

}
