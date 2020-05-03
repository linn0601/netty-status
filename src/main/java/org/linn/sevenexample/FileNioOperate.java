package org.linn.sevenexample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件Nio操作
 */
public class FileNioOperate {

    public static void main(String[] args) throws IOException {
        read();
        //write();
    }
    /**
     * NIO读操作
     * @throws IOException
     */
    public static void read() throws IOException {
        FileInputStream inputStream = new FileInputStream("text.txt");
        FileChannel channel = inputStream.getChannel();
        //设置大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        //通过buffer读channel中的信息到Buffer缓冲器(写buffer)
        channel.read(byteBuffer);
        //反转
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            byte b = byteBuffer.get();
            System.out.println("Character : " + (char)b);
        }
    }

    /**
     * NIO写操作
     * @throws IOException
     */
    public static void write() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("text.txt");
        FileChannel channel = outputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.wrap("cde".getBytes());
        channel.write(buffer);
        buffer.flip();
        outputStream.close();
    }

    /**
     * Buffer中三个概念 position limit capacity
     * position 是位置，进行flip操作时会重置为0
     * limit buffer中最后一个位置指向的下一个索引。小于capacity
     * capacity 容量 buffer 的最大值，不能被修改
     */
}
