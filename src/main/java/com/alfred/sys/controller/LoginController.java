package com.alfred.sys.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.alfred.common.ResulObj;
import com.alfred.sys.domain.User;
import com.alfred.sys.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <p>
 *  前端控制器
 *  登录控制
 * </p>
 *
 * @author Alfred
 * @since 2020-03-14
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService iUserService;

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("login")
    @ResponseBody()
    public ResulObj login(String loginname, String pwd,String code, HttpSession session){

        Object codeSession = session.getAttribute("code");
        if(code!=null&&code.equals(codeSession)){
            QueryWrapper<User> objectQueryWrapper = new QueryWrapper<>();
            objectQueryWrapper.eq("loginname",loginname);
            objectQueryWrapper.eq("pwd",pwd);
            User user = iUserService.getOne(objectQueryWrapper);
            if(user!=null){
                session.setAttribute("user",user);
                return new ResulObj(200,"登录成功");
            }else {
                return new ResulObj(-1,"用户名或密码不正确");
            }
        }else {
            return new ResulObj(-1,"验证码错误");
        }
    }

    @RequestMapping("getCode")
    public void getCode(HttpServletResponse response,HttpSession session) throws IOException {
        //分别是图片的长宽和生成的4个字符和5条干扰线
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(116, 36,4,5);
        //获取到验证码
        String code = circleCaptcha.getCode();
        System.out.println("code = " + code);
        //放到session里
        session.setAttribute("code",code);

        ServletOutputStream outputStream = response.getOutputStream();

        circleCaptcha.write(outputStream);

        outputStream.close();
    }


}

