package com.ly.entity;

import lombok.Data;

@Data
public class ApiResult {

    public String code;
    public String msg;
    public Object data;
}
