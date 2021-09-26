/**
 * @author：ZhouYao
 * @create：2021-07-26 16:17
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

//    Input: nums = [1,3,5,6], target = 7
//    Output: 4

//    Input: nums = [1,3,5,6], target = 0
//    Output: 0

//    Input: nums = [1], target = 0
//    Output: 0

    // 别人的写法  双指针
    public int searchInsert1(int[] A, int target) {
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target)
                return mid;
            else if (A[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    // 自己的方法
    public int searchInsert(int[] nums, int target) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            // 若数组中有target元素，即直接返回其索引
            if (nums[i] == target)
                return i;

            // 若数组中没有target元素
            // 若数组中的第一个数就比target大，即直接返回0
            if (nums[0] > target)
                return 0;
            // 若数组中最后一个元素都比target小，即直接返回数组的长度，也就是它应该的索引位置
            if (nums[nums.length - 1] < target)
                return nums.length;
            // 此时的target元素是在nums数组内部，就需要寻找其应当在的位置
            if (nums[i] < target) {
                k++;
            }
        }
        return k;
    }




}

















