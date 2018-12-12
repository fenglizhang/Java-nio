package com.cn.wanmigaokong;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用buffer读写数据遵循四个步骤 1.写入数据到buffer 2.调用flip()方法 3.从buffer中读取数据
 * 4.调用clear()或者compact()方法清空buffer
 * 
 * 当向buffer写入数据时，buffer会记录下写了多少数据。一旦要读取数据，需要通过flip()方法将Buffer从写模式切换到读模式。在读模式下，
 * 可以读取 之前写入到buffer的所有数据。 一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入。清空缓冲区用的方法有两种：
 * 1.clear()方法--会清空所有的缓冲区，无论是否还存在未读数据。
 * 2.compact()方法---会清空所有已经读取的额数据，对于没有读取的数据会移动到缓冲读区的起始端，新加入缓冲区的数据会放到这些未度数据的额后面。
 * 
 * @author Administrator
 * 
 */
public class BufferDemo {
	public static void main(String[] args) throws IOException {
		RandomAccessFile aFile = new RandomAccessFile(
				"F:/testFile/student.xml", "rw");
		//把整个文件读取到通道中。
		FileChannel inChannel = aFile.getChannel();
		//从通道每次往缓冲区允许放入最大数量为：48个字节。字节对字母和符号是一个对应一个字节。汉字为两个字节。
		ByteBuffer buf = ByteBuffer.allocate(48);
		int bytesRead = inChannel.read(buf);
		while (bytesRead != -1) {
			//将buffer由写变为读的状态
			buf.flip();
			while (buf.hasRemaining()) {
				//每次读取一个字节并打印出来。
				System.out.print((char) buf.get());
			}
			//清空buffer，为重新往buffer内写数据做准备。
			buf.clear();
			bytesRead = inChannel.read(buf);

		}
		aFile.close();
	}
}
