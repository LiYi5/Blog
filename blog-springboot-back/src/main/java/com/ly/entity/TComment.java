package com.ly.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * (TComment)实体类
 *
 * @author makejava
 * @since 2021-04-27 21:33:07
 */
@ToString
@Data
public class TComment implements Serializable {
    private static final long serialVersionUID = -66770425219042351L;
    
    private Long id;
    
    private String avatar;
    
    private String content;
    
    private Object creatTime;
    
    private String email;
    
    private String nickname;
    
    private Long blogId;
    
    private Long parentCommentId;


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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

}