package com.moci.blogtest.entity;

/**
 * @author moci
 * @create 2017-11-27 2:58 PM
 **/
public class Blog {
    private Integer id;
    private String title;
    private String content; //内容
    private Integer clickHit; //点击数

    public Blog(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getClickHit() {
        return clickHit;
    }

    public void setClickHit(Integer clickHit) {
        this.clickHit = clickHit;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", clickHit=" + clickHit +
                '}';
    }
}
