package com.ly.web.admin;

import com.ly.entity.ApiResult;
import com.ly.entity.TUser;

import com.ly.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@ResponseBody
@Controller
@RequestMapping("/admin")
public class LoginCopntroller {

    @Autowired
    private TUserService userService;

    /**
    用户登录
     */
    @PostMapping("/login")
    public ApiResult login(@RequestBody TUser loginuser, HttpSession session){
        ApiResult apiResult = new ApiResult();
        TUser user = userService.checkkUser(loginuser.getUsername(),loginuser.getPassword());
        if(user != null) {
            user.setPassword(null);
            session.setAttribute("user",user);
            apiResult.setCode("1");
            apiResult.setMsg("登录成功");
            apiResult.setData(user);
        }else {
            apiResult.setCode("0");
            apiResult.setMsg("用户名或密码错误！");
        }
        return  apiResult;
    }
    /**
     * 用户登出
     */
    @GetMapping("/logout")
    public ApiResult logout(HttpSession session){
        session.removeAttribute("user");
        ApiResult apiResult = new ApiResult();
        apiResult.setMsg("用户退出成功！");
        apiResult.setCode("1");
        return apiResult;
    }
}
