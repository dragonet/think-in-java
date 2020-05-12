package com.github.dragonet.algorithm.list;

import java.util.Objects;

/**
 * 自定义 链表
 *
 * @author xiaolong.qin
 * @date 2020/5/12 6:11 下午
 **/
public class MyList<T> {

    private Node<T> head;

    private Node<T> tail;

    public void add(T data) {
        Objects.requireNonNull(data, "data is null");
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
        }
        Node<T> last = tail;
        tail = newNode;
        if (last != null) {
            last.next = newNode;
        }
        System.out.println("add:head:" + head);
        System.out.println("add:tail:" + tail);
    }

    public void printAll() {
        Node<T> p = head;
        while (p.next != null) {
            System.out.print(p.data + ",");
            p = p.next;
        }
        System.out.println(p.data);
    }

    /**
     * 链表节点
     *
     * @param <T>
     */
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
