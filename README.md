# netty-study
netty 学习代码

基于Netty-all 4.1.49进行学习，采用gradle构建
#学习指南

- 1.了解常用的5中IO模型（同步阻塞IO、基于线程池的伪异步IO[不能够解决线程阻塞问题]、IO多路复用、信号驱动I/O、AIO）

- 2.netty 拥有许多编码器，了解编码器有助于基于各种协议使用netty

- 3.netty 能够搭建高吞吐量（轻量级）http服务器

- 4.掌握netty的核心API

--------------------------------------
概念

- 1.netty提供一个ChannelInboundHandlerAdapter适配器类，一共一组回调函数，如下：channelActive （上线）、channelInactive（下线）、channelAdded（加入）、channelRemoved（移除）、channelRegistered（注册）、channelUnregistered（销毁）

- 2.netty 的解码器 换行符（LineBasedFrameDecoder）/定长(FixedLengthFrameDecoder)/分隔符(DelimiterBaseFrameDecoder)

- 3.心跳heart

- 4.二进制传输框架 GoogleProtobuf 编解码

---------------------------------------
####  src/main包介绍
- 1.first  netty搭建一个简单服务

- 2.second netty搭建客户端和服务端，测试ChannelInboundHandlerAdapter下回调函数

- 3.third  netty搭建简单群聊功能

- 4.fourth netty心跳 userEventTriggered("用户事件被触发") IdleStatusEvent

- 5.fifth  netty中WebSocket 编程 核心handler HttpObjectAggregator(消息聚合处理)、WebSocketHandlerProtocolHandler(简化WebSocket处理)ChunkedWriteHandler(对大量数据写入的支持，既不花费大量内存也不获取异步数据)

- 6.six java提供的序列化传输效率低，限制大。该模块引入Google ProtoBuf来进行消息传输的对象编解码工作。Netty提供了四个编解码器的使用都是以"ProtoBuf"开头的类

- 7.seven Nio中的三个概念Selector Channel Buffer，Buffer中 position、limit、capacity 的概念 Nio操作就是获取Channel对象，然后通过Buffer进行数据读写(切换使用flip())

- ByteBuffer中的三个底层实现类 HeadByteBuffer对象(堆中创建)、MappedByteBuffer对象(文件内存映射，操作内存中的buffer就可以操作文件)、DirectBytBuffer对象(在内存中创建，基于零拷贝)

.
+-- _config.yml
+-- _drafts
|   +-- begin-with-the-crazy-ideas.textile
|   +-- on-simplicity-in-technology.markdown
+-- _includes
|   +-- footer.html
|   +-- header.html
+-- _layouts
|   +-- default.html
|   +-- post.html
+-- _posts
|   +-- 2007-10-29-why-every-programmer-should-play-nethack.textile
|   +-- 2009-04-26-barcamp-boston-4-roundup.textile
+-- _data
|   +-- members.yml
+-- _site
+-- index.html
