package com.rpc.core.netty.server;

import com.rpc.core.netty.common.RpcDecoder;
import com.rpc.core.netty.common.RpcEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

/**
 * @projectName: rpc-demo
 * @package: com.rpc.core.netty
 * @className: RpcNettyServer
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 17:20
 */
@Slf4j
public class RpcNettyServer {

    private ApplicationContext context;

    private EventLoopGroup boss;
    private EventLoopGroup worker;
    private int port;

    public RpcNettyServer(int port) {
        this.port = port;
    }

    public void destroy() {
        worker.shutdownGracefully();
        boss.shutdownGracefully();
    }

    public void run() throws Exception {
        boss = new NioEventLoopGroup(1);
        worker = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        ChannelPipeline pipeline = channel.pipeline();
                        pipeline.addLast("Message Encoder", new RpcEncoder());
                        pipeline.addLast("Message Decoder", new RpcDecoder());
                        pipeline.addLast("Message Handler", new RpcNettyServerHandler(context));
                    }
                });

        Channel channel = serverBootstrap.bind(port).sync().channel();
        log.info("Netty server listen in port: " + port);
        channel.closeFuture().sync();
    }
}
