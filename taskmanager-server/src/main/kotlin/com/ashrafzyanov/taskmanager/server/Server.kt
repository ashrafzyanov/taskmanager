package com.ashrafzyanov.taskmanager.server

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.EventLoopGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.logging.LogLevel
import io.netty.handler.logging.LoggingHandler
import kotlin.reflect.typeOf

class Server {
    fun start(args: Array<String>?) {
        var bossGroup: EventLoopGroup = NioEventLoopGroup(1);
        var workerGroup: EventLoopGroup = NioEventLoopGroup();

        try {
            var b: ServerBootstrap  = ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel::class.java)
                    .handler(LoggingHandler(LogLevel.INFO))
                    .childHandler(null);

            var ch: Channel = b.bind(8080).sync().channel();

            error("Some error");

            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

    
}