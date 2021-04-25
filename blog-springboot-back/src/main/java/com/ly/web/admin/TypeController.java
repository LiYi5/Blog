package com.ly.web.admin;

import com.ly.entity.ApiResult;
import com.ly.po.Type;
import com.ly.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@ResponseBody
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public ApiResult types(@PathParam("page") Integer page){
        ApiResult apiResult = new ApiResult();
        Sort sort = Sort.by(Sort.Direction.ASC,"id");
        Pageable pageable = PageRequest.of(page-1,7, sort);
        Page<Type> types = typeService.listType(pageable);
        apiResult.setCode("1");
        apiResult.setMsg("查询成功");
        apiResult.setData(types);
        return apiResult;
    }

    @PostMapping("/newtype")
    public ApiResult postType(@RequestBody Type type){
        List<Type> type1 = typeService.getType(type);
        ApiResult apiResult = new ApiResult();
        if(type1.size() !=0){
            apiResult.setCode("2");
            apiResult.setMsg("请勿重复添加");
        }else {
            Type t = typeService.saveType(type);
            if (t != null) {
                apiResult.setCode("1");
                apiResult.setMsg("添加分类类型成功");
            } else {
                apiResult.setCode("0");
                apiResult.setMsg("添加分类类型失败");
            }
        }
        return apiResult;
    }
    @PostMapping("/updateType")
    public ApiResult updateType(@RequestBody Type type){
        List<Type> type1 = typeService.getType(type);
        ApiResult apiResult = new ApiResult();
        if(type1.size() !=0){
            apiResult.setCode("2");
            apiResult.setMsg("该类型名称已存在");
        }else {
            Type type2 = typeService.updateType(type.getId(), type);
            if(type2 != null) {
                apiResult.setCode("1");
                apiResult.setMsg("修改分类类型成功");
            }else {
                apiResult.setCode("1");
                apiResult.setMsg("修改分类类型失败");
            }

        }
        return apiResult;
    }
    @PostMapping("/deleteType")
    public  ApiResult deleteType(@RequestBody Type type) {
        typeService.deleteType(type.getId());
        ApiResult apiResult = new ApiResult();
        apiResult.setMsg("删除成功");
        apiResult.setCode("1");
        return  apiResult;
    }
}
