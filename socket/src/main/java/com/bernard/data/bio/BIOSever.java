package com.bernard.data.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wdh
 */
public class BIOSever {
    private static final int PORT = 9090;

    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress("localhost", PORT));
        System.out.println("server started listening " + PORT);

        try {
            Socket s = null;
            while (true) {

                // 阻塞(等待客户端发送链接请求过来！)
                s = ss.accept();
                new Thread(new SeverTaskThread(s)).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ss != null) {
                ss.close();
                ss = null;
                System.out.println("sever stoped");
            }
        }
    }
}
