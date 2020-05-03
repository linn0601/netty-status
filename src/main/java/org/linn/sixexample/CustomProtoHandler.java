package org.linn.sixexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class CustomProtoHandler extends SimpleChannelInboundHandler<PersonProto.Person> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProto.Person msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(PersonProto.Person.newBuilder()
                .setName("李超")
                .setAddress("广州市天河区科技园")
                .setAge(22));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
