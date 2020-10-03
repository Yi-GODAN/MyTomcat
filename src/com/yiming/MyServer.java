package com.yiming;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Program: MyTomcat
 * @Description:
 * @Author: YiMing
 * @Created: 2020/10/02 21:50
 */
public class MyServer {

    public static void StartServer(int port) throws Exception {

        //定义服务套接字
        ServerSocket serverSocket = new ServerSocket(port);
        //定义客户端套接字
        Socket socket = null;

        while (true) {
            socket = serverSocket.accept();

            //获取输入流和输出流
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            //定义请求对象
            MyRequest request = new MyRequest(inputStream);
            //定义响应对象
            MyResponse response = new MyResponse(outputStream);

            String clazz = new MyMapping().getMapping().get(request.getRequestUrl());
            if (clazz != null) {
                Class<MyServlet> myServletClass = (Class<MyServlet>) Class.forName(clazz);
                //根据myServletClass创建对象
                MyServlet myServlet = myServletClass.getDeclaredConstructor().newInstance();
                myServlet.service(request, response);
            }
        }
    }

    public static void main(String[] args) {
        try {
            StartServer(10086);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
