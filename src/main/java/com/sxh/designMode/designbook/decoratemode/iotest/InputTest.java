package com.sxh.designMode.designbook.decoratemode.iotest;/**
 * Created by SXH on 2020/1/22 23:34.
 */

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author SXH
 * @description
 * @date 2020/1/22 23:34.
 */
public class InputTest {
	public static void main(String[] args) {
		int c;
		try {
			InputStream in =
					new LowerCaseInputStream(
						new BufferedInputStream(
								new FileInputStream("F:/project/testio.txt")));
			while ((c = in.read()) >= 0) {
				System.out.print((char) c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
