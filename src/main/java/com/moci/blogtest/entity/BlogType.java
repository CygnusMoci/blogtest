package com.moci.blogtest.entity;

/**
 * @author moci
 * @create 2017-11-27 2:58 PM
 **/
public class BlogType {
    private Integer id;
    private String type_name;
    private Integer order_num;

    public BlogType(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public Integer getOrder_num() {
        return order_num;
    }

    public void setOrder_num(Integer order_num) {
        this.order_num = order_num;
    }

    @Override
    public String toString() {
        return "BlogType{" +
                "id=" + id +
                ", type_name='" + type_name + '\'' +
                ", order_num=" + order_num +
                '}';
    }
}
