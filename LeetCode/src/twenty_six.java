/**
 * @author：ZhouYao
 * @create：2021-07-23 21:38
 */
public class twenty_six {

    /*给你一个有序数组nums，请你原地删除重复出现的元素，
    使每个元素只出现一次 ，返回删除后数组的新长度。
    不要使用额外的数组空间，
    你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
    */

    public int removeDuplicates(int[] nums) {

        // 判断数组是否为空或为null
        if (nums.length == 0 || nums == null)
            return 0;

        // 下方的两行可以直接换为 int i = 1
//        int i = 0;
//        nums[i++] = nums[0]; // 先将首个位置赋值，并且此时 i=1

        int i = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j - 1]) {
                nums[i++] = nums[j]; // 删除后的赋值
            }
        }
        return i;
    }

//    public int removeDuplicates(int[] nums) {
//        int pos = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] != nums[pos - 1]) {
//                nums[pos++] = nums[i];
//            }
//        }
//        return pos;
//    }

    // 未看懂
//    public int removeDuplicates(int[] nums) {
//        int pos = 0;
//        for (int num : nums) {
//            if (nums[pos] != num) {
//                nums[++pos] = num;
//            }
//        }
//        return pos + 1;

//    }

//        // 想复杂了？
//        int left = 0, right = nums.length - 1;
//        int k = 0;
//        if (nums.length == 0)
//            return 0;
//        if (nums[left] == nums[right])
//            return 1;
//        while (left <= right) {
//            right--;
//            if (nums[left] == nums[right]) {
//                nums[k++] = nums[left];
//                left = right + 1;
//                right = nums.length - 1;
//            }
//        }
//        return k;

    //        HashMap map = new HashMap<Integer, Integer>();
//        int j = 0, k = nums.length;
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//                map.remove(nums[i]);
//                k--;
//            }
//            nums[j] = nums[i];
//            j++;
//            while (nums[j] == nums[j-1])
//                continue;
//        }


}
