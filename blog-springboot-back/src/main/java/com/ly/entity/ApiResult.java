package com.ly.entity;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ApiResult {

    public String code;
    public String msg;
    public Object data;
}
