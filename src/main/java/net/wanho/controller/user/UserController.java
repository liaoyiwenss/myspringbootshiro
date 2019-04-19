package net.wanho.controller.user;

import net.wanho.pojo.User;
import net.wanho.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/douser")
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }
    @RequestMapping("/selectalluser")
    public String selectalluser(HttpSession session, User user)
    {
        System.out.println(user.toString());
        User currentuser = userService.selectByPrimaryKey(user.getTid());
        session.setAttribute("currentuser",currentuser);
        return "index";
    }


}
