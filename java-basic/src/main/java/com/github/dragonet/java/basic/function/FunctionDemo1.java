package com.github.dragonet.java.basic.function;

import java.util.function.Function;

/**
 * @author xiaolong.qin
 * @date 2020/4/30 4:33 下午
 **/
public class FunctionDemo1 {

    public static void main(String[] args) {
        testApply();
        System.out.println("-------------");
        testCompose();
        System.out.println("-------------");
        testAndThen();
    }

    public static void testAndThen() {
        Function<Integer, Integer> function1 = i -> i + 1;
        Function<Integer, String> function2 = i -> "result:" + (i * i);
        System.out.println("testAndThen:R1:" + function2.apply(function1.apply(5)));
        System.out.println("testAndThen:R2:" + function1.andThen(function2).apply(5));
//        System.out.println("testAndThen:F1:" + function2.andThen(function1).apply(5));
        System.out.println("testAndThen:R3:" + function1.compose(function1).andThen(function2).apply(5));
    }

    public static void testCompose() {
        Function<Integer, Integer> function1 = i -> i + 1;
        Function<Integer, String> function2 = i -> "result:" + (i * i);
        System.out.println("testCompose:R1:" + function2.apply(function1.apply(5)));
        System.out.println("testCompose:R2:" + function2.compose(function1).apply(5));
    }

    public static void testApply() {
        Function<Integer, Integer> test1 = i -> i + 1;
        Function<Integer, Integer> test2 = i -> i * i;
        System.out.println("testApply:R1:" + test1.apply(5));
        System.out.println("testApply:R2:" + test2.apply(5));
    }

}
