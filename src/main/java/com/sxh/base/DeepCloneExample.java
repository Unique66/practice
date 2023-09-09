package com.sxh.base;

/**
 * 深拷贝：拷贝对象和原始对象的引用类型 引用不同对象
 */
public class DeepCloneExample implements Cloneable{
    private int[] arr;

    public DeepCloneExample() {
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
    public DeepCloneExample clone() {
        try {
            DeepCloneExample result = (DeepCloneExample) super.clone();
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
        DeepCloneExample shallowCloneExample = new DeepCloneExample();
        DeepCloneExample clone = shallowCloneExample.clone();
        System.out.println(shallowCloneExample.get(2));
        shallowCloneExample.set(2, 3);
        System.out.println(clone.get(2));
    }
}
