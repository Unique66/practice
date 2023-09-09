package com.sxh.base;

/**
 * 浅拷贝：拷贝对象和原始对象的引用类型引用同一个对象
 */
public class ShallowCloneExample implements Cloneable{
    private int[] arr;

    public ShallowCloneExample() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int get(int index) {
        return arr[index];
    }

    @Override
    public ShallowCloneExample clone() {
        try {
            return (ShallowCloneExample) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        ShallowCloneExample shallowCloneExample = new ShallowCloneExample();
        ShallowCloneExample clone = shallowCloneExample.clone();
        System.out.println(shallowCloneExample.get(2));
        shallowCloneExample.set(2, 3);
        System.out.println(clone.get(2));
    }
}
