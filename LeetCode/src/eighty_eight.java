/**
 * @author：ZhouYao
 * @create：2021-07-27 15:11
 */
public class eighty_eight {

    /*给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
    初始化nums1 和 nums2 的元素数量分别为m 和 n。
    你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
    */

//    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//    Output: [1,2,2,3,5,6]

//    Input: nums1 = [1], m = 1, nums2 = [], n = 0
//    Output: [1]

//    Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//    Output: [1]

    // 从后向前进行比较，巧妙的解决了0的问题
    // - Why do we assume that nums2 will be bigger and we will have to combine it?
    // - Because if nums1 is bigger and nums 2 is shorter, when nums2 reaches the end,
    // nothing needs to be done for nums1 (we insert nums2 into nums1). Nums1 remains the same in that way.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1; // 此时的i,j,k都成为了下标

        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }

        while (j >= 0) { // only need to combine with remaining nums2
            nums1[k--] = nums2[j--];
        }
    }

    // 错误且超时
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] newNum = new int[m + n];
//        int k = 0, i = 0, j = 0;
//        while (i < nums1.length) {
//            while (j < nums2.length) {
//                if (nums1[i] <= nums2[j] && nums1[i] != 0)
//                    newNum[k++] = nums1[i++];
//                else if (nums1[i] > nums2[j] && nums2[j] != 0)
//                    newNum[k++] = nums2[j++];
//
//                if (nums1[i] == 0)
//                    newNum[k++] = nums2[j++];
//                if (nums2[j] == 0)
//                    newNum[k++] = nums1[i++];
//            }
//        }
//
//    }


}





