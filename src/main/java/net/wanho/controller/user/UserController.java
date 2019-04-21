package net.wanho.controller.user;

import com.alibaba.fastjson.JSON;
import net.wanho.pojo.User;
import net.wanho.service.user.UserService;
import net.wanho.utils.RegUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@RequestMapping("/douser")
public class UserController {


    @Autowired
    UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }
    @RequestMapping("/selectalluser")
    public String selectalluser(HttpSession session, User user)
    {
        logger.debug(user.toString());
        User currentuser = userService.selectByPrimaryKey(user.getTid());
        session.setAttribute("currentuser",currentuser);
        return "index";
    }


    @RequestMapping(value = "/toRegister",produces={"text/html;charset=UTF-8;","application/json;"})
    @ResponseBody
    public String  toRegister(String username, String password, String repassword,
                              String email, String phone, String realname, String indentified,
                              HttpServletRequest request,
                              String kaptcha){
        String loginname=username;
        username=realname;
        User user=new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        user.setEmail(email);
        user.setMobile(phone);
        user.setUsername(username);
        user.setIdentitycode(indentified);
        RegUtils.checkEmail(email);
        User users=userService.queryexUser(user);
        if(users!=null)
        {
            return "用户名已存在";
        }
        if(!RegUtils.checkEmail(email))
        {
            return "邮箱格式不正确";
        }

        if(!RegUtils.checkIdentityCodeReg(indentified))
        {
            return "身份证格式不正确";
        }

        if(!RegUtils.checkMobile(phone))
        {
            return "手机号格式不正确";
        }

        String kaptchaExpected = (String) request.getSession().getAttribute(
                com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        if(!kaptcha.equalsIgnoreCase(kaptchaExpected))
        {
            return "验证码错误";
        }
        if(!password.equals(repassword))
        {
            return "两此密码输入不一致";
        }
     return "true";
    }


    @RequestMapping("addUser")
    public String addUser(String username, String password, String repassword,
            String email, String phone, String realname, String indentified,HttpSession session)
    {
        String loginname=username;
        username=realname;
        User user=new User();
        user.setLoginname(loginname);
        user.setEmail(email);
        user.setMobile(phone);
        user.setUsername(username);
        user.setIdentitycode(indentified);
        String salt= UUID.randomUUID().toString();
        user.setPassword(userService.shiroMD5(user.getPassword(),salt));
        user.setSalt(salt);
        userService.insert(user);
        session.setAttribute("users",user);
        return "redirect:/show/Index";
    }

    @ResponseBody
    @RequestMapping("/ExistsUsername")
    public Object ExistsUsername(String username){


        User user=new User();
        user.setLoginname(username);
        User users=userService.queryexUser(user);
        return JSON.toJSONString(users);
    }
}
