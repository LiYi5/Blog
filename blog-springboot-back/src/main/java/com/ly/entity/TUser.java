package com.ly.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * (TUser)实体类
 *
 * @author makejava
 * @since 2021-04-27 21:34:33
 */
@ToString
@Data
public class TUser implements Serializable {
    private static final long serialVersionUID = -85721883033456292L;
    
    private Long id;
    
    private String avatar;
    
    private Object creatTime;
    
    private String email;
    
    private String niackname;
    
    private String password;
    
    private Integer type;
    
    private Object updateTime;
    
    private String username;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Object getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Object creatTime) {
        this.creatTime = creatTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNiackname() {
        return niackname;
    }

    public void setNiackname(String niackname) {
        this.niackname = niackname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Object getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}