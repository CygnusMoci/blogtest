//package com.moci.blogtest.controller;
//
//
//import com.moci.blogtest.service.BlogService;
//import com.moci.blogtest.service.BlogTypeService;
//import com.moci.blogtest.service.BloggerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * @author moci
// * @create 2017-12-05 5:39 PM
// **/
//@Controller
//public class Index {
//    @Autowired
//    @Qualifier("bloggerService")
//    private BloggerService bloggerService;// 负责博主信息
//
//
//    @Autowired
//    @Qualifier("blogTypeService")
//    private BlogTypeService blogTypeService;
//
//    @Autowired
//    @Qualifier("blogService")
//    private BlogService blogService;
//
////    @GetMapping(value = {"/", "index"})
////    public String index(HttpServletRequest request, @RequestParam(value = "limit", defaultValue = "12") int limit) {
////        return this.index(request, 1, limit);
////    }
//
////    @GetMapping(value = "page/{p}")
////    public String index(HttpServletRequest request, @PathVariable int p, @RequestParam(value = "limit", defaultValue = "12") int limit) {
////
////        return this.render("index");
////    }
//}
