/*
 * Copyright (c) 2021.  User:SXH  File:BinaryHeapDemo.java
 * Date:2021/05/06 21:27:06
 */

package com.autonomic.datastructures.tree.binaryheap;

import java.util.Arrays;

/**
 * @author SXH
 * @description 二叉堆
 * @date 2021/5/6 21:27
 * <p>
 * 二叉堆的自我调整
 * 插入节点     时间复杂度：O(logn)
 * 当二叉堆插入节点时，插入位置是完全二叉树的最后一个位置。
 * 删除节点     时间复杂度：O(logn)
 * 二叉堆删除节点的过程和插入节点的过程正好相反，所删除的是处于堆顶的节点。
 * 构建二叉堆  时间复杂度：O(n)
 * 把一个无序的完全二叉树调整为二叉堆，本质上就是让所有非叶子节点依次“下沉”。
 */
public class BinaryHeapDemo {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {7, 1, 3, 10, 5, 2, 8, 9, 6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));

        // 优先队列
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(1);
        System.out.println(Arrays.toString(priorityQueue.array));
        System.out.println("出队元素：" + priorityQueue.deQueue() + "  size : " + priorityQueue.size);
        System.out.println("出队元素：" + priorityQueue.deQueue() + "  size : " + priorityQueue.size);
    }

    /**
     * “上浮”调整   小顶堆
     *
     * @param array 待调整的堆
     */
    public static void upAdjust(int[] array) {
        // 待上浮的元素下标
        int childIndex = array.length - 1;
        // 待上浮元素的父节点下标
        int parentIndex = (childIndex - 1) / 2;
        // 临时变量记录插入的元素值
        int temp = array[childIndex];
        // 直接和父节点的元素比大小，父节点的元素大，就将父节点元素移动到下方
        while (childIndex > 0 && array[parentIndex] > temp) {
            // 无需真正交换，单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        // 跳出循环说明已经移动完毕，将temp 值赋值给childIndex
        array[childIndex] = temp;
    }

    /**
     * “下沉”调整   小顶堆
     *
     * @param array       待调整的堆
     * @param parentIndex 要“下沉” 的父节点
     * @param length      堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        // 记录待下沉节点的元素值
        int temp = array[parentIndex];
        // 找到左孩子节点
        int childIndex = parentIndex * 2 + 1;
        while (childIndex < length) {
            // 对比左右孩子节点，取较小的那一个
            if (childIndex + 1 < length && array[childIndex] > array[childIndex + 1]) {
                childIndex++;
            }
            // 与待下沉节点元素比较大小，待下沉节点小，说明已经找到合适的位置了
            if (temp < array[childIndex]) {
                break;
            }
            // 待下沉节点大就向下替换
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        // 跳出循环，说明已经下沉到最后，直接处理下沉数据temp 即可
        array[parentIndex] = temp;
    }

    /**
     * 构建堆  小顶堆
     * 把一个无序的完全二叉树调整为二叉堆，本质上就是让所有非叶子节点依次“下沉”。
     *
     * @param array 待调整的堆
     */
    public static void buildHeap(int[] array) {
        // 最后一个非叶子节点下标获取公式： length/2-1 或(length-2)/2
        for (int i = (array.length) / 2 - 1; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }
}

/********************************************优先队列********************************************************/
/**
 * 优先队列不再遵循先入先出的原则，而是分为两种情况：
 * 最大优先队列，无论入队顺序如何，都是当前最大的元素优先出队
 * 最小优先队列，无论入队顺序如何，都是当前最小的元素优先出队
 */
class PriorityQueue {
    public int[] array;
    public int size;
    public PriorityQueue() {
        // 队列初始长度为32
        array = new int[32];
    }

    /**
     * 入队
     *
     * @param key 入队元素
     */
    public void enQueue(int key) {
        if (size >= array.length) {
            resize();
        }
        array[size++] = key;
        upAdjust(array);
    }

    /**
     * 出队
     */
    public int deQueue() {
        if (size <= 0) {
            throw new RuntimeException("the queue is empty!");
        }
        // 记录堆顶元素，方法输出
        int head = array[0];
        // 将最后一个元素移动到堆顶
        array[0] = array[--size]; // --size 是因为当size 是2 那么对应最后一个元素下标是1，所以要先--
        downAdjust();
        return head;
    }

    /**
     * “上浮”调整   小顶堆
     *
     * @param array 待调整的堆
     */
    public void upAdjust(int[] array) {
        // 待上浮的元素下标
        int childIndex = size - 1;
        // 待上浮元素的父节点下标
        int parentIndex = (childIndex - 1) / 2;
        // 临时变量记录插入的元素值
        int temp = array[childIndex];
        // 直接和父节点的元素比大小，父节点的元素大，就将父节点元素移动到下方
        while (childIndex > 0 && array[parentIndex] > temp) {
            // 无需真正交换，单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        // 跳出循环说明已经移动完毕，将temp 值赋值给childIndex
        array[childIndex] = temp;
    }

    /**
     * “下沉”调整   小顶堆
     */
    public void downAdjust() {
        // 记录待下沉节点的元素值
        int parentIndex = 0;
        int temp = array[parentIndex];
        // 找到左孩子节点
        int childIndex = 1;
        while (childIndex < size) {
            // 对比左右孩子节点，取较小的那一个
            if (childIndex + 1 < size
                    && array[childIndex] > array[childIndex + 1]) {
                childIndex++;
            }
            // 与待下沉节点元素比较大小，待下沉节点小，说明已经找到合适的位置了
            if (temp < array[childIndex]) {
                break;
            }
            // 待下沉节点大就向下替换
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        // 跳出循环，说明已经下沉到最后，直接处理下沉数据temp 即可
        array[parentIndex] = temp;
    }

    /**
     * 队列扩容
     */
    public void resize() {
        this.array = Arrays.copyOf(this.array, this.size * 2);
    }
}