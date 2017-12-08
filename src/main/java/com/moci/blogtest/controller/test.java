package com.moci.blogtest.controller;

import java.util.Date;

/**
 * 测试函数
 * @author moci
 * @create 2017-11-28 4:50 PM
 **/
public class test {
    public static int getCurrentTime(){
        return (int)(new Date().getTime()/1000);
    }

    public static void main(String[] args) {


    }
}
