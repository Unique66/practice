package com.autonomic.datastructures.recursion;/**
 * Created by SXH on 2020/5/6 22:41.
 */

/**
 * @author SXH
 * @description 用递归解决简单迷宫问题
 * @date 2020/5/6 22:41.
 */
public class Maze {
	public static void main(String[] args) {
		// 首先需要做一个迷宫
		int [][] maze = new int[8][7];
		// 1 代表迷宫的墙
		// 首先配置迷宫上下两堵墙
		for (int i = 0; i < 7; i++) {
			maze[0][i] = 1;
			maze[7][i] = 1;
		}
		// 然后配置迷宫左右两堵墙
		for (int i = 1; i < 7; i++) {
			maze[i][0] = 1;
			maze[i][6] = 1;
		}
		// 加挡板
		maze[3][1] = 1;
		maze[3][2] = 1;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}

//		setWay(maze, 1, 1); // 下->右->上->左
		setWay2(maze, 1, 1); // 上->右->下->左
		System.out.println("小球走完后的地图");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
	}


	/**
	 * @Author SXH
	 * @Description 小球找路的方法
	 * @Date 2020/5/6  22:50
	 * @param maze 迷宫地图
	 * @param i 小球初始行
	 * @param j 小球初始列
	 *          如果小球到了 maze[6][5] 的位置表示路线走通了
	 *          也需要约定一些参数：2 表示小球走过的点，3 表示走不通的点
	 *          还需要约定小球走动的策略：如 下->右->上->左
	 **/
	public static boolean setWay(int[][] maze, int i, int j) {
		if (maze[6][5] == 2) { // 表示小球已经到达了终点
			return true;
		} else {
			// 如果当前点还没有走过
			if (maze[i][j] == 0) {
				// 那么就按照 下->右->上->左 策略走
				// 假定可以走通
				maze[i][j] = 2;
				if (setWay(maze, i + 1, j)) { // 向下走
					return true;
				} else if (setWay(maze, i, j + 1)) { // 向右走
					return true;
				} else if (setWay(maze, i - 1, j)) { // 向上走
					return true;
				} else if (setWay(maze, i, j - 1)) { // 向左走
					return true;
				} else { // 说明该点走不通 是死路
					maze[i][j] = 3;
					return false;
				}
			} else { // 如果maze[i][j] != 0  ,说明可能是 1/2/3
				return false;
			}
		}
	}

	// 上->右->下->左
	public static boolean setWay2(int[][] maze, int i, int j) {
		if (maze[6][5] == 2) { // 表示小球已经到达了终点
			return true;
		} else {
			// 如果当前点还没有走过
			if (maze[i][j] == 0) {
				// 那么就按照 上->右->下->左策略走
				// 假定可以走通
				maze[i][j] = 2;
				if (setWay2(maze, i - 1, j)) { // 向上走
					return true;
				} else if (setWay2(maze, i, j + 1)) { // 向右走
					return true;
				} else if (setWay2(maze, i + 1, j)) { // 向下走
					return true;
				} else if (setWay2(maze, i, j - 1)) { // 向左走
					return true;
				} else { // 说明该点走不通 是死路
					maze[i][j] = 3;
					return false;
				}
			} else { // 如果maze[i][j] != 0  ,说明可能是 1/2/3
				return false;
			}
		}
	}
}
