package com.moci.blogtest.entity;

import org.springframework.stereotype.Component;

/**
 * @author moci
 * @create 2017-12-08 9:33 AM
 **/
@Component
public class Test {
    private String name;
    private Integer Tid;
    public Test(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTid() {
        return Tid;
    }

    public void setTid(Integer tid) {
        Tid = tid;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", Tid=" + Tid +
                '}';
    }


}
