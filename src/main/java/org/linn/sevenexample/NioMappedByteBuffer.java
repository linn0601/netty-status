package org.linn.sevenexample;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件内存映射文件学习
 */
public class NioMappedByteBuffer {

    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("write.txt", "rw");
        FileChannel fileChannel = file.getChannel();
        //将文件映射到内存中
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        //操作内存中的数据
        mappedByteBuffer.put(0, (byte) 'z');
        mappedByteBuffer.put(2, (byte) 'z');
        file.close();
        //文件中内容已经改变，通过文件管理器查看
    }
}
