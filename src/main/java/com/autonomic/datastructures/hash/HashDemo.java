/*
 * Copyright (c) 2020.  User:SXH  File:HashDemo.java
 * Date:2020/11/19 21:53:19
 */

package com.autonomic.datastructures.hash;

/**
 * @author SXH
 * @description 哈希表结构
 * @date 2020/11/19 21:53
 */
public class HashDemo {
    /**
     * 哈希表（散列表）需求
     * 有一个公司，当有新的员工来报道时，要求该员工的信息加入（id，，姓名，性别，年龄，住址..），当输入该员工的ID时，要求查找到该员工的所有信息
     * 要求：不适用数据库，尽量节省内存，速度越快越好 -> 哈希表（散列）
     */
    public static void main(String[] args) {
        EmployeeLinkList employeeLinkList = new EmployeeLinkList();
        Employee employee1 = new Employee(1, "dalin");
        Employee employee2 = new Employee(2, "devin");
        Employee employee3 = new Employee(18, "smith");
        employeeLinkList.add(employee1);
        employeeLinkList.add(employee2);
        employeeLinkList.update(employee3);
        employeeLinkList.list(1);

        // 测试hashTable 的添加 遍历功能
        HashTable hashTable = new HashTable(16);
        hashTable.add(employee3);
        hashTable.list();
    }

    /**
     * 需求分析：
     * 哈希表分为：数组、链表
     * 1.创建链表节点
     * 2.使用节点组成链表
     * 3.每个数组放一个链表
     */
}

// 哈希表
class HashTable {
    private int size;
    private EmployeeLinkList [] hashTable;

    // 初始化哈希表的大小
    public HashTable(int size) {
        this.size = size;
        hashTable = new EmployeeLinkList[this.size]; // 注：由于数组存的是员工链表对象，默认值为null，使用时需要初始化new 对象

        // 也可以遍历初始化一下
        for (int i = 0; i < size; i++) {
            hashTable[i] = new EmployeeLinkList();
        }
    }

    public void add(Employee employee) {
        int id = employee.getId();
        int num = id % this.size; // 取模，求出需要放入的哈希表位置
        if (hashTable[num] == null) {
            hashTable[num] = new EmployeeLinkList();
        }
        hashTable[num].add(employee);
    }

    public void list() {
        for (int i = 0; i < this.size; i++) {
            if (hashTable[i] == null) {
                hashTable[i] = new EmployeeLinkList();
            }
            hashTable[i].list(i);
        }
    }
}

// 员工链表
class EmployeeLinkList {
    public Employee head; // 默认是null

    // 添加动作
    public void add(Employee employee) {
        if (head == null) {
            head = employee;
            return;
        }
        Employee temp = head;
        while (true) {

            if (temp.next == null) {
                temp.next = employee;
                return;
            }
            temp = temp.next;
        }
    }

    public void update(Employee employee) {
        Employee temp = head;
        while (temp != null) {
            if (temp.getId() == employee.getId()) {
                temp.setName(employee.getName());
                temp.setAge(employee.getAge());
                temp.setSex(employee.getSex());
                return;
            }
            temp = temp.next;
        }
    }

    public void delete(Employee employee) {
    }

    // 遍历
    public void list(int n) {
        if (head == null) {
            // 说明链表为空
            System.out.printf("第%d链表为空链表\n", n);
        }
        Employee temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

/**
 * 链表节点
 */
class Employee {
    private int id;
    private String name;
    private String sex;
    private int age;
    public Employee next;

    public Employee(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
