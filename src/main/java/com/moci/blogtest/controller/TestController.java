package com.moci.blogtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author moci
 * @create 2017-12-06 3:04 PM
 **/
@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(){
        System.out.println("************T E S T**************");
        return "test";
    }
}
