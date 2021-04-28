package com.ly.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * (TBlog)实体类
 *
 * @author makejava
 * @since 2021-04-27 21:31:24
 */
@ToString
@Data
public class TBlog implements Serializable {
    private static final long serialVersionUID = -62040904976803079L;
    
    private Long id;
    
    private Object appreciation;
    
    private Object commenttabled;
    
    private String content;
    
    private Object creatTime;
    
    private String firstPicture;
    
    private String flag;
    
    private Object published;
    
    private Object recommend;
    
    private Object shareStatement;
    
    private String title;
    
    private Object updateTime;
    
    private Integer views;
    
    private Long typeId;
    
    private Long userId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(Object appreciation) {
        this.appreciation = appreciation;
    }

    public Object getCommenttabled() {
        return commenttabled;
    }

    public void setCommenttabled(Object commenttabled) {
        this.commenttabled = commenttabled;
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

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Object getPublished() {
        return published;
    }

    public void setPublished(Object published) {
        this.published = published;
    }

    public Object getRecommend() {
        return recommend;
    }

    public void setRecommend(Object recommend) {
        this.recommend = recommend;
    }

    public Object getShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(Object shareStatement) {
        this.shareStatement = shareStatement;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}