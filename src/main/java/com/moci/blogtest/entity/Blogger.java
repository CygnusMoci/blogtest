package com.moci.blogtest.entity;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author moci
 * @create 2017-11-24 3:17 PM
 **/

@Getter
@Setter
@ToString
public class Blogger {
    private Integer id;
    private String  username;
    private Integer password;
    private String  email;
    public Blogger(){};



    
    public Integer getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
