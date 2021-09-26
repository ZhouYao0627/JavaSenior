package com.atguigu.exer;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author：ZhouYao
 * @create：2021-09-18 19:51
 */


public class YangHuiTest {

    /*
     * 【提示】
     * 1. 第一行有 1 个元素, 第 n 行有 n 个元素
     * 2. 每一行的第一个元素和最后一个元素都是 1
     * 3. 从第三行开始, 对于非第一个元素和最后一个元素的元素。
     * 即：yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j];
     */
    // 杨辉三角
    public void test1() {
        int[][] arr = new int[10][];

        // 1.声明并初始化二维数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
        }

        // 2.给数组元素赋值
        for (int i = 0; i < arr.length; i++) {
            // 2.1给首末元素赋值
            arr[i][0] = arr[i][i] = 1;
            // 2.2给内部元素赋值
            //if (i > 1) {  // 这个可以去掉，因为当i=0，i=1时，下方不成立
            for (int j = 1; j < arr[i].length - 1; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                //}
            }
        }

        // 3.遍历二维数组
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    // 创建一个长度为 6 的 int 型数组，要求取值为 1-30，同时元素值各不相同
    @Test
    public void test2() {
        //此题只做了解，初学不必精通。
        // 方式一：
//		int[] arr = new int[6];
//		for (int i = 0; i < arr.length; i++) {// [0,1) [0,30) [1,31)
//			arr[i] = (int) (Math.random() * 30) + 1;
//
//			boolean flag = false;
//			while (true) {
//				for (int j = 0; j < i; j++) {
//					if (arr[i] == arr[j]) {
//						flag = true;
//						break;
//					}
//				}
//				if (flag) {
//					arr[i] = (int) (Math.random() * 30) + 1;
//					flag = false;
//					continue;
//				}
//				break;
//			}
//		}
//
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
        // 方式二：
        // 初始化
        int[] arr2 = new int[6];

        // 赋值
        for (int i = 0; i < arr2.length; i++) { // [0,1) [0,30) [1,31)
            arr2[i] = (int) (Math.random() * 30) + 1;
            for (int j = 0; j < i; j++) {  // 当前元素和它之前的每一个元素都比一遍
                if (arr2[i] == arr2[j]) {
                    i--;
                    break;
                }
            }
        }

        // 输出
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }

    /*
     * 此题了解！！！
     *
     * 回形数格式方阵的实现
     * 从键盘输入一个整数（1~20）
     * 则以该数字为矩阵的大小，把 1,2,3…n*n 的数字按照顺时针螺旋的形式填入其中。例如： 输入数字2，则程序输出：
     * 1 2
     * 4 3
     * 输入数字 3，则程序输出：
     * 1 2 3
     * 8 9 4
     * 7 6 5
     * 输入数字 4， 则程序输出：
     * 1   2   3   4
     * 12  13  14  5
     * 11  16  15  6
     * 10  9   8   7
     */
    // 回形数格式方阵的实现
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个数字:");
        int len = scanner.nextInt();
        int[][] arr = new int[len][len];
        int s = len * len;
        /*
         * k = 1:向右 k = 2:向下 k = 3:向左 k = 4:向上
         */
        int k = 1;
        int i = 0, j = 0;
        for (int m = 1; m <= s; m++) {
            if (k == 1) {
                if (j < len && arr[i][j] == 0) {
                    arr[i][j++] = m;
                } else {
                    k = 2;
                    i++;
                    j--;
                    m--;
                }
            } else if (k == 2) {
                if (i < len && arr[i][j] == 0) {
                    arr[i++][j] = m;
                } else {
                    k = 3;
                    i--;
                    j--;
                    m--;
                }
            } else if (k == 3) {
                if (j >= 0 && arr[i][j] == 0) {
                    arr[i][j--] = m;
                } else {
                    k = 4;
                    i--;
                    j++;
                    m--;
                }
            } else if (k == 4) {
                if (i >= 0 && arr[i][j] == 0) {
                    arr[i--][j] = m;
                } else {
                    k = 1;
                    i++;
                    j++;
                    m--;
                }
            }
        }

        // 遍历
        for (int m = 0; m < arr.length; m++) {
            for (int n = 0; n < arr[m].length; n++) {
                System.out.print(arr[m][n] + "\t");
            }
            System.out.println();
        }
    }


}
