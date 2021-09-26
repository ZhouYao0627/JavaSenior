package LeetCode;

/**
 * @author：ZhouYao
 * @create：2021-07-22 16:56
 */
public class eleven {

//    public int maxArea(int[] height) {
//        int tempArea, maxArea = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                tempArea = (j - i) * (height[i] > height[j] ? height[j] : height[i]);
//                maxArea = tempArea > maxArea ? tempArea : maxArea;
//            }
//        }
//        return maxArea;
//    }

//    public int maxArea(int[] height) {
//        int i = 0, j = height.length - 1;
//        int tempArea, maxArea = 0;
//        while (i < j) {
//            tempArea = (j - i) * (height[i] > height[j] ? height[j--] : height[i++]);
//            maxArea = tempArea > tempArea ? tempArea : maxArea;
//        }
//        return maxArea;
//    }

    public int maxArea(int[] height) {

        // 方法一：暴力解法
//        int tempArea = 0, maxValue = 0;
//        for (int i = 0; i < height.length - 1; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                tempArea = (j - 1) * (height[i] > height[j] ? height[j] : height[i]);
//                maxValue = tempArea > maxValue ? tempArea : maxValue;
//            }
//        }
//        return maxValue;

        // 方法二：双指针
        int i = 0, j = height.length - 1;
        int tempArea, maxValue = 0;
        while (i < j) {
            tempArea = (j - i) * (height[i] < height[j] ? height[i++] : height[j--]);
            maxValue = tempArea > maxValue ? tempArea : maxValue;
        }
        return maxValue;
    }


}













