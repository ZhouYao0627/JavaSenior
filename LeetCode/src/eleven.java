
/**
 * @author：ZhouYao
 * @create：2021-07-21 15:43
 */
public class eleven {

//    public int maxArea(int[] height) {
//        int min, len;
//        int tempArea, maxArea = 0;
//
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                // 最小高度
//                if ((height[i] - height[j]) > 0) {
//                    min = height[j];
//                } else {
//                    min = height[i];
//                }
//
//                len = j - i; // 底长
//
//                tempArea = min * len;
//
//                if (tempArea > maxArea)
//                    maxArea = tempArea;
//            }
//        }
//        return maxArea;
//    }

    /**
     * 暴力法: 计算出所有两个点组合所成的面积，求出最大值
     *  时间复杂度: O(n^2)(超出时间限制)
     * @param height
     * @return
     */
//    public static int myMaxArea(int[] height) {
//        int maxArea = 0;
//        //代表第一个点的坐标
//        for (int i = 0; i < height.length; i++) {
//            //代表第二个点的坐标
//            for (int j = i + 1; j < height.length; j++) {
//                // j-i 为底长，height[i] < height[j] ? height[i] : height[j]计算最小高度
//                int tempArea = (j - i) * (height[i] < height[j] ? height[i] : height[j]);
//                // 利用循环求解最小面积
//                maxArea = tempArea > maxArea ? tempArea : maxArea;
//            }
//
//        }
//        return maxArea;
//    }

    /**
     * 双指针: 数组左边和右边各一个指针，比较两个位置的大小计算面积，将较小的那一个往数组中心移动，
     * 直到指针重合(较小的移动x轴减少一，但是y轴可能增加大于1，所以面积可能会增大)
     * 优化方向: 每次移动指针的时候比较移动指针后的值跟前值大小，只有比大的再计算
     * 时间复杂度: O(n)
     * @param height
     * @return
     */
//    public static int maxArea(int[] height) {
//        int maxArea = 0;
//        int i = 0;
//        //右指针的起点为末尾
//        int j = height.length - 1;
//
//        //当左指针位于右指针的左边时就一直移动
//        while (i < j) {
//            int tempArea = (j - i) * (height[i] < height[j] ? height[i++] : height[j--]);
//            maxArea = tempArea > maxArea ? tempArea : maxArea;
//        }
//        return maxArea;
//    }

    /**
     * 优化双指针解法
     * @param height
     * @return
     */
//    public static int optimizeMaxArea(int[] height) {
//        int maxArea = 0;
//        int i = 0;
//        //右指针的起点为末尾
//        int j = height.length - 1;
//        //当左指针位于右指针的左边时就一直移动
//        while (i < j) {
//            int left = height[i];
//            int right = height[j];
//            int tempArea = (j - i) * (left < right ? left : right);
//            maxArea = tempArea > maxArea ? tempArea : maxArea;
//            // 优化 如果移动后的指针比之前小就继续移动
//            if (left <= right) {
//                while (left >= height[++i] && i < j) {}
//            } else {
//                while (right >= height[--j] && i < j) {}
//            }
//        }
//        return maxArea;
//    }

    public static int optimizeMaxArea(int[] height) {
        int maxValue = 0, tempArea;
        int i = 0; // firstpoint
        int j = height.length - 1; // lastpoint
        int left, right;

        while (i < j) {
            left = height[i];
            right = height[j];
            tempArea = (j - i) * (left < right ? left : right);
            maxValue = tempArea > maxValue ? tempArea : maxValue;

            if (left <= right) {
                while (left >= height[++i] && i < j) {}
            } else {
                while (right >= height[--j] && i < j) {}
            }
        }
        return maxValue;
    }


}

