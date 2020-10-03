package com.yiming;

import java.util.HashMap;

/**
 * @Program: MyTomcat
 * @Description:
 * @Author: YiMing
 * @Created: 2020/10/02 21:08
 */
public class MyMapping {
    private static HashMap<String, String> mapping = new HashMap<>();

    static {
        mapping.put("myTomcat", "com.yiming.MyServlet");
    }

    public HashMap<String, String> getMapping() {
        return mapping;
    }
}
