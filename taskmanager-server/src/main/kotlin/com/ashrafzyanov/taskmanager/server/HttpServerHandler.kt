package com.ashrafzyanov.taskmanager.server

import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.handler.codec.http.HttpRequest
import java.util.*

class HttpServerHandler : SimpleChannelInboundHandler<Objects>() {
    override fun channelRead0(ctx: ChannelHandlerContext?, msg: Objects?) {
    }

}