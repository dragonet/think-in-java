package com.github.dragonet.algorithm.leetcode;

import junit.framework.Assert;

import java.util.*;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 *
 * @author xiaolong.qin
 * @date 2020/8/29 3:07 下午
 **/
public class Solution0042 {
    public int trap01(int[] height) {
        int result = 0;
        if (height.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            if (list.isEmpty()) {
                if (h == 0) {
                    continue;
                }
                list.add(h);
            } else {
                int lastEle = list.get(list.size() - 1);
                if (h <= lastEle) {
                    list.add(h);
                    continue;
                }
                int maxHeiht = 0;
                int index = 0;
                for (int k = 0;k<list.size();k++){
                    if (list.get(k) > maxHeiht) {
                        maxHeiht = list.get(k);
                        index = k;
                    }
                }
                if (maxHeiht > h) {
                    maxHeiht = h;
                }
                for (int j = list.size() - 1; j > 0; j--) {
                    int curEle = list.get(j);
                    if (curEle >= h) {
                        break;
                    }
                    if (j == index) {
                        break;
                    }
                    result += maxHeiht - curEle;
                    list.set(j, maxHeiht);
                }
                list.add(h);
                System.out.println(i + "--" + result + "--" + list);
            }

        }

        return result;
    }

    public int trap(int[] height) {
        int result = 0;
        if (height.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();

        int maxHeiht = 0;
        int index = 0;
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            if (list.isEmpty()) {
                if (h == 0) {
                    continue;
                }
                list.add(h);
            } else {
                int lastEle = list.get(list.size() - 1);
                if (h <= lastEle) {
                    list.add(h);
                    continue;
                }
                for (int k = index ;k<list.size();k++){
                    if (list.get(k) > maxHeiht) {
                        maxHeiht = list.get(k);
                        index = k;
                    }
                }
                int calcHeiht = maxHeiht;
                if (maxHeiht > h) {
                    calcHeiht = h;
                } else {
                    maxHeiht = h;
                    index = list.size();
                }
                System.out.println(i + "--" + calcHeiht + "--" + index);
                for (int j = list.size() - 1; j > 0; j--) {
                    int curEle = list.get(j);
                    if (curEle >= h) {
                        break;
                    }
                    if (j == index) {
                        break;
                    }
                    result += calcHeiht - curEle;
                    list.set(j, calcHeiht);
                }
                list.add(h);
                System.out.println(i + "--" + result + "--" + list);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        Solution0042 solution = new Solution0042();

        int[] arr1 = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Assert.assertEquals(6, solution.trap(arr1));

        int[] arr2 = new int[]{3,2,1,0,2,1,4};
        System.out.println(solution.trap(arr2));
    }
}
