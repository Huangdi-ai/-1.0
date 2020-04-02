package com.bbs.controller;

import com.bbs.dao.UserDao;
import com.bbs.dao.impl.UserDaoImpl;
import com.bbs.service.UserserService;
import com.bbs.service.impl.UserServiceimpl;
import com.common.constant.Constant;
import com.common.pojo.User;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginController{
    @Autowired
    private UserserService userserService;
    @Autowired
    private UserDao userDao;
    @RequestMapping("/loginjsp")
    public String loginjsp(){
        return Constant.LoginAndRegisterPrefixJSP+"login.jsp";
    }
    @RequestMapping("/registjsp")
    public String registjsp(){
        return Constant.LoginAndRegisterPrefixJSP+"regist.jsp";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("username",null);
        return "redirect:/index.action";
    }
    @RequestMapping("/login")
    //@RequestMapping(value = "/login",method = RequestMethod.POST)
    public String Login(User user, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
         String use;
         String pass;
         String email;
        use=request.getParameter("username");
        pass=request.getParameter("password");
        System.out.println(use);
        //int result = userDao.login(use,pass);
        //System.out.println(result);
        if (userDao.login(use,pass) >0){
            //int level = blackListSerlmpl.getLevel(result);
            session.setAttribute("username", use);
            session.setAttribute("userId",userDao.login(use,pass));

            return "redirect:/index.action";
        }
        if(userDao.login(use,pass)==0) return Constant.LoginAndRegisterPrefixJSP+"login_unfind.jsp";
        else
            return Constant.LoginAndRegisterPrefixJSP+"login_false.jsp";
    }


    @RequestMapping("/changejsp")
    public String cuy(){ return Constant.LoginAndRegisterPrefixJSP+"change.jsp"; }

    @RequestMapping(value = "change")
    public String Change(User user,HttpSession session) throws IOException {
        user.setId((Integer) session.getAttribute("userId"));
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();

        if (username != null || password != null || email != null) {

            if (username != null && username.length() > 0)
                user.setUsername(username);
            if (email != null && email.length() > 0)
                user.setEmail(email);
            if (password != null && password.length() > 0)
                user.setPassword(password);
            switch (userserService.isExist(user)) {
                case 1:
                    int id1 = userserService.getUserIdByUsername(username);
                    if (id1 != -1 && id1 != user.getId()) {
                        System.out.println("该用户已存在");
                        //addFieldError("username", "该用户名已存在");
                        return Constant.LoginAndRegisterPrefixJSP + "change_false";
                    }

                case 2:
                    int id2 = userserService.getUserIdByEmail(email);
                    System.out.println("id2");
                    if (id2 != -1 && id2 != user.getId()) {
                        System.out.println("该邮箱已存在");
                        // addFieldError("email", "该邮箱已存在");
                        return "#";
                    }
                default:
                    break;
            }
            System.out.println(user.getUsername());
            System.out.println(user.getSex());
            userserService.update(user);
            return Constant.LoginAndRegisterPrefixJSP+"change_success.jsp";
        }
        return Constant.LoginAndRegisterPrefixJSP+"change.jsp";
    }
    @RequestMapping("/lala")
    public String haha(ModelMap map,int id){
        map.put("id",id);
        return Constant.LoginAndRegisterPrefixJSP+"change.jsp";
    }

}
