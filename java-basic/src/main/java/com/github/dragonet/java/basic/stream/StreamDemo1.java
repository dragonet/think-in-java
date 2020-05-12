package com.github.dragonet.java.basic.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {@link java.util.stream.Stream} 使用学习
 * @author xiaolong.qin
 * @date 2020/5/6 7:37 下午
 **/
public class StreamDemo1 {

    public static void main(String[] args) {
        System.out.println("-------data size 10000 ---------");
        testExecuteTime(10000);
        System.out.println("-------data size 100000 ---------");
        testExecuteTime(100000);
        System.out.println("-------data size 1000000 ---------");
        testExecuteTime(1000000);
    }

    /**
     * 验证 Stream 流的执行效率 大于 for 循环和 for-each
     */
    public static void testExecuteTime(int size) {
        long sreamExecuteTime = streamExecuteTime(size);
        System.out.println(sreamExecuteTime);
        long forExecuteTime = forExecuteTime(size);
        System.out.println(forExecuteTime);
        long forEachExecuteTime = forEachExecuteTime(size);
        System.out.println(forEachExecuteTime);
    }

    /**
     * 初始化数据
     * @param size 数据量
     * @return List
     */
    private static List<Integer> initData(int size) {
        List<Integer> result = new ArrayList<>();
        for (int i=0;i<size;i++) {
            result.add(i);
        }
        return result;
    }

    private static long streamExecuteTime(int size) {
        List<Integer> data = initData(size);
        long startNs = System.nanoTime();
        data.stream().map(it -> "streamExecuteTime" + it).collect(Collectors.toList());
        long endNs = System.nanoTime();
        return endNs - startNs;
    }

    private static long forExecuteTime(int size) {
        List<Integer> data = initData(size);
        long startNs = System.nanoTime();
        for (int i=0;i<size;i++) {
            String str = "forExecuteTime" + data.get(i);
        }
        long endNs = System.nanoTime();
        return endNs - startNs;
    }

    private static long forEachExecuteTime(int size) {
        List<Integer> data = initData(size);
        long startNs = System.nanoTime();
        for (Integer i : data) {
            String str = "forEachExecuteTime" + i;
        }
        long endNs = System.nanoTime();
        return endNs - startNs;
    }

}
