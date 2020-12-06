/*
 * Copyright (c) 2020.  User:SXH  File:HuffmanCode.java
 * Date:2020/12/06 20:10:06
 */

package com.autonomic.datastructures.tree.huffman;

import java.io.*;
import java.util.*;

/**
 * @author SXH
 * @description 赫夫曼编码压缩
 * @date 2020/12/6 20:10
 */
public class HuffmanCode {
    public static void main(String[] args) {
        // 测试2进制转byte   byte 是8位，所以八位2进制的第一位是符号位
//        String strByte = "10101000";
//        System.out.println((byte)Integer.parseInt(strByte, 2));


        // 测试压缩
        String str = "i like like like java do you like a java";
        System.out.println("压缩前: " + str);

        byte[] bytes = str.getBytes();
        byte[] bytesZip = zip(bytes);
        System.out.println("压缩后: " + Arrays.toString(bytesZip));

        // 测试解压
        byte[] unZipBytes = unzip(bytesZip);
        String s1 = new String(unZipBytes);
        System.out.println("解压后: " + s1);

        // 测试文件压缩
//        zipFile("F:/project/test/hua.png", "F:/project/test/testZip.zip");

        // 测试文件解压
//        unzipFile("F:/project/test/testZip.zip", "F:/project/test/huaUnzip.png");
    }

    /**
     * 解压缩文件
     *
     * @param path       待解压文件
     * @param targetPath 解压后文件存储路径
     */
    public static void unzipFile(String path, String targetPath) {
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(new File(path));
            objectInputStream = new ObjectInputStream(fileInputStream);
            byte[] bytes = (byte[]) objectInputStream.readObject(); // 将压缩byte[] 按对象读取
            huffmanCodes = (Map<Byte, String>) objectInputStream.readObject(); // 将赫夫曼编码表按对象读取

            byte[] unzipBytes = unzip(bytes);
            fileOutputStream = new FileOutputStream(new File(targetPath));
            fileOutputStream.write(unzipBytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("unzip over!");
        }
    }

    /**
     * 压缩文件
     *
     * @param path       待压缩文件
     * @param targetPath 压缩后文件存储路径
     */
    public static void zipFile(String path, String targetPath) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(path));
            byte[] bytes = new byte[fileInputStream.available()];
            // 读取待压缩文件的bytes 数组
            fileInputStream.read(bytes);
            byte[] zipBytes = zip(bytes);

            fileOutputStream = new FileOutputStream(new File(targetPath));
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(zipBytes); // 将待压缩byte[] 按对象写入
            objectOutputStream.writeObject(huffmanCodes); // 将赫夫曼编码表按对象写入
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("zip over!");
        }
    }

    /**
     * 将数据解压
     **/
    public static byte[] unzip(byte[] bytes) {
        // 1.先将压缩后的byte 还原成二进制的字符串
        String s = bytesToString(bytes);
        // 2.然后通过赫夫曼编码表 一一对应获得对应字符
        byte[] unZipBytes = getUnZipString(s);
        return unZipBytes;
    }


    /**
     * 将压缩的所有步骤封装
     **/
    public static byte[] zip(byte[] bytes) {
        // 1. 获取字符串对应的NodeList
        List<Node> nodeList = getNodes(bytes);
        // 2. 将NodeList 组合成赫夫曼树
        Node huffmanTree = getHuffmanTree(nodeList);
//        preOrder(huffmanTree); // 校验生成的树是否有问题
        // 3. 通过赫夫曼树获得赫夫曼编码表（向左0，向右1）
        getHuffmanCodes(huffmanTree, "", stringBuilder);
//        System.out.println(huffmanCodes.toString());
        // 4. 将字符串通过其赫夫曼编码表，返回一个赫夫曼编码压缩后的byte[]
        byte[] bytesZip = strToCompress(bytes, huffmanCodes);
        return bytesZip;
    }

    /***************************   UNZIP     *********************************************/

    private static String bytesToString(byte[] bytes) {
        StringBuilder resultStr = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            if (i == bytes.length - 1) { // 最后一个字节不需要补高位
                resultStr.append(byteToBitString(bytes[i], false));
            } else {
                resultStr.append(byteToBitString(bytes[i], true));
            }
        }
