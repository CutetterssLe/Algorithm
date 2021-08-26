package com.xing.leetcode.netty;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Mystery
 */
public class NettyClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream outputStream = socket.getOutputStream();
        String s = "再见了";
        outputStream.write(s.getBytes("UTF-8"));
        outputStream.close();
    }
}
