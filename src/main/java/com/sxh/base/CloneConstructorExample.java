package com.sxh.base;

/**
 * 使用clone() 方法拷贝一个对象既复杂又有风险，它会抛出异常，并且还需要类型转换。
 * Effective Java 书上讲到，最好不要去使用clone()，可以使用拷贝构造函数或者拷贝工厂来拷贝一个对象。
 */
public class CloneConstructorExample implements Cloneable{
    private int[] arr;

    public CloneConstructorExample() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public CloneConstructorExample(CloneConstructorExample origin) {
        arr = new int[origin.arr.length];
        for (int i = 0; i < origin.arr.length; i++) {
            arr[i] = origin.arr[i];
        }
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int get(int index) {
        return arr[index];
    }

    @Override
    public CloneConstructorExample clone() {
        try {
            CloneConstructorExample result = (CloneConstructorExample) super.clone();
            result.arr = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                result.arr[i] = arr[i];
            }
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        CloneConstructorExample shallowCloneExample = new CloneConstructorExample();
        CloneConstructorExample clone = new CloneConstructorExample(shallowCloneExample);
        System.out.println(shallowCloneExample.get(2));
        shallowCloneExample.set(2, 3);
        System.out.println(clone.get(2));
    }
}
