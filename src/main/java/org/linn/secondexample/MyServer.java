package org.linn.secondexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LoggingHandler;



public class MyServer {

    public static void main(String[] args) {
        MyServer.start(8088);
    }

    public static void start(int port) {
        //建立2个线程池，基于reactive编程模型
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //boss 获得请求后转发给work去执行
        EventLoopGroup workGroup = new NioEventLoopGroup();
        //服务端启动类
        ServerBootstrap bootstrap = new ServerBootstrap();
        //绑定到channelHandler
        bootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler())
                .childHandler(new MyServerInitializer());
        try {
            ChannelFuture channelFuture = bootstrap.bind(port).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException ignore) {
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }
}
