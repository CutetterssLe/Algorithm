package com.xing.leetcode.netty;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Mystery
 */
public class NettyServer {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_ACCEPT);

        ServerSocket socket = channel.socket();

        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8888);

        socket.bind(inetSocketAddress);



        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel channel1 = (ServerSocketChannel) key.channel();
                    SocketChannel accept = channel1.accept();
                    accept.configureBlocking(false);

                    accept.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    SocketChannel sChannel = (SocketChannel) key.channel();
                    System.out.println(readDataFromSocketChannel(sChannel));
                    sChannel.close();
                }
                iterator.remove();
            }
        }
    }

    private static String readDataFromSocketChannel(SocketChannel channel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String s = null;
        while (true) {
            buffer.clear();
            int read = channel.read(buffer);
            if (read == -1) {
                break;
            }
            buffer.flip();
            int limit = buffer.limit();
            byte[] chars = new byte[limit];
            for (int i = 0; i < limit; i++) {
                chars[i] = buffer.get(i);
            }
            s = new String(chars, Charset.defaultCharset());
            buffer.clear();
        }
        return s;
    }
}
