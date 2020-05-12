package com.github.dragonet.algorithm.list;

/**
 * @author xiaolong.qin
 * @date 2020/5/12 6:08 下午
 **/
public class ListReverseDemo {



    public static void main(String[] args) {
        testAdd();
        System.out.println("----------");
    }

    public static void testAdd() {
        MyList<String> myList = new MyList<>();
        myList.add("a");
        myList.add("b");
        myList.add("c");
        myList.printAll();
    }

}
