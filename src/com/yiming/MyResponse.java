package com.yiming;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @Program: MyTomcat
 * @Description:
 * @Author: YiMing
 * @Created: 2020/10/02 19:19
 */
public class MyResponse {
    private OutputStream outputStream;

    public MyResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void writer(String str) throws Exception {
        StringBuilder builder = new StringBuilder();
        builder.append("HTTP/1.1 200 OK\n")
                .append("Content-Type:text/html\n")
                .append("\r\n")
                .append("<html>")
                .append("<body>")
                .append("<h1>"+str+"</h1>")
                .append("</body>")
                .append("</html>");
        this.outputStream.write(builder.toString().getBytes());
        this.outputStream.flush();
        this.outputStream.close();
    }
}