//        System.out.println(resultStr.toString());
        return resultStr.toString();
    }

    /**
     * 将压缩后的byte[] 先转为bit 组成的String
     *
     * @param b    压缩后的byte
     * @param flag 是否需要高位补位
     * @return BitString 是b 对应的二进制字符串，按照补码返回的
     */
    private static String byteToBitString(byte b, boolean flag) {
        int temp = b;
        // int 是4*8 32位，所以需要截取，并且为了让 1 这样的byte 在截取时不下标越界，需要补高位
        if (flag) {
            temp |= 256; // 按位与256 1 0000 0000  | 0000 0001 => 1 0000 0001
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    private static byte[] getUnZipString(String str) {
        // 将赫夫曼编码表调换位置
        Map<String, Byte> revertHuffmanCodes = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            revertHuffmanCodes.put(entry.getValue(), entry.getKey());
        }
//        System.out.println(revertHuffmanCodes.toString());
        // 将str 按照调换后的赫夫曼编码表找到对应的字符串原值
        char[] chars = str.toCharArray();
        List<Byte> list = new ArrayList<>();
        StringBuilder tempStr = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            tempStr.append(chars[i]);
            Byte b = revertHuffmanCodes.get(tempStr.toString());
            if (b != null) {
                list.add(b);
                tempStr = new StringBuilder();
            }
        }
        byte[] resultByte = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resultByte[i] = list.get(i);
        }
        return resultByte;
    }


/***************************   ZIP     *********************************************/
    /**
     * 1.获取str 字符串的字符权重 的信息列表
     *
     * @return 带有传入字符串全量字符的权值 的节点列表
     * [Node{data=32, weight=9}, Node{data=97, weight=5}, Node{data=100, weight=1}, Node{data=101, weight=4}, Node{data=117, weight=1}, Node{data=118, weight=2}, Node{data=105, weight=5}, Node{data=121, weight=1}, Node{data=106, weight=2}, Node{data=107, weight=4}, Node{data=108, weight=4}, Node{data=111, weight=2}]
     * @param: str 待处理的字符串
     */
    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodeList = new ArrayList<>();
        // 遍历字节数组，先存放到map 里面
        HashMap<Byte, Integer> byteIntegerHashMap = new HashMap<>(); // 存放字符及其权重
        for (Byte b : bytes) {
            Integer weight = byteIntegerHashMap.get(b);
            if (weight == null) {
                byteIntegerHashMap.put(b, 1);
            } else {
                byteIntegerHashMap.put(b, weight + 1);
            }
        }
        // 将Node 对应的字符和其权重信息存放到nodeList 当中
        for (Map.Entry<Byte, Integer> entry : byteIntegerHashMap.entrySet()) {
            nodeList.add(new Node(entry.getKey(), entry.getValue()));
        }
