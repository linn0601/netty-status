package org.linn.firstexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class TestServer {

    public static void main(String[] args) {
        TestServer.start(8088);
    }

    /**
     * 服务端启动
     *
     * @param port 8088
     */
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
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast("httpServerCoder", new HttpServerCodec());
                        pipeline.addLast("httpServerHandler", new TestHttpServerHandler());//最后处理，addList添加到管道最后
                    }
                });
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
