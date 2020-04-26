package com.sxh.designMode.designpractic.decoratorpattern;/**
 * Created by SXH on 2020/3/17 21:09.
 */


import java.io.*;

/**
 * @author SXH
 * @description 测试UpperCaseInputStream.java
 * @date 2020/3/17 21:09.
 */
public class InputTest {
	public static void main(String[] args) throws IOException {
		String Filename = "F:\\project\\testio.txt";
		FileInputStream fileInputStream = new FileInputStream(Filename);
		int c;
		InputStream in = new UpperCaseInputStream(new BufferedInputStream(fileInputStream));
		while ((c=in.read()) >= 0) {
			System.out.println("&&&&" + c);
			System.out.println((char)c);
		}
		in.close();

		Writer writer = new FileWriter(Filename, true);
		writer.write("\n \t 北京欢迎你!!!");
		writer.close();

		File file = new File(Filename);
		FileOutputStream fos = new FileOutputStream(file, true);
		OutputStream outputStream = new BufferedOutputStream(fos);
		outputStream.write("\n \t 北京欢迎你哈哈哈!!!".getBytes());
		outputStream.close();


		Reader reader = new FileReader(Filename);
		char [] chars = new char[1024];
//		reader.read(chars);
		while ((c=reader.read(chars)) >= 0) {
			System.out.println("￥￥￥" + c);
			System.out.println((char)c);
		}
	}
}
