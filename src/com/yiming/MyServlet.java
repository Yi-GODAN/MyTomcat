package com.yiming;

/**
 * @Program: MyTomcat
 * @Description:
 * @Author: YiMing
 * @Created: 2020/10/02 21:39
 */
public class MyServlet extends MyHTTPServlet {
    @Override
    public void doGet(MyRequest request, MyResponse response) throws Exception {
        response.writer("get myTomcat");
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) throws Exception {
        response.writer("post myTomcat");
    }
}
