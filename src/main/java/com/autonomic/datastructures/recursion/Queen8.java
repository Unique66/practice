package com.autonomic.datastructures.recursion;/**
 * Created by SXH on 2020/5/10 21:55.
 */

/**
 * @author SXH
 * @description 八皇后问题递归思想处理
 * @date 2020/5/10 21:55.
 * 思路：
 * 		1. 第一个皇后放入到第一行第一列
 * 		2. 第二个皇后放到第二行第一列，然后判断是否OK，如果不OK，继续放在第二列、第三列，直到找到合适的
 * 		3. 第二步找到合适的后就放第三个皇后，还是第一列、第二列........直到第8 个皇后也能放一个不冲突的位置，就算找到一个正确的解了
 * 		4. 当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解，全部得到
 * 	 	5. 然后回头继续第一个皇后放第二列，后面继续循环执行1,2,3,4 的步骤
 */
public class Queen8 {
	public static int max = 8;
	// 使用一维数组来代替二维数组，比如 queen[8] = {0, 4, 7, 5, 2, 6, 1, 3}
	// index 下标代表二维数组的行，每个下标对应的值代表二维数组的列
	public static int [] queen = new int[max];
	public static int count = 0; // 记录一共有多少种摆放方式
	public static int judgeCount = 0; // 记录一共判定了多少次
	public static void main(String[] args) {
		check(0);// 从0,0 开始
		System.out.printf("一共有%d种摆放方式\n", count);
		System.out.printf("一共判断了%d次", judgeCount);
	}
	/**
	 * @Description // 放置皇后
	 * @param n 放置第n 个皇后
	 *  注：check 是每一次递归时，进入到check 中都有 for (int i = 0; i < max; i++),因此会有回溯（按序）
	 **/
	public static void check(int n) {
		if (n == max) { // n是递增的，当n 大于max 表明已经结束了八个八皇后位置的选择
			print();
			return;
		}
		// 依次放入皇后，并判断是否冲突
		for (int i = 0; i < max; i++) {
			// 先把当前这个皇后n ，放到该行的第一列
			queen[n] = i;
			if (judge(n)) { // 放置的皇后不冲突
				check(n + 1); // 紧接着就放入第n + 1 个皇后
			}
			// 如果冲突，就会继续for 循环，将第n 个皇后 放到i+1 列继续尝试
		}
	}

	// n 表示第n 个皇后
	public static boolean judge(int n) {
		judgeCount++;
		for (int i = 0; i < n; i++) {
			// 比较之前的皇后与当前皇后，如果在同一列，就不行
			// 然后比较与之前皇后是否在同一斜线
			// 因为是算法实现的一维数组表示二位数组棋盘，所以不用比较是否在同一行
			if ((queen[i] == queen[n]) || (Math.abs(n - i) == Math.abs(queen[n] - queen[i]))) {
				return false;
			}
		}
		return true;
	}

	// 需要一个print 公共方法打印满足条件的八皇后摆放
	public static void print() {
		count++;
		for (int i = 0; i < max; i++) {
			System.out.print(queen[i] + " ");
		}
		System.out.println();
	}
}
