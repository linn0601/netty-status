package org.linn.sevenexample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * DirectByteBuffer 是直接在内存中创建数组，不需要在堆中创建。使用了零拷贝
 */
public class NioDirectBuffer {

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("write.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("text.txt");
        FileChannel fileChannel = fileInputStream.getChannel();
        FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();
        //底层使用new DirectByteBuffer()创建一个直接的buffer对象
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10);
    }
}
