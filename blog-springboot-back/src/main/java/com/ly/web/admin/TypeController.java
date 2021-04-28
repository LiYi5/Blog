package com.ly.web.admin;

import com.ly.entity.ApiResult;
import com.ly.entity.TType;
import com.ly.service.TTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.lang.reflect.Type;
import java.util.List;


@ResponseBody
@Controller
@RequestMapping("/Type")
public class TypeController {

    @Autowired
    private TTypeService tTypeService;

    @GetMapping("/Types")
    public ApiResult types(@PathParam("page") Integer page){
        ApiResult apiResult = new ApiResult();
        List<TType> tTypes = tTypeService.queryAllByLimit((page-1)*8, 8);
        apiResult.setCode("1");
        apiResult.setMsg("查询成功");
        apiResult.setData(tTypes);
        return apiResult;
    }

    @GetMapping("/totalTypes")
    public ApiResult types(){
        ApiResult apiResult = new ApiResult();
        int totalType = tTypeService.getTotalType();
        apiResult.setCode("1");
        apiResult.setMsg("查询分类总数量成功");
        apiResult.setData(totalType);
        return apiResult;
    }


    @PostMapping("/newType")
    public ApiResult postType(@RequestBody TType tType){
        boolean hava = tTypeService.getType(tType);
        ApiResult apiResult = new ApiResult();
        if(hava){
            apiResult.setCode("2");
            apiResult.setMsg("请勿重复添加分类类型");
        }else {
            TType insert = tTypeService.insert(tType);
            if (insert != null) {
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
    public ApiResult updateType(@RequestBody TType tType){
        boolean hava = tTypeService.getType(tType);
        ApiResult apiResult = new ApiResult();
        if(hava){
            apiResult.setCode("2");
            apiResult.setMsg("该分类名称已存在");
        }else {
            TType update = tTypeService.update(tType);
            if(update != null) {
                apiResult.setCode("1");
                apiResult.setMsg("修改分类类型成功");
            }else {
                apiResult.setCode("0");
                apiResult.setMsg("修改分类类型失败");
            }

        }
        return apiResult;
    }

    @PostMapping("/deleteType")
    public  ApiResult deleteType(@RequestBody TType tType) {
        boolean b = tTypeService.deleteById(tType.getId());
        ApiResult apiResult = new ApiResult();
        if(b){
            apiResult.setMsg("删除分类类型成功");
            apiResult.setCode("1");
        }else {
            apiResult.setMsg("删除分类类型失败");
            apiResult.setCode("0");
        }
        return  apiResult;
    }

    @GetMapping("/AllTypes")
    public ApiResult allTypes() {
        List<TType> allType = tTypeService.getAllType();
        ApiResult apiResult = new ApiResult();
        if(allType.size() == 0){
            apiResult.setCode("0");
            apiResult.setMsg("请添加分类");
        }else {
            apiResult.setCode("1");
            apiResult.setMsg("查询所有分类成功");
            apiResult.setData(allType);
        }
        System.out.println(apiResult);
        return  apiResult;
    }
}
