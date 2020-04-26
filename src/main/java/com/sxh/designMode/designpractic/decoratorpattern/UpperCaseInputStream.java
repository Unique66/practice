package com.sxh.designMode.designpractic.decoratorpattern;/**
 * Created by SXH on 2020/3/17 21:04.
 */

import java.io.*;

/**
 * @author SXH
 * @description 使用装饰者模式加强IO类的功能
 * @date 2020/3/17 21:04.
 */
public class UpperCaseInputStream extends FilterInputStream {
	/**
	 * Creates a <code>FilterInputStream</code>
	 * by assigning the  argument <code>in</code>
	 * to the field <code>this.in</code> so as
	 * to remember it for later use.
	 *
	 * @param in the underlying input stream, or <code>null</code> if
	 *           this instance is to be created without an underlying stream.
	 */
	protected UpperCaseInputStream(InputStream in) {
		super(in);
	}

	@Override
	public int read() throws IOException {
		int c = super.read();
		return c == -1 ? c : Character.toUpperCase((char)c);
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int result = super.read(b, off, len);
		for (int i = 0; i < result; i++) {
			b[i] = (byte)Character.toUpperCase((char)(b[i]));
		}
		return result;
	}
}
