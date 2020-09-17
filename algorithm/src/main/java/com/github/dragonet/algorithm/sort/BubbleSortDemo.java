package com.github.dragonet.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序示例代码
 *
 * 冒泡排序思想:
 *  冒泡排序，类似于水中冒泡，较大的数沉下去，较小的数慢慢冒起来，假设从小到大，即为较大的数慢慢往后排，较小的数慢慢往前排。
 *  直观表达，每一趟遍历，将一个最大的数移到序列末尾。
 *
 * 算法描述
 * 1.比较相邻的元素，如果前一个比后一个大，交换之。
 * 2.第一趟排序第1个和第2个一对，比较与交换，随后第2个和第3个一对比较交换，这样直到倒数第2个和最后1个，将最大的数移动到最后一位。
 * 3.第二趟将第二大的数移动至倒数第二位
 *
 * 参考：https://www.jianshu.com/p/1458abf81adf
 *
 *
 * @author xiaolong.qin
 * @date 2020/9/16 3:41 下午
 **/
public class BubbleSortDemo {

    /**
     * 冒泡排序核心逻辑
     * @param dataArray 需要排序的数据
     */
    public void sort(int[] dataArray) {
        // 边界判断
        if (dataArray == null || dataArray.length < 2) {
            return;
        }
        for (int i = 0; i < dataArray.length - 1; i++) {
            for (int j = 0; j < dataArray.length - 1 - i; j++) {
                if (dataArray[j] > dataArray[j + 1]) {
                    int temp = dataArray[j];
                    dataArray[j] = dataArray[j + 1];
                    dataArray[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 8, 5, 7, 4, 3};
        new BubbleSortDemo().sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("-------------------");
        int[] arr1 = {4,3,2,1};
        new BubbleSortDemo().sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

}
