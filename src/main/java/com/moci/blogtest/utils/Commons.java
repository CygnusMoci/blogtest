package com.moci.blogtest.utils;

import com.vdurmont.emoji.EmojiParser;
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

    /**
     * An :grinning:awesome :smiley:string &#128516;with a few :wink:emojis!
     * <p>
     * 这种格式的字符转换为emoji表情
     * @param value
     * @return
     */
    public static String emoji(String value) {
        return EmojiParser.parseToUnicode(value);
    }

    /**
     * 测试
     * @return
     */
    public static String test(){

        return "这是个component测试";
    }
}
