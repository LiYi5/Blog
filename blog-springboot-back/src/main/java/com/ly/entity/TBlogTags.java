package com.ly.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * (TBlogTags)实体类
 *
 * @author makejava
 * @since 2021-04-28 11:28:24
 */
@ToString
@Data
public class TBlogTags implements Serializable {
    private static final long serialVersionUID = -92527168371760240L;
    
    private Long blogsId;
    
    private Long tagsId;


    public Long getBlogsId() {
        return blogsId;
    }

    public void setBlogsId(Long blogsId) {
        this.blogsId = blogsId;
    }

    public Long getTagsId() {
        return tagsId;
    }

    public void setTagsId(Long tagsId) {
        this.tagsId = tagsId;
    }

}