package com.ashrafzyanov.taskmanager.server

import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelPipeline
import io.netty.channel.socket.SocketChannel
import io.netty.handler.codec.http.HttpRequestDecoder
import io.netty.handler.codec.http.HttpResponseEncoder

class ServerInit() : ChannelInitializer<SocketChannel>() {

    override fun initChannel(ch: SocketChannel?) {
        var p: ChannelPipeline = ch!!.pipeline();
        p.addLast(HttpRequestDecoder())
        p.addLast(HttpResponseEncoder())
        p.addLast(HttpServerHandler())

    }

}