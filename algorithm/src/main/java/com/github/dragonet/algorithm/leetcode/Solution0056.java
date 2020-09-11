package com.github.dragonet.algorithm.leetcode;

import java.util.Arrays;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2:
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 * <p>
 *  
 * <p>
 * 提示：
 * intervals[i][0] <= intervals[i][1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 *
 * @author xiaolong.qin
 * @date 2020/8/30 10:21 上午
 **/
public class Solution0056 {

    public int[][] merge(int[][] intervals) {
        int[][] temp = new int[intervals.length][2];


        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        byte[] bits = new byte[100];
        for (int i = 0; i < intervals.length; i++) {
            int[] num = intervals[i];
            if (max < num[1]) {
                max = num[1];
            }
            if (num[0] < min) {
                min = num[0];
            }
            for (int j = num[0]; j <= num[1]; j++) {
                bits[j] = 1;
            }
        }
//        System.out.println("min:" + min + ", max:" + max + ", bits[]:" + Arrays.toString(bits));

        int row = 0;
        int left = min;
        int right = 0;
        for (int k = min; k <= max + 1; k++) {
            System.out.println(k + "--" + left + "--" + right);
            if (bits[k] == 1) {
                if (left == 0) {
                    left = k;
                }
                right = k;
            } else {
                if (left > 0 && right > 0) {
                    temp[row++] = new int[]{left, right};
                    left = 0;
                    right = 0;
                }
            }

        }

        int[][] result = new int[row][2];
        for (int i = 0; i < row; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    public static void main(String[] args) {


        int[][] input1 = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        printResult(input1);

        int[][] input2 = new int[][]{{1, 3}, {3, 6}};
//        printResult(input2);

        int[][] input3 = new int[][]{{1, 4}, {5, 6}};
        printResult(input3);
    }

    private static void printResult(int[][] input) {
        Solution0056 solution0056 = new Solution0056();
        int[][] result = solution0056.merge(input);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

}
