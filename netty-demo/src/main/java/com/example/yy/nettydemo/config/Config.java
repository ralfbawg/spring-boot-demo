package com.example.yy.nettydemo.config;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.example.yy.nettydemo.StringProtocolInitalizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

@Configuration
public class Config {
    @Value("${netty.boss.thread.count}")
    private int bossCount;

    @Value("${netty.worker.thread.count}")
    private int workerCount;

    @Value("${netty.tcp.port}")
    private int tcpPort;

    @Value("${netty.so.keepalive}")
    private boolean keepAlive;

    @Value("${netty.so.backlog}")
    private int backlog;

    @Autowired
    @Qualifier("springProtocolInitializer")
    private StringProtocolInitalizer protocolInitalizer;

    @SuppressWarnings("unchecked")
    @Bean(name = "serverBootstrap")
    public ServerBootstrap bootstrap() {
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup(), workerGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(protocolInitalizer);
        Map<ChannelOption<?>, Object> tcpChannelOptions = tcpChannelOptions();
        Set<ChannelOption<?>> keySet = tcpChannelOptions.keySet();
        for (@SuppressWarnings("rawtypes")
                ChannelOption option : keySet) {
            b.option(option, tcpChannelOptions.get(option));
        }
        for (@SuppressWarnings("rawtypes")
                ChannelOption option : keySet) {
            b.childOption(option, tcpChannelOptions.get(option));
        }
        return b;
    }

    @Bean(name = "bossGroup", destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup bossGroup() {
        return new NioEventLoopGroup(bossCount);
    }

    @Bean(name = "workerGroup", destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup workerGroup() {
        return new NioEventLoopGroup(workerCount);
    }

    @Bean(name = "tcpSocketAddress")
    public InetSocketAddress tcpPort() {
        return new InetSocketAddress(tcpPort);
    }

    @Bean(name = "tcpChannelOptions")
    public Map<ChannelOption<?>, Object> tcpChannelOptions() {
        Map<ChannelOption<?>, Object> options = new HashMap<ChannelOption<?>, Object>();
        options.put(ChannelOption.SO_KEEPALIVE, keepAlive);
        options.put(ChannelOption.SO_BACKLOG, backlog);
        return options;
    }

    @Bean(name = "tcpChildOptions")
    public Map<ChannelOption<?>, Object> tcpChildOptions() {
        Map<ChannelOption<?>, Object> options = new HashMap<ChannelOption<?>, Object>();
        options.put(ChannelOption.TCP_NODELAY, true);
        return options;
    }

    @Bean(name = "stringEncoder")
    public StringEncoder stringEncoder() {
        return new StringEncoder();
    }

    @Bean(name = "stringDecoder")
    public StringDecoder stringDecoder() {
        return new StringDecoder();
    }

    /**
     * Necessary to make the Value annotations work.
     *
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
