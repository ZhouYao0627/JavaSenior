import java.util.HashMap;

/**
 * @author：ZhouYao
 * @create：2021-07-21 14:43
 */
public class one {
    /*
    给定一个整数数组 nums和一个整数目标值 target，
    请你在该数组中找出和为目标值 target的那两个整数，并返回它们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    你可以按任意顺序返回答案。
    */

//    public int[] twoSum(int[] nums, int target) {
//        int[] sum = new int[]{0, 1};
//        // 若数组中元素正好为两位，则直接返回两数相加
//        if (nums.length == 2)
//            return sum;
//
//        // 其它情况
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if ((nums[i] + nums[j]) == target) {
//                    sum[0] = i;
//                    sum[1] = j;
//                    return sum;
//                }
//            }
//        }
//        return null;
//    }

    //  from:jiaming2,this is better than me
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i); // 这行很重要 但未懂★
        }
        return result;
    }


}










