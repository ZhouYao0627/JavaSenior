import java.util.*;

/**
 * @author：ZhouYao
 * @create：2021-07-21 18:45
 */
public class fifteen {

    /*给你一个包含n个整数的数组nums，判断nums中是否存在三个元素a，b，c ，
    使得a+b+c=0？请你找出所有和为0且不重复的三元组。
    注意：答案中不可以包含重复的三元组。
    */

    /*
     我的想法: 不好
     两层循环，外层是用来从第一个开始遍历，只需遍历到nums的倒数第二个，即nums.length-3
     内层从i+1开始遍历，遍历到nums.length-2
     */

//    public List<List<Integer>> threeSum(int[] nums) {
//        int[] arr = new int[3];
//
//        int k;
//        ArrayList<List<Integer>> list = new ArrayList<>();
//        for (int i = 0; i < nums.length - 3; i++) {
//            for (int j = i + 1; j <= nums.length - 2; j++) {
//                k = j + 1;
//                if (arr[i] + arr[j] + list.get(k))
//            }
//
//        }
//
//
//        return list;
//    }


    /*
    排序 + 双指针:
    本题的难点在于如何去除重复解。

    算法流程：
    1.特判，对于数组长度n，如果数组为 null或者数组长度小于3，返回[]。
    2.对数组进行排序。
    3.遍历排序后数组：
    3.1 若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于0，直接返回结果。
    3.2 对于重复元素：跳过，避免出现重复解
    3.3 令左指针L=i+1，右指针R=n−1，当L<R时，执行循环：
        (1)当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，
           去除重复解。并同时将L,R移到下一位置，寻找新的解
        (2)若和大于0，说明nums[R]太大，R左移
        (3)若和小于0，说明nums[L]太小，L右移
    */
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> list1 = new ArrayList<>();
//        // 1.
//        if (nums == null || nums.length < 3)
//            return list1;
//        // 2.
//        Arrays.sort(nums);
//        // 3.
//        for (int i = 0; i < nums.length; i++) {
//            // 3.1
//            if (nums[0] > 0)
//                return list1;
//            // 3.2 这是为了在i>0时，为了接下来的L和R负责。没有这个将会有重复的 ★★★
//            if (i > 0 && nums[i] == nums[i - 1])
//                continue;
//            // 3.3
//            int L = i + 1, R = nums.length - 1;
//            while (L < R) {
//                // (1)
//                if (nums[i] + nums[L] + nums[R] == 0) {
//                    // 下面是三种写法
////                    List<Integer> list2 = new ArrayList<>();
////                    list2.add(nums[i]);
////                    list2.add(nums[L]);
////                    list2.add(nums[R]);
//
////                    List<Integer> list2 = Arrays.asList(nums[i], nums[L], nums[R]);
////                    list1.add(list2);
//
//                    list1.add(Arrays.asList(nums[i], nums[L], nums[R]));
//
//                    while (L < R && nums[L] == nums[L + 1])
//                        L++;
//                    while (L < R && nums[R] == nums[R - 1])
//                        R--;
//
//                    L++;
//                    R--;
//                } else if (nums[i] + nums[L] + nums[R] > 0) {
//                    R--;
//                } else {
//                    L++;
//                }
//            }
//        }
//        return list1;
//    }

    // Java with set
    public List<List<Integer>> threeSum(int[] nums) {

        // List接口：存储有序的、可重复的数据。
        Set<List<Integer>> res = new HashSet<>();

        if (nums.length == 0)
            return new ArrayList<>(res);

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0)
                    res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum > 0)
                    k--;
                else if (sum < 0)
                    j++;
            }

        }
        return new ArrayList<>(res);
    }


}
