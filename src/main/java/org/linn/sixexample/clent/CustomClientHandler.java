package org.linn.sixexample.clent;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.linn.sixexample.PersonProto;

public class CustomClientHandler extends SimpleChannelInboundHandler<PersonProto.Person> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProto.Person msg) throws Exception {
        System.out.println(msg.getName());
        System.out.println(msg.getAge());
        System.out.println(msg.getAddress());
    }
}
