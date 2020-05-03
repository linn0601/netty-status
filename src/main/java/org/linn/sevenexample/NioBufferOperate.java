package org.linn.sevenexample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Buffer操作分析示例
 */
public class NioBufferOperate {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("text.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("write.txt");

        FileChannel fileInputStreamChannel = fileInputStream.getChannel();
        FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(512);

        while (true){
            buffer.clear();
            System.out.println(buffer.position());
            int read = fileInputStreamChannel.read(buffer);
            if (-1 == read){
                break;
            }
            buffer.clear();
            fileOutputStreamChannel.write(buffer);
        }
        fileInputStreamChannel.close();
        fileOutputStreamChannel.close();
    }
}
