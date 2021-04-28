package com.ly.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * (TTag)实体类
 *
 * @author makejava
 * @since 2021-04-27 21:33:21
 */
@ToString
@Data
public class TTag implements Serializable {
    private static final long serialVersionUID = 784428146944668338L;
    
    private Long id;
    
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}