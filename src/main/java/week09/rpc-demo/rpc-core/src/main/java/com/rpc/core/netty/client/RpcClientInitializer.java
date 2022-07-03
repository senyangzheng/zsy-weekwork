package com.rpc.core.netty.client;

import com.rpc.core.netty.common.RpcDecoder;
import com.rpc.core.netty.common.RpcEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @projectName: rpc-demo
 * @package: com.rpc.core.netty.client
 * @className: RpcClientInitializer
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 17:32
 */
public class RpcClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("Message Encoder", new RpcEncoder());
        pipeline.addLast("Message Decoder", new RpcDecoder());
        pipeline.addLast("clientHandler", new RpcClientSyncHandler());
    }
}
