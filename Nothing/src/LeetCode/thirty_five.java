package LeetCode;

/**
 * @author：ZhouYao
 * @create：2021-07-27 10:34
 */
public class thirty_five {

    /*
    Given a sorted array of distinct integers and a target value,
    return the index if the target is found.
    If not, return the index where it would be if it were inserted in order.
    You must write an algorithm with O(log n) runtime complexity.
    */
//    Input: nums = [1,3,5,6], target = 5
//    Output: 2

//    Input: nums = [1,3,5,6], target = 2
//    Output: 1

//    Input: nums = [1,3,5,6], target = 7   ok
//    Output: 4

//    Input: nums = [1,3,5,6], target = 0   ok
//    Output: 0

//    Input: nums = [1], target = 0   ok
//    Output: 0

    public int searchInsert1(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            if (target > nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public int searchInsert(int[] nums, int target) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            // 若数组中有此元素
            if (nums[i] == target)
                return i;
            // 若target小于数组首位
            if (nums[0] > target)
                return 0;
            // 若target大于数组最后一位
            if (nums[nums.length - 1] < target)
                return nums.length;
            // 此时在数组中查找target应该在的位置
            if (nums[k] < target)
                k++;
        }
        return k;
    }


}







