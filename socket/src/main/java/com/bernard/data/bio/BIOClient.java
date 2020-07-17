package com.bernard.data.bio;



import java.io.*;
import java.net.Socket;

public class BIOClient {
    private static final int PORT = 9090;
    private static final int COUNT = 10;

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", PORT);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String order1 = "getNow";
        out.println(order1);
        System.out.println("client send order : " + order1);
        String readLine1 = in.readLine();
        System.out.println("client receive result : " + readLine1);

        if (socket != null) {
            socket.close();
            socket = null;
        }
    }
}
