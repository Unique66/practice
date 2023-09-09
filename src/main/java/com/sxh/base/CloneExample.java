package com.sxh.base;

import java.util.stream.Collectors;

public class CloneExample implements Cloneable{
    private int age;
    private String name;

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneExample cloneExample = new CloneExample();
        CloneExample clone = (CloneExample) cloneExample.clone();
    }

    @Override
    public CloneExample clone() {
        try {
            CloneExample clone = (CloneExample) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
