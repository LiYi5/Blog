package com.ly.web.admin;

import com.google.gson.Gson;
import com.ly.entity.ApiResult;
import com.ly.entity.TBlog;
import com.ly.entity.TType;
import com.ly.service.TBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@ResponseBody
@Controller
@RequestMapping("Blog")
public class BlogController {

    @Autowired
    private TBlogService tBlogService;

    @GetMapping("/Blogs")
    public ApiResult blogs(@PathParam("page") Integer page, @PathParam("title") String title,@PathParam("type") String type){
        ApiResult apiResult = new ApiResult();
        List<TBlog> tBlogs = tBlogService.queryBytitleOrType(page,8,title,type);
        apiResult.setCode("1");
        apiResult.setMsg("查询所有blog");
        apiResult.setData(tBlogs);
        return apiResult;
    }

    @GetMapping("/Blog")
    public ApiResult blog(@PathParam("page") Integer page){
        ApiResult apiResult = new ApiResult();
        List<TBlog> tBlogs = tBlogService.queryAllInfo(page,4);
        apiResult.setCode("1");
        apiResult.setMsg("查询所有blog");
        apiResult.setData(tBlogs);
        return apiResult;
    }
    @GetMapping("/totalBlogs")
    public ApiResult types(){
        ApiResult apiResult = new ApiResult();
        int totalBlog = tBlogService.getTotalBlog();
        apiResult.setCode("1");
        apiResult.setMsg("查询Blog总数量成功");
        apiResult.setData(totalBlog);
        return apiResult;
    }
    @PostMapping("/deleteBlog")
    public ApiResult deleteBlog(@RequestBody TBlog tBlog){
        boolean b = tBlogService.deleteById(tBlog.getId());
        ApiResult apiResult = new ApiResult();
        if(b){
            apiResult.setMsg("删除blog成功");
            apiResult.setCode("1");
        }else {
            apiResult.setMsg("删除blog失败");
            apiResult.setCode("0");
        }
        return  apiResult;

    }
    @PostMapping("/newBlog")
    public  ApiResult newBlog(@RequestBody String tBlog){
        Gson gson = new Gson();
        TBlog tBlog1 = gson.fromJson(tBlog, TBlog.class);
        TBlog tBlog2 = tBlogService.queryByBlog(tBlog1.getTitle());
        ApiResult apiResult = new ApiResult();
        if(tBlog2 == null ){
            Date nodate = new Date();
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            tBlog1.setCreatTime(Timestamp.valueOf(simpleDate.format(nodate)));
            tBlog1.setUpdateTime(Timestamp.valueOf(simpleDate.format(nodate)));
            if(tBlog1.getFirstPicture() == null) {
                tBlog1.setFirstPicture("https://img2.baidu.com/it/u=3806232450,3077456550&fm=26&fmt=auto&gp=0.jpg");
            }
            TBlog insert = tBlogService.insert(tBlog1);
            if(insert != null){
                apiResult.setCode("1");
                apiResult.setMsg("添加Blog成功");
            }else {
                apiResult.setCode("0");
                apiResult.setMsg("添加Blog失败");
            }
        }else {
            apiResult.setCode("0");
            apiResult.setMsg("已存在该题目");
        }
        return  apiResult;
    }

    @PostMapping("updateBlog")
    public  ApiResult updateBlog(@RequestBody TBlog tBlog){
        TBlog tBlog1 = tBlogService.queryById(tBlog.getId());
        ApiResult apiResult = new ApiResult();
        if(tBlog1 != null ){
            Date nodate = new Date();
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            tBlog1.setUpdateTime(Timestamp.valueOf(simpleDate.format(nodate)));
            TBlog insert = tBlogService.update(tBlog);
            if(insert != null){
                apiResult.setCode("1");
                apiResult.setMsg("修改Blog成功");
            }else {
                apiResult.setCode("0");
                apiResult.setMsg("修改Blog失败");
            }
        }else {
            apiResult.setCode("0");
            apiResult.setMsg("参数错误");
        }
        return  apiResult;
    }


    @PostMapping("/getBlogforType")
    public ApiResult getBlogforType(@RequestBody TType tType){
        List<TBlog> allBlog = tBlogService.queryByName(tType.getName());
        ApiResult apiResult = new ApiResult();
        apiResult.setCode("1");
        apiResult.setMsg("按分类查询成功！");
        apiResult.setData(allBlog);
        return  apiResult;
    }
}
