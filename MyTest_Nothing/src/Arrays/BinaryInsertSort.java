package Arrays;

import java.util.Arrays;

/**
 * 折半插入排序
 *
 * @author shkstart 2018-12-17
 */
public class BinaryInsertSort {
    public static void binaryInsertSort(int[] data) {
        System.out.println("开始排序");
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            int low = 0, high = i - 1;

            // 不断折半，寻找合适的插入位置
            while (low <= high) {
                int mid = (low + high) / 2;
                if (temp > data[mid])
                    low = mid + 1;
                else
                    high = mid - 1;
            }

            // 依次后移
            for (int j = i; j > low; j--)
                data[j] = data[j - 1];

            data[low] = temp;

            System.out.println(Arrays.toString(data));
        }

    }

    // 自己练习所用
    public static void binaryInsertSort1(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int low = 0, high = i - 1;
            int temp = data[i];
            while (low <= high) {
                int mid = (low + high) / 2;
                if (data[mid] < data[i])
                    low = mid + 1;
                else
                    high = mid - 1;
            }

            for (int j = i; j > low; j--) {
                data[j] = data[j - 1];
            }
            data[low] = temp;
        }


    }

    public static void main(String[] args) {
        int[] data = {9, -16, 21, 23, -30, -49, 21, 30, 30};
        System.out.println("排序之前：\n" + Arrays.toString(data));
        binaryInsertSort(data);
        System.out.println("排序之后：\n" + Arrays.toString(data));
    }


}
