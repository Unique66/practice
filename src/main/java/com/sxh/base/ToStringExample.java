package com.sxh.base;

import java.util.Objects;

/**
 *
 */
public class ToStringExample {
    private int age;

    private String name;

    public ToStringExample(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ToStringExample{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToStringExample that = (ToStringExample) o;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    public static void main(String[] args) {
        ToStringExample toStringExample = new ToStringExample(18, "uniqueS");
        System.out.println(toStringExample.toString());
    }
}
