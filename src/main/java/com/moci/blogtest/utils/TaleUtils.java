package com.moci.blogtest.utils;

import com.moci.blogtest.constant.WebConst;
import com.moci.blogtest.entity.Blogger;
import com.moci.blogtest.exception.TipException;
import org.apache.commons.lang3.StringUtils;
import org.commonmark.node.Node;
import org.commonmark.renderer.html.HtmlRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.commonmark.parser.Parser;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.awt.*;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 原Tale主页的工具类,进行一部分的注释与修改
 * @author moci
 * @create 2017-12-07 9:52 AM
 **/
public class TaleUtils {
    //配置日志组件
    private static final Logger LOGGER = LoggerFactory.getLogger(TaleUtils.class);
    //定义数据源
    private static DataSource newDataSource;

    /**
     * 一个月的秒数
     */
    private static final int one_month = 30 * 24 * 60 * 60;

    /**
     * 邮箱的正则表达式
     * （可以在其他地方用上）
     */
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static final Pattern SLUG_REGEX = Pattern.compile("^[A-Za-z0-9_-]{5,100}$", Pattern.CASE_INSENSITIVE);

    /**
     * markdown解析器
     * (并不懂是什么玩意)
     */
    private static Parser parser = Parser.builder().build();

    /**
     * 获取文件目录
     */
    private static String location = TaleUtils.class.getClassLoader().getResource("").getPath();

    public static boolean isEmail(String emailStr){
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr); //利用正则表达式判断
        return matcher.find();
    }

    /**
     * 获取当前时间
     * @return
     */
    public static int getCurrentTime(){
        return (int)(new Date().getTime()/1000);
    }


    public static Properties getProFromJar(String fileName){
        Properties properties = new Properties();
        try {
            InputStream resourceAsStream = TaleUtils.class.getClassLoader().getResourceAsStream(fileName);
            if (resourceAsStream == null) {
                throw new TipException("从源获取数据失败");
            }
            properties.load(resourceAsStream);
        } catch (TipException | IOException e){
            LOGGER.error("获取属性失败",e.getMessage());
        }
        return properties;
    }

    /**
     * md5加密
     *
     * @param source 数据源
     * @return 加密字符串
     */
    public static String MD5encode(String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        }
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ignored) {
        }
        byte[] encode = messageDigest.digest(source.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte anEncode : encode) {
            String hex = Integer.toHexString(0xff & anEncode);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
    /**
     * 返回当前登录用户
     *
     * @return
     */
    public static Blogger getLoginUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (null == session) {
            return null;
        }
        return (Blogger) session.getAttribute(WebConst.LOGIN_SESSION_KEY);
    }











    /*以下都是瞎瘠薄复制的，因为我也不知道哪里可以用上*/



    /**
     * 从cookies中获取指定cookie
     *
     * @param name    名称
     * @param request 请求
     * @return cookie
     */
    private static Cookie cookieRaw(String name, HttpServletRequest request) {
        javax.servlet.http.Cookie[] servletCookies = request.getCookies();
        if (servletCookies == null) {
            return null;
        }
        for (javax.servlet.http.Cookie c : servletCookies) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    /**
     * 提取html中的文字
     *
     * @param html
     * @return
     */
    public static String htmlToText(String html) {
        if (StringUtils.isNotBlank(html)) {
            return html.replaceAll("(?s)<[^>]*>(\\s*<[^>]*>)*", " ");
        }
        return "";
    }

    /**
     * markdown转换为html
     *
     * @param markdown
     * @return
     */
    public static String mdToHtml(String markdown) {
        if (StringUtils.isBlank(markdown)) {
            return "";
        }
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String content = renderer.render(document);
        content = Commons.emoji(content);

        // TODO 支持网易云音乐输出
//        if (TaleConst.BCONF.getBoolean("app.support_163_music", true) && content.contains("[mp3:")) {
//            content = content.replaceAll("\\[mp3:(\\d+)\\]", "<iframe frameborder=\"no\" border=\"0\" marginwidth=\"0\" marginheight=\"0\" width=350 height=106 src=\"//music.163.com/outchain/player?type=2&id=$1&auto=0&height=88\"></iframe>");
//        }
        // 支持gist代码输出
//        if (TaleConst.BCONF.getBoolean("app.support_gist", true) && content.contains("https://gist.github.com/")) {
//            content = content.replaceAll("&lt;script src=\"https://gist.github.com/(\\w+)/(\\w+)\\.js\">&lt;/script>", "<script src=\"https://gist.github.com/$1/$2\\.js\"></script>");
//        }
        return content;
    }

        /**
         * 判断是否是合法路径
         *
         * @param slug
         * @return
         */
    public static boolean isPath(String slug) {
        if (StringUtils.isNotBlank(slug)) {
            if (slug.contains("/") || slug.contains(" ") || slug.contains(".")) {
                return false;
            }
            Matcher matcher = SLUG_REGEX.matcher(slug);
            return matcher.find();
        }
        return false;
    }

    /**
     * 判断文件是否是图片类型
     *
     * @param imageFile
     * @return
     */
    public static boolean isImage(InputStream imageFile) {
        try {
            Image img = ImageIO.read(imageFile);
            if (img == null || img.getWidth(null) <= 0 || img.getHeight(null) <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 随机数
     *
     * @param size
     * @return
     */
    public static String getRandomNumber(int size) {
        String num = "";

        for (int i = 0; i < size; ++i) {
            double a = Math.random() * 9.0D;
            a = Math.ceil(a);
            int randomNum = (new Double(a)).intValue();
            num = num + randomNum;
        }

        return num;
    }

    /**
     * 获取保存文件的位置,jar所在目录的路径
     *
     * @return
     */
    public static String getUplodFilePath() {
        String path = TaleUtils.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        path = path.substring(1, path.length());
        try {
            path = java.net.URLDecoder.decode(path, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int lastIndex = path.lastIndexOf("/") + 1;
        path = path.substring(0, lastIndex);
        File file = new File("");
        return file.getAbsolutePath() + "/";
    }
}

