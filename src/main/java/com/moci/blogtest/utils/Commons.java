package com.moci.blogtest.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author moci
 * @create 2017-12-05 2:50 PM
 **/
@Component
public final class Commons {
//    private static ISiteService

    public static String THEME = "themes/default";
    private static final List EMPTY = new ArrayList(0);

    /**
     * 获取随机数
     * @param max
     * @param str
     * @return
     */
    public static String random(int max, String str) {
        return UUID.random(1, max) + str;
    }

}