//        System.out.println(nodeList.toString()); // 测试nodeList 创建的是否正确
        // 然后就可以组成赫夫曼树了
        return nodeList;
    }

    /**
     * 2.根据字符、权重列表创建赫夫曼树
     *
     * @param nodeList 待处理的带有权值信息的赫夫曼树
     * @return 赫夫曼树
     */
    private static Node getHuffmanTree(List<Node> nodeList) {
        while (nodeList.size() > 1) {
            // 首先对nodeList 根据权值排序
            Collections.sort(nodeList);
//        System.out.println(nodeList);
            // 取列表前两个（权值较小）节点当左右子节点，获得父节点
            Node leftNode = nodeList.get(0);
            Node rightNode = nodeList.get(1);
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            // 将左右子节点放到父节点后面
            parent.left = leftNode;
            parent.right = rightNode;
            // 将组节点放入到nodeList 中
            nodeList.add(parent);
            // 将之前用过的两个子节点从nodeList 中拿走
            nodeList.remove(leftNode);
            nodeList.remove(rightNode);
            // 这个过程需要一个循环，直到nodeList 元素只有一个
        }
        // 如果跳出循环，说明已经组好了
        return nodeList.get(0);
    }

    /**
     * 前序遍历
     **/
    private static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("赫夫曼树为空");
        }
    }

    /**
     * 3.根据赫夫曼树获得赫夫曼编码
     * 思路：
     * 1).将赫夫曼编码表放到一个map 集合中  Map<Byte, String>
     * 32->01 97->100 100->11000 等
     * 2).map 对应的value 需要一个StringBuilder 去存放
     */
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    /**
     * 遍历赫夫曼树，获取其对应的赫夫曼编码
     *
     * @param node          赫夫曼树的根节点
     * @param code          路径：左子节点是0，右子节点是1
     * @param stringBuilder 用来拼接每个字符对应的路径
     */
    private static void getHuffmanCodes(Node node, String code, StringBuilder stringBuilder) {
        // 根据传进来的StringBuilder 创建一个新的字符缓冲
        StringBuilder tempStringBuilder = new StringBuilder(stringBuilder);
        // 根据传进来的code 向字符缓冲里面添加
        tempStringBuilder.append(code);
        // 处理传进来的node
        if (node != null) { // node 为空就不需要处理了
            // 不为空就需要先判断当前节点是否走到了叶子节点
            if (node.data != null) { // == null 表示是非叶子节点需要继续向下，否则就放入到赫夫曼编码中
                huffmanCodes.put(node.data, tempStringBuilder.toString());
            } else {
                // 左遍历
                getHuffmanCodes(node.left, "0", tempStringBuilder);
                // 右遍历
                getHuffmanCodes(node.right, "1", tempStringBuilder);
            }
        }
    }

    /**
     * 4.将字符串通过其赫夫曼编码表，返回一个赫夫曼编码压缩后的byte[]
     *
     * @param bytes        待压缩的字节数组
     * @param huffmanCodes 带压缩字符串对应的赫夫曼编码表
     */
    private static byte[] strToCompress(byte[] bytes, Map<Byte, String> huffmanCodes) {
        // 1.利用赫夫曼编码表，将str 转成和夫曼编码对应的字符串
        StringBuilder resultStr = new StringBuilder(); // 存放赫夫曼编码表转码后的编码
        for (byte b : bytes) {
            resultStr.append(huffmanCodes.get(b));
        }
//        System.out.println(resultStr);
        // 此时resultStr 里面存放的是赫夫曼编码表转码后的0/1 组成的字符串，
        // 需要将其转成byte[]  每8位对应一个byte
        String strZip = resultStr.toString();
        int c = strZip.length() % 8 == 0 ? 0 : 1; // 如果不是8的倍数，那么待处理byte 个数就得 /8 后再多一个
        int size = strZip.length() / 8 + c;
        byte[] result = new byte[size];
        for (int i = 0; i < size; i++) {
            String substring;
            if (i * 8 + 8 > strZip.length()) {
                substring = strZip.substring(i * 8);
            } else {
                substring = strZip.substring(i * 8, i * 8 + 8); // 这里 i*8+8 可能越界
            }
            // 将字符串按2进制转10进制，然后再转为 byte 类型
            result[i] = (byte) Integer.parseInt(substring, 2);
        }
        return result;
    }
}

class Node implements Comparable<Node> {
    Byte data; // 存放数据（字符）本身  比如'a' => 97   ' ' => 32
    int weight; //权值，表示字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        // 从小到大排序
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    // 前序遍历，用来确认赫夫曼树的数据准确性
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
