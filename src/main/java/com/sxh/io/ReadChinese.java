package com.sxh.io;/**
 * Created by SXH on 2020/3/20 0:03.
 */

import java.io.*;

/**
 * @author SXH
 * @description
 * @date 2020/3/20 0:03.
 */
public class ReadChinese {
	public static void main(String[] args) throws Exception {
		String filePath = "F:\\project\\testio.txt";

		System.out.println(readTxt(filePath));
	}

	//	读取文件
	public static String readTxt(String path) throws Exception {
		StringBuilder str = new StringBuilder();
		InputStreamReader isr = new InputStreamReader(new FileInputStream(path),"UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while ((line = br.readLine()) != null) {
			str.append(line + "\n");
		}
		return str.toString();
	}

}
