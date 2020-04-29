# netty-study
netty 学习代码

基于Netty-all 4.1.49进行学习，采用gradle构建
#学习指南

1.了解常用的5中IO模型（同步阻塞IO、基于线程池的伪异步IO[不能够解决线程阻塞问题]、IO多路复用、信号驱动I/O、AIO）

2.netty 拥有许多编码器，了解编码器有助于基于各种协议使用netty

3.netty 能够搭建高吞吐量（轻量级）http服务器

4.掌握netty的核心API

--------------------------------------
概念

1.netty提供一个ChannelInboundHandlerAdapter适配器类，一共一组回调函数，如下：
channelActive （上线）、channelInactive（下线）、channelAdded（加入）
、channelRemoved（移除）、channelRegistered（注册）、channelUnregistered（销毁）

2.netty 的解码器 换行符（LineBasedFrameDecoder）/定长(FixedLengthFrameDecoder)/分隔符(DelimiterBaseFrameDecoder)

3.心跳heart

4.二进制传输框架 GoogleProtobuf 编解码

---------------------------------------
项目src/main
1.first  netty搭建一个简单服务
2.second netty搭建客户端和服务端，测试ChannelInboundHandlerAdapter下回调函数
3.third  netty搭建简单群聊功能
4.fourth netty心跳 userEventTriggered("用户事件被触发") IdleStatusEvent


