package com.ly.web;

import com.ly.entity.ApiResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @ResponseBody
    @RequestMapping(value = "/{id}/{name}",method = RequestMethod.GET)
    public ApiResult index(@PathVariable Integer id,@PathVariable String name){
        ApiResult apiResult = new ApiResult();
        apiResult.setCode("500");
        apiResult.setMsg("服务器错误！");
        System.out.println("--------index---------------");
        return  apiResult;
    }
}


