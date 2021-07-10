/*
 * Copyright (c) 2021.  User:Unique66 File:NC63CardRunner.java
 * Date:2021/07/10 22:36:10
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author Unique66
 * @description NC63 扑克牌顺子
 * @date 2021/7/10 22:36
 *
 * https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4?tpId=117&&tqId=37758&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 现在有2副扑克牌，从扑克牌中随机五张扑克牌，我们需要来判断一下是不是顺子。
 * 有如下规则：
 * 1. A为1，J为11，Q为12，K为13，A不能视为14
 * 2. 大、小王为 0，0可以看作任意牌
 * 3. 如果给出的五张牌能组成顺子（即这五张牌是连续的）就输出true，否则就输出false。
 * 例如：给出数据[6,0,2,0,4]
 * 中间的两个0一个看作3，一个看作5 。即：[6,3,2,5,4]
 * 这样这五张牌在[2,6]区间连续，输出true
 * 数据保证每组5个数字，每组最多含有4个零，数组的数取值为 [0, 13]
 *
 * 示例1
 * 输入：[6,0,2,0,4]
 * 返回值：true
 *
 * 示例2
 * 输入：[0,3,2,6,4]
 * 返回值：true
 *
 * 示例3
 * 输入：[1,0,0,1,0]
 * 返回值：false
 *
 * 示例4
 * 输入：[13,12,11,0,1]
 * 返回值：false
 */
public class NC63CardRunner {
    public boolean IsContinuous(int [] numbers) {
        return false;
    }
}
