# netty-study
netty 学习代码

基于Netty-all 4.1.49进行学习，采用gradle构建

1.netty提供一个ChannelInboundHandlerAdapter适配器类，一共一组回调函数，如下：
channelActive （上线）、channelInactive（下线）、channelAdded（加入）
、channelRemoved（移除）、channelRegistered（注册）、channelUnregistered（销毁）

2.netty 拥有许多编码器，了解编码器有助于基于各种协议使用netty

3.netty 能够搭建高吞吐量（轻量级）http请求

4.掌握netty的核心API
