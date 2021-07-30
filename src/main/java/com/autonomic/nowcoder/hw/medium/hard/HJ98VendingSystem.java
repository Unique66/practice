/*
 * Copyright (c) 2021.  User:Unique66 File:HJ98VendingSystem.java
 * Date:2021/07/31 02:46:31
 */

package com.autonomic.nowcoder.hw.medium.hard;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ98 自动售货系统
 * @date 2021/7/31 2:46
 * <p>
 * https://www.nowcoder.com/practice/cd82dc8a4727404ca5d32fcb487c50bf?tpId=37&&tqId=21321&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 */
public class HJ98VendingSystem {
    static String[] goodsName = {"A1", "A2", "A3", "A4", "A5", "A6"};
    static int[] goodsCount = {0, 0, 0, 0, 0, 0};
    static int[] goodsValue = {2, 3, 4, 5, 8, 6};
    static int realBalance = 0;
    static LinkedHashMap<Integer, Integer> balanceMap = new LinkedHashMap<>();

    static {
        balanceMap.put(1, 0);
        balanceMap.put(2, 0);
        balanceMap.put(5, 0);
        balanceMap.put(10, 0);
    }

    private static void init(int[] datas) {
        goodsCount[0] = datas[0];
        goodsCount[1] = datas[1];
        goodsCount[2] = datas[2];
        goodsCount[3] = datas[3];
        goodsCount[4] = datas[4];
        goodsCount[5] = datas[5];
        balanceMap.put(1, datas[6]);
        balanceMap.put(2, datas[7]);
        balanceMap.put(5, datas[8]);
        balanceMap.put(10, datas[9]);
        System.out.println("S001:Initialization is successful");
    }

    private static int getLeftGoodsCount() {
        int count = 0;
        for (int i : goodsCount) {
            count += i;
        }
        return count;
    }

    private static int getMoneyLeft(int[] queryKey) {
        int money = 0;
        if (queryKey == null) {
            for (Map.Entry<Integer, Integer> entry : balanceMap.entrySet()) {
                Integer value = entry.getKey();
                Integer count = entry.getValue();
                money += value * count;
            }
        } else {
            for (int i : queryKey) {
                Integer count = balanceMap.get(i);
                money += i * count;
            }
        }
        return money;
    }

    private static void pay(int value) {
        Integer moneyKeyCount = balanceMap.get(value);
        if (moneyKeyCount == null) {
            System.out.println("E002:Denomination error");
            return;
        }
        if (value > 2) {
            if (getMoneyLeft(new int[]{1, 2}) < value) {
                System.out.println("E003:Change is not enough, pay fail");
                return;
            }
        }
        if (value > 10) {
            System.out.println("E004:Pay the balance is beyond the scope biggest");
            return;
        }
        if (getLeftGoodsCount() <= 0) {
            System.out.println("E005:All the goods sold out");
            return;
        }
        realBalance += value;

        moneyKeyCount += 1;
        balanceMap.put(value, moneyKeyCount);

        System.out.println("S002:Pay success,balance=" + realBalance);
    }

    private static void buy(String inputName) {
        int goodsIndex = -1;
        for (int i = 0; i < goodsName.length; i++) {
            if (inputName.equals(goodsName[i])) {
                goodsIndex = i;
                break;
            }
        }
        if (goodsIndex == -1) {
            System.out.println("E006:Goods does not exist");
            return;
        }
        if (goodsCount[goodsIndex] <= 0) {
            System.out.println("E007:The goods sold out");
            return;
        }
        if (realBalance < goodsValue[goodsIndex]) {
            System.out.println("E008:Lack of balance");
            return;
        }

        realBalance -= goodsValue[goodsIndex];
        System.out.println("S003:Buy success,balance=" + realBalance);

    }

    private static void quit() {
        if (realBalance <= 0) {
            System.out.print("E009:Work failure");
            return;
        }
        int[] quitCount = {0, 0, 0, 0};
        while (realBalance > 0) {
            int tmpBalance = realBalance;
            int balanceMapTmpGet = balanceMap.get(10);
            if (realBalance >= 10 && balanceMapTmpGet > 0) {
                realBalance -= 10;
                balanceMap.put(10, balanceMapTmpGet - 1);
                quitCount[3] += 1;
                continue;
            }
            balanceMapTmpGet = balanceMap.get(5);
            if (realBalance >= 5 && balanceMapTmpGet > 0) {
                realBalance -= 5;
                balanceMap.put(5, balanceMapTmpGet - 1);
                quitCount[2] += 1;
                continue;
            }
            balanceMapTmpGet = balanceMap.get(2);
            if (realBalance >= 2 && balanceMapTmpGet > 0) {
                realBalance -= 2;
                balanceMap.put(2, balanceMapTmpGet - 1);
                quitCount[1] += 1;
                continue;
            }
            balanceMapTmpGet = balanceMap.get(1);
            if (realBalance >= 1 && balanceMapTmpGet > 0) {
                realBalance -= 1;
                balanceMap.put(1, balanceMapTmpGet - 1);
                quitCount[0] += 1;
                continue;
            }
            if (tmpBalance == realBalance) {
                break;
            }
        }
        System.out.println("1 yuan coin number=" + quitCount[0]);
        System.out.println("2 yuan coin number=" + quitCount[1]);
        System.out.println("5 yuan coin number=" + quitCount[2]);
        System.out.println("10 yuan coin number=" + quitCount[3]);
    }

    private static void query(int type) {
        if (type == 0) {
            for (int i = 0; i < goodsName.length; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(goodsName[i]).append(" ")
                        .append(goodsValue[i]).append(" ")
                        .append(goodsCount[i]);
                System.out.println(sb.toString());
            }
        } else if (type == 1) {
            for (Map.Entry<Integer, Integer> entry : balanceMap.entrySet()) {
                Integer value = entry.getKey();
                Integer count = entry.getValue();
                StringBuilder sb = new StringBuilder();
                sb.append(value).append(" yuan coin number=").append(count);
                System.out.println(sb.toString());
            }
        } else {
            System.out.print("E010:Parameter error");
        }
    }

    private static void orderParserExecute(String order) {
        char orderType = order.charAt(0);
        String orderData = null;
        if (order.length() > 2) {
            orderData = order.substring(2, order.length()).trim();
        }
        switch (orderType) {
            case 'r':
                orderData = orderData.replace("-", " ");
                String[] datas = orderData.split(" ");
                int[] intDatas = new int[datas.length];
                for (int i = 0; i < datas.length; i++) {
                    intDatas[i] = Integer.parseInt(datas[i]);
                }
                init(intDatas);
                break;
            case 'p':
                int payData = Integer.parseInt(orderData);
                pay(payData);
                break;
            case 'b':
                buy(orderData);
                break;
            case 'c':
                quit();
                break;
            case 'q':
                if (orderData == null) {
                    query(-1);
                } else {
                    int queryType = Integer.parseInt(orderData);
                    query(queryType);
                }

                break;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String inputStr = sc.nextLine();
            String[] orders = inputStr.split(";");
            realBalance = 0;
            for (String order : orders) {
                order = order.trim();
                if (order.length() == 0) {
                    continue;
                }
                orderParserExecute(order);
            }
        }
    }
}
