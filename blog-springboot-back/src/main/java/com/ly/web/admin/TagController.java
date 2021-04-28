package com.ly.web.admin;


import com.ly.entity.ApiResult;
import com.ly.entity.TTag;
import com.ly.entity.TType;
import com.ly.service.TTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@ResponseBody
@Controller
@RequestMapping("/Tag")
public class TagController {

    @Autowired
    private TTagService tTagService;

    @GetMapping("/Tags")
    public ApiResult types(@PathParam("page") Integer page){
        ApiResult apiResult = new ApiResult();
        List<TTag> tTags = tTagService.queryAllByLimit((page-1)*8, 8);
        apiResult.setCode("1");
        apiResult.setMsg("查询成功");
        apiResult.setData(tTags);
        return apiResult;
    }

    @GetMapping("/totalTags")
    public ApiResult types(){
        ApiResult apiResult = new ApiResult();
        int totalType = tTagService.getTotalType();
        apiResult.setCode("1");
        apiResult.setMsg("查询标签总数量成功");
        apiResult.setData(totalType);
        return apiResult;
    }

    @PostMapping("/newTag")
    public ApiResult postType(@RequestBody TTag tTag){
        boolean have = tTagService.getTag(tTag);
        ApiResult apiResult = new ApiResult();
        if(have){
            apiResult.setCode("2");
            apiResult.setMsg("请勿重复添加标签");
        }else {
            TTag insert = tTagService.insert(tTag);
            if (insert != null) {
                apiResult.setCode("1");
                apiResult.setMsg("添加标签名称成功");
            } else {
                apiResult.setCode("0");
                apiResult.setMsg("添加标签名称失败");
            }
        }
        return apiResult;
    }


    @PostMapping("/updateTag")
    public ApiResult updateType(@RequestBody TTag tTag){
        boolean have = tTagService.getTag(tTag);
        ApiResult apiResult = new ApiResult();
        if(have){
            apiResult.setCode("2");
            apiResult.setMsg("该标签名称已存在");
        }else {
            TTag update = tTagService.update(tTag);
           if(update != null) {
                apiResult.setCode("1");
                apiResult.setMsg("修改标签名称成功");
            }else {
                apiResult.setCode("0");
                apiResult.setMsg("修改标签名称失败");
            }

        }
        return apiResult;
    }

    @PostMapping("/deleteTag")
    public  ApiResult deleteType(@RequestBody TTag tTag) {
        boolean b = tTagService.deleteById(tTag.getId());
        ApiResult apiResult = new ApiResult();
        if(b){
            apiResult.setMsg("删除标签成功");
            apiResult.setCode("1");
        }else{
            apiResult.setMsg("删除标签失败");
            apiResult.setCode("0");
        }
        return  apiResult;
    }

    @GetMapping("/AllTags")
    public ApiResult allTypes() {
        List<TTag> allTag = tTagService.getAllTag();
        ApiResult apiResult = new ApiResult();
        if(allTag.size() == 0){
            apiResult.setCode("0");
            apiResult.setMsg("请添加标签");
        }else {
            apiResult.setCode("1");
            apiResult.setMsg("查询所有标签成功");
            apiResult.setData(allTag);
        }
        System.out.println(apiResult);
        return  apiResult;
    }
}
