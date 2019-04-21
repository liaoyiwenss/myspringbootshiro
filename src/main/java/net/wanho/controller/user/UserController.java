package net.wanho.controller.user;

import net.wanho.pojo.User;
import net.wanho.service.user.UserService;
import net.wanho.utils.RegUtils;
import org.apache.shiro.web.session.HttpServletSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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


    @RequestMapping("/toRegister")
    public String  toRegister(String username, String password, String repassword,
                              String email, String phone, String realname, String indentified,
                              HttpServletRequest request, HttpServletSession session,
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
        boolean flag1= RegUtils.checkEmail(email);

        boolean flag2=RegUtils.checkIdentityCodeReg(indentified);

        boolean flag3=RegUtils.checkMobile(phone);

        boolean flag6=false;

        String kaptchaExpected = (String) request.getSession().getAttribute(
                com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        if (kaptcha.equalsIgnoreCase(kaptchaExpected)) {
            flag6=true;
            request.setAttribute("Registinfo","验证码错误！");
        }

        User users=userService.queryexUser(user);
        boolean flag4=true;
        boolean flag5=true;
        if(!password.equals(repassword))
        {
            flag5=false;
        }
        if(users!=null)
        {
            flag4=false;
            request.setAttribute("Registinfo","用户名已存在！");
        }
        if(flag1&&flag2&&flag3&&flag4&&flag5&&flag6)
        {
            userService.insert(user);
            session.setAttribute("users", user);
            logger.debug(user.getLoginname());
            logger.debug(user.getPassword());
            return "show/Login";
        }else
        {
            logger.debug("flag1:"+flag1);
            logger.debug("flag2"+flag2);
            logger.debug("flag3"+flag3);
            logger.debug("flag4"+flag4);
            logger.debug("flag5"+flag5);
            return "show/Regist";
        }
    }



    @RequestMapping("/ExistsUsername")
    @ResponseBody
    public Object ExistsUsername(String username){


        User user=new User();
        user.setLoginname(username);
        User users=userService.queryexUser(user);

        return users;
    }
}
