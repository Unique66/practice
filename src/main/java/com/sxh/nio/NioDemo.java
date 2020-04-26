package com.sxh.nio;/**
 * Created by SXH on 2020/3/16 16:13.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

/**
 * @author SXH
 * @description
 * @date 2020/3/16 16:13.
 */
public class NioDemo {
	public static void main(String[] args)  {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(new File("F:\\project\\testio.txt"));
			FileChannel channel = fileInputStream.getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			int read = channel.read(byteBuffer);
			System.out.println(read);
			while (read != -1) {
				// 当向buffer写入数据时，buffer会记录下写了多少数据，一旦要读取数据，
				// 需要通过flip()方法将Buffer从写模式切换到读模式，在读模式下可以读取之前写入到buffer的所有数据，
				// 一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入。
				byteBuffer.flip();
				while (byteBuffer.hasRemaining()) {
					System.out.println((char)byteBuffer.get());
				}
				//   clear方法清空缓冲区；compact方法只会清空已读取的数据，而还未读取的数据继续保存在Buffer中；
				byteBuffer.compact();
				read = channel.read(byteBuffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
