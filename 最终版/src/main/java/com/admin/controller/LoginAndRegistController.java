package com.admin.controller;

import com.common.util.validcode.CreateVerificationCode;
import com.common.util.validcode.CreateVerificationCodeImage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@Controller
@RequestMapping("/admin")
public class LoginAndRegistController {
    //放送验证码
    @RequestMapping("/imageCode")
    public void sendCodeImg(HttpServletRequest req, HttpServletResponse resp,HttpSession session) throws ServletException, IOException {
        String vericode= CreateVerificationCode.getSecurityCode();
        session.setAttribute("verityCode",vericode);
        //设置返回的内容
        System.out.println(session);
        resp.setContentType("img/jpeg");
        //浏览器不缓存响应内容--验证码图片，点一次就要刷新一次，所以不能有缓存出现
        resp.setHeader("Pragma","No-cache");
        resp.setHeader("Cache-Control","no-cache");
        //设置验证码失效时间
        resp.setDateHeader("Expires",0);
        //以字节流发过去，交给img的src属性去解析即可
        ImageIO.write(new CreateVerificationCodeImage(vericode).createImage(),"JPEG",resp.getOutputStream());
    }
    //后台登录
    @RequestMapping("/login")
    protected void login(HttpServletRequest req, HttpServletResponse resp,HttpSession session) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf8");
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String vericode=req.getParameter("vericode");
        String generatedCode= (String) session.getAttribute("verityCode");


        String ps1=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs?useUnicode=true&characterEncoding=UTF-8","root","root");
            PreparedStatement ps=connection.prepareStatement("select * from admin where user_name=?");
            ps.setString(1,name);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                // name1=rs.getString("user_name");
                ps1=rs.getString("password");
                // System.out.println(rs.getString("user_name"));
                // System.out.println(rs.getString("password"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (password.equals(ps1)&&vericode.toLowerCase().equals(generatedCode.toLowerCase())){
            //resp.getWriter().write("登录成功");
            resp.sendRedirect("/admin/index.action");
        }else {resp.getWriter().write("登录失败,请注册用户");}
    }
    @RequestMapping("/loginhtml")
    public String loginhtml(){
        return "admin/login";
    }
    @RequestMapping("/index")
    public String index(){
        return "admin/index";
    }
    @RequestMapping("/welcome")
    public String welcome(){
        return "admin/welcome";
    }
}
