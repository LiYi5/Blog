package com.ly.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * (TType)实体类
 *
 * @author makejava
 * @since 2021-04-27 21:34:20
 */
@ToString
@Data
public class TType implements Serializable {
    private static final long serialVersionUID = 769320839654323869L;
    
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